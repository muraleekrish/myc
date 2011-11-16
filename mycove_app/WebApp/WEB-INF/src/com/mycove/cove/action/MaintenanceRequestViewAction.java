package com.mycove.cove.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;

import com.mycove.cove.form.MaintenanceRequestForm;
import com.mycove.cove.trans.CloseMaintenceRequest;
import com.mycove.dao.ApartmentDAO;
import com.mycove.dao.MaintenanceRequestDAO;
import com.mycove.util.util.FormUtil;
import com.mycove.vo.MaintenanceRequest;

public class MaintenanceRequestViewAction extends LookupDispatchAction {
	
	/* (non-Javadoc)
	 * @see org.apache.struts.actions.DispatchAction#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String action = "input";
		if (form instanceof MaintenanceRequestForm) {
			try {
				System.out.println(request.getParameter(mapping.getParameter()));
				if (FormUtil.isNotNull(mapping.getParameter()) 
						&& FormUtil.isNotNull(request.getParameter(mapping.getParameter())) 
						&& request.getParameter(mapping.getParameter()).equalsIgnoreCase("Close Request")){
					return this.close(mapping, form, request, response);
				} 
				else
				{
					return this.view(mapping, form, request, response);
				}
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		} else {
			action = "input";
		}
		return mapping.findForward(action);
	}

	
	public ActionForward view(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String action = "input";
		Long maintenanceReqId  = 0L;
		MaintenanceRequestForm mainfrm = (MaintenanceRequestForm) form;
		
	    maintenanceReqId = Long.parseLong(request.getParameter("requestId"));
	    System.out.println("ff"+ maintenanceReqId);
		MaintenanceRequestDAO mainDAO = new MaintenanceRequestDAO();
		ApartmentDAO aptDAO = new ApartmentDAO();
		MaintenanceRequest main = mainDAO.findById(maintenanceReqId);
		
		mainfrm.setApartment((main.getApartment().getApartmentNumber()));
		mainfrm.setContactNo(FormUtil.setNullToBlank(main.getDayTimeContactNo()));
		mainfrm.setName(FormUtil.setNullToBlank(main.getCreatedBy()));
		mainfrm.setMaintenanceRequest(FormUtil.setNullToBlank(main.getMaintenanceRequest()));
		mainfrm.setMaintenanceLocation(FormUtil.setNullToBlank(main.getMaintenanceLocation()));
		mainfrm.setDescription(FormUtil.setNullToBlank(main.getProblem()));
		mainfrm.setPermission((main.getEntryPermission()));
		mainfrm.setId(String.valueOf(maintenanceReqId));
		
		action = "input";
		return mapping.findForward(action);
	}
	public ActionForward close(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    System.out.println("111111");
			MaintenanceRequestForm mainfrm = (MaintenanceRequestForm) form;
			MaintenanceRequestDAO mainDAO = new MaintenanceRequestDAO();
			MaintenanceRequest maintenanceRequest = mainDAO.findById(Long.parseLong(mainfrm.getId()));
			maintenanceRequest.setCloseFlag(true);
			maintenanceRequest.setClosedDate(new Timestamp(new Date().getTime()));
			maintenanceRequest.setModifiedBy((String) request.getSession().getAttribute("userName"));
			maintenanceRequest.setModifiedDate(new Timestamp(new Date().getTime()));
			CloseMaintenceRequest closeMaintenceRequest = new CloseMaintenceRequest(maintenanceRequest, (Long)request.getSession().getAttribute("userId"));
			closeMaintenceRequest.execute();
			mainDAO.update(maintenanceRequest);
			return mapping.findForward("success");
	}
	
	/* (non-Javadoc)
	 * @see org.apache.struts.actions.LookupDispatchAction#getKeyMethodMap()
	 */
	@Override
	protected Map<String, String> getKeyMethodMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("button.close", "close");
		return map;
	}
}
