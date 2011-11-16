package com.mycove.cove.action;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.mycove.cove.form.TenantProfileForm;
import com.mycove.cove.trans.WelcomeMailtoResident;
import com.mycove.dao.ApartmentDAO;
import com.mycove.dao.BaseDAO;
import com.mycove.dao.RoleDAO;
import com.mycove.dao.TenantDAO;
import com.mycove.util.util.FormUtil;
import com.mycove.vo.Apartment;
import com.mycove.vo.Tenant;

public class TenantProfileAction extends LookupDispatchAction {
	@Override
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String action = "failure";
		try {
			if (form instanceof TenantProfileForm) {
				Long residentId = this.getResidentId(request);
				String formAction = this.getFormAction(request);
				
				ApartmentDAO apartmentDAO = new ApartmentDAO();
				List<Apartment> apartments = apartmentDAO.getAllApartmentByPropertyManagerId((Long)request.getSession().getAttribute("userId"));
				
				request.setAttribute("apartments", apartments);
				TenantProfileForm tenantFrm = (TenantProfileForm) form;

				if (FormUtil.isNotNull(request.getParameter(mapping.getParameter()))
						&& request.getParameter(mapping.getParameter()).equals("Update")) {
					return this.update(mapping, form, request, response);
				} else if (FormUtil.isNotNull(request.getParameter(mapping.getParameter()))
						&& request.getParameter(mapping.getParameter()).equals("Save")) {
					return this.add(mapping, form, request, response);
				} else {
					if (residentId != 0L)
					{
						TenantDAO tenantdao = new TenantDAO();
						Tenant tenant = tenantdao.findById(residentId);
						tenantFrm = this.mapVOToForm(tenant, tenantFrm);
					}
				}
				
				if (formAction.equalsIgnoreCase("edit")) {
					action = "input";
				} else if (formAction.equalsIgnoreCase("add")) {
					action = "input";
				} else if (formAction.equalsIgnoreCase("update")) {
					action = "input";
				} else {
					action = "input";
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return mapping.findForward(action);
	}
	
	private String getFormAction(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String formAction = FormUtil.setNullToBlank(request.getParameter("formAction"));
		
		if(FormUtil.isNotNull(session.getAttribute("formAction")) && FormUtil.isNullOrBlank(formAction))
			formAction = FormUtil.setNullToBlank((String)session.getAttribute("formAction"));
		
		session.setAttribute("formAction", formAction);
		return formAction;
	}

	private Long getResidentId(HttpServletRequest request) {
		Long residentId;
		HttpSession session = request.getSession();
		if(!FormUtil.isNullOrBlank(request.getParameter("residentId")))
		{
			residentId = Long.parseLong( request.getParameter("residentId"));
			session.setAttribute("residentId", Long.parseLong(request.getParameter("residentId")));
		}
		else if(FormUtil.isNotNull(session.getAttribute("residentId")))
		{
			residentId = (Long)session.getAttribute("residentId");
		}
		else if(FormUtil.setNullToBlank((String)session.getAttribute("roleName")).equalsIgnoreCase("resident"))
		{
			residentId = (Long)session.getAttribute("userId");
		}
		else
		{
			residentId = 0L;
		}
		return residentId;
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 
		TenantProfileForm tenantFrm = (TenantProfileForm) form;
		
		ActionErrors actionErrors = tenantFrm.validate(mapping, request);
		ActionMessages messages = new ActionMessages();
		if (actionErrors.isEmpty()) {
			Long usrid = 0L;
			if (FormUtil.isNotNull(request.getParameter("residentId")))
			{
				usrid = Long.parseLong(request.getParameter("residentId"));
			}
			else if(FormUtil.isNotNull(request.getSession().getAttribute("residentId")))
			{
				usrid = (Long) request.getSession().getAttribute("residentId");
			}
			else
			{
				usrid = (Long) request.getSession().getAttribute("userId");
			}
			System.out.println("usrid  : "+usrid );
			String user = (String) request.getSession().getAttribute("userName");

			TenantDAO tenantDAO = new TenantDAO();
			Tenant tenant = tenantDAO.findById(usrid);
			tenant.setTemppwdChanged(true);
			tenantDAO.update(this.mapFormToVO(tenantFrm, tenant, user));
			 
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("tenant.update"));
			saveMessages(request, messages);
			request.setAttribute("message", "message");
			//String action= "failure";
			 
			//if (request.getParameter("formAction").equalsIgnoreCase("edit") || request.getParameter("formAction").equalsIgnoreCase("update")&& request.getParameter("residentId")== null)
			//{
			// action= "success1";
			//}else
			//{
				//action="success";
			//}
				HttpSession session = request.getSession();
				session.setAttribute("formAction", null);
				session.removeAttribute("formAction");
				session.setAttribute("residentId", null);
				session.removeAttribute("residentId");
				return mapping.findForward("success");
			

		} else {
			saveErrors(request, actionErrors);
			return mapping.findForward("input");
		}
	}


	public ActionForward add(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		TenantProfileForm tenantFrm = (TenantProfileForm) form;
		
		ActionMessages messages = new ActionMessages();
		
		 
		ActionErrors actionErrors = tenantFrm.validate(mapping, request);
		
		if (actionErrors.isEmpty()) {
			
			
			String user = (String) request.getSession().getAttribute("userName");
			BaseDAO<Tenant> base = new BaseDAO<Tenant>();
			Tenant tenant = this.mapFormToVO(tenantFrm, new Tenant(), user);
			ApartmentDAO apartmentDAO = new ApartmentDAO();
			 
			Apartment apartment = apartmentDAO.findById(Long.parseLong(tenantFrm.getApartmentId()));
			tenant.setApartment(apartment);
			System.out.println(tenant.getApartment());
			tenant.setCreatedDate(new Timestamp(new Date().getTime()));
			tenant.setCreatedBy(user);
			tenant.setTemppwdChanged(false);
			base.save(tenant);
			WelcomeMailtoResident mailtoResident = new WelcomeMailtoResident((Long) request.getSession().getAttribute("userId"), tenant, request.getRequestURL().toString().replace("TenantProfile.do", ""));
			mailtoResident.execute();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("tenant.add"));
			saveMessages(request, messages);
			request.setAttribute("message", "message");
			return mapping.findForward("success");
		} else {
			saveErrors(request, actionErrors);
			return mapping.findForward("input");
		}
	}

	/**
	 * 
	 */
	private TenantProfileForm mapVOToForm(Tenant tenant, TenantProfileForm tenantFrm) {
		tenantFrm.setUserName(FormUtil.setNullToBlank(tenant.getUserId()));
		tenantFrm.setPassword(FormUtil.setNullToBlank(tenant.getUserPassword()));
		tenantFrm.setEmailAddress(FormUtil.setNullToBlank(tenant.getEmail()));
		tenantFrm.setGender(FormUtil.setNullToBlank(tenant.getGender()));
		tenantFrm.setFirstName(FormUtil.setNullToBlank(tenant.getFirstName()));
		tenantFrm.setMiddleName(FormUtil.setNullToBlank(tenant.getMiddleName()));
		tenantFrm.setLastName(FormUtil.setNullToBlank(tenant.getLastName()));
		tenantFrm.setHomePhone(FormUtil.setNullToBlank(tenant.getHomePhone()));
		tenantFrm.setCellPhone(FormUtil.setNullToBlank(tenant.getCellPhone()));
		tenantFrm.setWorkPhone(FormUtil.setNullToBlank(tenant.getWorkPhone()));
		tenantFrm.setSendEmailSms(tenant.getSendEmailSms());
		tenantFrm.setCarrier(FormUtil.setNullToBlank(tenant.getCellularProvider()));
		if (FormUtil.isNotNull(tenant.getLeaseStartDay()))
			tenantFrm.setLeaseStartDate(tenant.getLeaseStartMonth() + "/"
					+ tenant.getLeaseStartDay() + "/"
					+ tenant.getLeaseStartYear());
		if (FormUtil.isNotNull(tenant.getLeaseEndDay()))
			tenantFrm.setLeaseEndDate(tenant.getLeaseEndMonth() + "/"
					+ tenant.getLeaseEndDay() + "/" + tenant.getLeaseEndYear());
		tenantFrm.setParking(FormUtil.setNullToBlank(tenant.getParking()));
		tenantFrm.setTagnumber(FormUtil.setNullToBlank(tenant.getTagnumber()));

		tenantFrm.setApartmentId(String.valueOf(FormUtil.setNullToZero(tenant.getApartment().getId())));
		tenantFrm.setActiveFlag(tenant.getActiveFlag());
		return tenantFrm;
	}

	/**
	 * @param userName
	 * @throws ParseException
	 * 
	 */
	private Tenant mapFormToVO(TenantProfileForm tenantFrm, Tenant tenant,
			String userName)  {

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
		Date lStartDate = null;
		try {
			lStartDate = dateFormat.parse(tenantFrm.getLeaseStartDate());
		} catch (ParseException e) {
		}
		Date lEndDate = null;
		try {
			lEndDate = dateFormat.parse(tenantFrm.getLeaseEndDate());
		} catch (ParseException e) {
		}
		 
		DateFormat month = new SimpleDateFormat("MM");
		DateFormat day = new SimpleDateFormat("dd");
		DateFormat year = new SimpleDateFormat("yy");
		System.out.println("tenant"+tenant);
		if(!FormUtil.isNullOrBlank(tenantFrm.getApartmentId()) && !tenantFrm.getApartmentId().equals("0"))
		{
			ApartmentDAO apartmentDAO = new ApartmentDAO();
			Apartment apartment = apartmentDAO.findById(Long.parseLong(tenantFrm.getApartmentId()));
			tenant.setApartment(apartment);
		}
		tenant.setFirstName(tenantFrm.getFirstName());
		tenant.setLastName(tenantFrm.getLastName());
		tenant.setUserId(tenantFrm.getUserName());
		tenant.setUserPassword(tenantFrm.getPassword());
		tenant.setGender(tenantFrm.getGender());
		tenant.setEmail(tenantFrm.getEmailAddress());
		tenant.setMiddleName(tenantFrm.getMiddleName());
		tenant.setHomePhone(tenantFrm.getHomePhone());
		tenant.setWorkPhone(tenantFrm.getWorkPhone());
		tenant.setCellPhone(tenantFrm.getCellPhone());
		tenant.setSendEmailSms(tenantFrm.getSendEmailSms());
		tenant.setCellularProvider(tenantFrm.getCarrier());
		tenant.setLeaseStartDay(day.format(lStartDate));
		tenant.setLeaseStartMonth(month.format(lStartDate));
		tenant.setLeaseStartYear(year.format(lStartDate));
		tenant.setLeaseEndDay(day.format(lEndDate));
		tenant.setLeaseEndMonth(month.format(lEndDate));
		tenant.setLeaseEndYear(year.format(lEndDate));
		tenant.setParking(tenantFrm.getParking());
		tenant.setTagnumber(tenantFrm.getTagnumber());
		tenant.setModifiedDate(new Timestamp(new Date().getTime()));
		tenant.setModifiedBy(userName);
		tenant.setActiveFlag(tenantFrm.getActiveFlag());
		tenant.setRole(new RoleDAO().findById(3L));
		

		return tenant;
	}
	@Override
	protected Map<String, String> getKeyMethodMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("button.update", "update");
		//map.put("button.save","save");
		return map;
	}
}
