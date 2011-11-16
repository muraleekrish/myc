package com.mycove.cove.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.LookupDispatchAction;

import com.mycove.cove.form.MaintenanceRequestForm;
import com.mycove.cove.sms.CreateMaintenceRequestSMS;
import com.mycove.cove.sms.SmsUtil;
import com.mycove.cove.trans.CreateMaintenceRequest;
import com.mycove.dao.ApartmentDAO;
import com.mycove.dao.MaintenanceRequestDAO;
import com.mycove.dao.UserDAO;
import com.mycove.util.util.FormUtil;
import com.mycove.vo.Apartment;
import com.mycove.vo.MaintenanceRequest;
import com.mycove.vo.User;

public class MaintenanceRequestAction extends LookupDispatchAction {
	
	/* (non-Javadoc)
	 * @see org.apache.struts.actions.DispatchAction#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		 
		if(request.getSession().getAttribute("userId")==null)
	    {
			
			System.out.println("userid123"+request.getSession().getAttribute("userId"));
	        response.sendRedirect("/sec/Login.do");
	    
	    }
		Long aptid = (Long) request.getSession().getAttribute("aptID");
		MaintenanceRequestForm maintenfrm = (MaintenanceRequestForm) form;
		ApartmentDAO aptDAO = new ApartmentDAO();
		Apartment Apt = aptDAO.findById(aptid);
	    maintenfrm.setApartment(Apt.getApartmentNumber());
	     HttpSession session = request.getSession();
	     session.setAttribute("ApartmentNo", maintenfrm.getApartment());
	     System.out.println("userid"+request.getSession().getAttribute("userId"));
	     
	    	    
	    System.out.println("a:"+request.getParameter("r:"+mapping.getParameter()));
		if (FormUtil.isNotNull(request.getParameter(mapping.getParameter())) 
				&& request.getParameter(mapping.getParameter()).equals("Submit")) {
			 System.out.println("/////"+request.getParameter(mapping.getParameter()));
			return this.submit(mapping, form, request, response);
		} else {
			UserDAO userDAO = new UserDAO();
			User user = userDAO.findById((Long) request.getSession().getAttribute("userId"));
			MaintenanceRequestForm requestForm = new MaintenanceRequestForm();
			requestForm = (MaintenanceRequestForm) form;
			requestForm.setContactNo(user.getHomePhone());
			return mapping.findForward("input");
		}
	}

	public ActionForward submit(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
			    
		if (form instanceof MaintenanceRequestForm) {
			ActionMessages messages = new ActionMessages();
			MaintenanceRequestForm maintenfrm = (MaintenanceRequestForm) form;
			ActionErrors actionErrors = maintenfrm.validate(mapping, request);
			if(actionErrors.isEmpty())
			{
				Long aptid = (Long) request.getSession().getAttribute("aptID");
				try {
					
					MaintenanceRequestDAO maintenanceRequestDAO = new MaintenanceRequestDAO();
					MaintenanceRequest maintenanceRequest = new MaintenanceRequest();
					
					maintenanceRequest = this.mapFormToVO(maintenfrm, maintenanceRequest, aptid, (String) request.getSession().getAttribute("userName"));
					maintenanceRequestDAO.save(maintenanceRequest);
					
					CreateMaintenceRequest createMaintenceRequest = new CreateMaintenceRequest(maintenanceRequest, (Long) request.getSession().getAttribute("userId"));
					createMaintenceRequest.execute();
					CreateMaintenceRequestSMS createMaintenceRequestSMS = new CreateMaintenceRequestSMS(maintenanceRequest, (Long) request.getSession().getAttribute("userId"));
					createMaintenceRequestSMS.execute();
					reset(mapping,request);
					messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("main.Updated"));
					saveMessages(request, messages); 
					request.setAttribute("message", "message");
					maintenfrm.setMaintenanceLocation("");
					maintenfrm.setMaintenanceRequest("");
					maintenfrm.setDescription("");
				    maintenfrm.setPermission(false);
					return mapping.findForward("success");
                     
				} catch (Exception e) {
					log.error(e.getMessage(), e);
				}
			}
			else
			{
				saveErrors(request, actionErrors);
				return mapping.findForward("input");
			}
		}
	    
		return mapping.findForward("input");
	      
	}
	
	private void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @param maintenanceRequestForm
	 * @param maintenanceRequest
	 * @param aptid
	 * @param userName 
	 * @return
	 */
	private MaintenanceRequest mapFormToVO(MaintenanceRequestForm maintenanceRequestForm, MaintenanceRequest maintenanceRequest, Long aptid, String userName) {

		ApartmentDAO aptDAO = new ApartmentDAO();
		Apartment apartment = aptDAO.findById(aptid);
		maintenanceRequest.setApartment(apartment);
		maintenanceRequest.setProperty(apartment.getBuilding().getProperty());
		maintenanceRequest.setMaintenanceDay(FormUtil.getDate(new Date()));
		maintenanceRequest.setMaintenanceMonth(FormUtil.getMonth(new Date()));
		maintenanceRequest.setMaintenanceYear(FormUtil.getYear(new Date()));
		maintenanceRequest.setProblem(maintenanceRequestForm.getDescription());
		maintenanceRequest.setMaintenanceLocation(maintenanceRequestForm.getMaintenanceLocation());
		maintenanceRequest.setDayTimeContactNo(maintenanceRequestForm.getContactNo());
		maintenanceRequest.setMaintenanceRequest(maintenanceRequestForm.getMaintenanceRequest());
		maintenanceRequest.setEntryPermission(maintenanceRequestForm.isPermission());
		maintenanceRequest.setCreatedBy(userName);
		maintenanceRequest.setCreatedDate(new Timestamp(new Date().getTime()));
		maintenanceRequest.setModifiedBy(userName);
		maintenanceRequest.setModifiedDate(new Timestamp(new Date().getTime()));
		return maintenanceRequest;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.actions.LookupDispatchAction#getKeyMethodMap()
	 */
	@Override
	protected Map<String, String> getKeyMethodMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("button.submit", "submit");
		return map;
	}
}
