package com.mycove.cove.action;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.LookupDispatchAction;

import com.mycove.cove.form.AddPackageForm;
import com.mycove.cove.trans.PackageMail;
import com.mycove.dao.ApartmentDAO;
import com.mycove.dao.PackageDAO;
import com.mycove.dao.TenantDAO;
import com.mycove.dao.UserDAO;
import com.mycove.dto.ResidentDTO;
import com.mycove.util.util.FormUtil;
import com.mycove.vo.Apartment;
import com.mycove.vo.Tenant;
import com.mycove.vo.User;



public class PackageAction extends LookupDispatchAction {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (form instanceof AddPackageForm) {
			try {
				HttpSession session = request.getSession();
			String formAction = FormUtil.setNullToBlank(request.getParameter("formAction"));
			if(FormUtil.isNotNull(session.getAttribute("formAction")))
				formAction = FormUtil.setNullToBlank((String)session.getAttribute("formAction"));
			      session.setAttribute("formAction", formAction);
			      ApartmentDAO apartmentDAO = new ApartmentDAO();
					List<Apartment> apartments = apartmentDAO.getAllApartmentByPropertyManagerId((Long)request.getSession().getAttribute("userId"));
					
					request.setAttribute("apartments", apartments);
			      TenantDAO tenantDAO = new TenantDAO();
					Collection<ResidentDTO> residentDTOs = tenantDAO.getAllTenantsByPropertyManager((Long)request.getSession().getAttribute("userId"));
					request.setAttribute("residents", residentDTOs);
				if (FormUtil.isNotNull(request.getParameter(mapping.getParameter()))
						&& request.getParameter(mapping.getParameter()).equals("Save")) {
					return this.add(mapping, form, request, response);
				} else if (FormUtil.isNotNull(request.getParameter(mapping.getParameter()))
						&& request.getParameter(mapping.getParameter()).equals("Delete")) {
					return this.delete(mapping, form, request, response);
				} else if (FormUtil.isNotNull(request.getParameter(mapping.getParameter()))
						&& request.getParameter(mapping.getParameter()).equals("Update")) {
					
					return this.update(mapping, form, request, response);
				} else {
					return this.view(mapping, form, request, response);
				}
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
		return mapping.findForward("input");
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    
		    ActionMessages messages = new ActionMessages();
			AddPackageForm packagefrm = (AddPackageForm) form;
			ActionErrors actionErrors = packagefrm.validate(mapping, request);
			if(actionErrors.isEmpty())
			{      
					PackageDAO packDAO = new PackageDAO();					
					com.mycove.vo.Package pack = new com.mycove.vo.Package();
					ApartmentDAO apartmentDAO = new ApartmentDAO();
					TenantDAO tenantDAO = new TenantDAO();
				     	
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
					Date date = dateFormat.parse(packagefrm.getDate());
					DateFormat year = new SimpleDateFormat("yy");
					DateFormat month = new SimpleDateFormat("MM");
					DateFormat day = new SimpleDateFormat("dd");
					Tenant tenant = tenantDAO.findById(Long.parseLong(packagefrm.getApartmentId()));
					Apartment apartment = apartmentDAO.findById((tenant.getApartment().getId()));
					pack.setPackageDay(day.format(date));
					pack.setPackageMonth(month.format(date));
					pack.setPackageYear(year.format(date));
					pack.setCarrier(packagefrm.getCarrier());
					pack.setPieces(packagefrm.getPieces());
					pack.setPackageLocation(packagefrm.getPackageLocation());
					pack.setPackageDescription(packagefrm.getPackageDescription());
					pack.setResidentName(packagefrm.getResidentName());
					pack.setNotes(packagefrm.getNotes());
					pack.setSubject(packagefrm.getSubject());
					pack.setMessage(packagefrm.getMessage());
					pack.setApartment(apartment);
					pack.setProperty(apartment.getBuilding().getProperty());
					packDAO.save(pack);
					
					
					Long residentId = (Long.parseLong(packagefrm.getApartmentId()));
					
					PackageMail packmail = new PackageMail((Long) request.getSession().getAttribute("userId"),pack,residentId);
					packmail.execute();
					messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("Package.add"));
					saveMessages(request, messages); 
					request.setAttribute("message", "message");
					return mapping.findForward("success");

				}
				else
				{
					saveErrors(request, actionErrors);
					return mapping.findForward("input");
				}
			}

	public ActionForward view(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String action = "input"; 
		  AddPackageForm packagefrm = (AddPackageForm) form;
		  Long packageId = 0L;
		  Calendar currentDate = Calendar.getInstance();
		   SimpleDateFormat formatter= 
		   new SimpleDateFormat("MM/dd/yy");
		   String dateNow = formatter.format(currentDate.getTime());
		   System.out.println("Now the date is :=>  " + dateNow);
		   packagefrm.setDate(dateNow);					
			if (FormUtil.isNotNull(request.getParameter("packageId"))) {
				packageId = Long.parseLong(request.getParameter("packageId"));
					 PackageDAO packDAO = new PackageDAO();
					
					com.mycove.vo.Package pack = packDAO.findById(packageId);
					 
					if (FormUtil.isNullOrBlank(pack.getPackageDay()))
					{
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
						packagefrm.setDate(dateFormat.format(new Date()));
					}
					else
					{
						packagefrm.setDate(pack.getPackageMonth() + "/"
								+ pack.getPackageDay() + "/"
								+ pack.getPackageYear());
					}
					packagefrm.setId(String.valueOf(pack.getId()));
					packagefrm.setCarrier(FormUtil.setNullToBlank(pack.getCarrier()));
					packagefrm.setPieces(FormUtil.setNullToBlank(pack.getPieces()));
					packagefrm.setPackageDescription(FormUtil.setNullToBlank(pack.getPackageDescription()));
					packagefrm.setPackageLocation(FormUtil.setNullToBlank(pack.getPackageLocation()));
					packagefrm.setResidentName(FormUtil.setNullToBlank(pack.getResidentName()));
					packagefrm.setNotes(FormUtil.setNullToBlank(pack.getNotes()));
					//TenantDAO tenantDAO = new TenantDAO();
					//ApartmentDAO apartmentDAO = new ApartmentDAO();
					//Apartment apartment =apartmentDAO.findById(pack.getApartment().getId()); 
					//Tenant tenant = tenantDAO.findById(pack.getApartment().getId());
					packagefrm.setApartmentId(String.valueOf(pack.getApartment().getId()));
					
					packagefrm.setMessage(FormUtil.setNullToBlank(pack.getMessage()));
					packagefrm.setSubject(FormUtil.setNullToBlank(pack.getSubject()));
					
					action = "input";

				} 
			else
			{
				action = "input";
			}
		
		return mapping.findForward(action);
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionMessages messages = new ActionMessages();
		AddPackageForm packagefrm = (AddPackageForm) form;
		ActionErrors actionErrors = packagefrm.validate(mapping, request);
		
		if(actionErrors.isEmpty())
		{	
			 
			DateFormat year = new SimpleDateFormat("yy");
			DateFormat month = new SimpleDateFormat("MM");
			DateFormat day = new SimpleDateFormat("dd");
			Date date = null;
			try {
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
				date = dateFormat.parse(packagefrm.getDate());
			} catch (ParseException e) {
			}
			TenantDAO tenantDAO = new TenantDAO();
			ApartmentDAO apartmentDAO = new ApartmentDAO();
			//Tenant tenant = tenantDAO.findById(Long.parseLong(packagefrm.getApartmentId()));
			
			PackageDAO packDAO = new PackageDAO();
			com.mycove.vo.Package pack = packDAO.findById(Long.parseLong(packagefrm.getId()));
			pack.setCarrier(packagefrm.getCarrier());
			pack.setSubject(packagefrm.getSubject());
			pack.setMessage(packagefrm.getMessage());
			pack.setPackageLocation(packagefrm.getPackageLocation());
			pack.setPackageDescription(packagefrm.getPackageDescription());
			pack.setNotes(packagefrm.getNotes());
			pack.setPieces(packagefrm.getPieces());
			Apartment  apartment = new ApartmentDAO().findById(pack.getApartment().getId());
			//Apartment apartment = apartmentDAO.findById((tenant.getApartment().getId()));
			pack.setApartment(apartment);
			pack.setProperty(apartment.getBuilding().getProperty());
			if(FormUtil.isNotNull(date))
			{
				pack.setPackageDay(day.format(date));
				pack.setPackageMonth(month.format(date));
				pack.setPackageYear(year.format(date));
			}
			pack.setResidentName(packagefrm.getResidentName());
			
			packDAO.update(pack);
			
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("package.update"));
			saveMessages(request, messages); 
			request.setAttribute("message", "message");
			return mapping.findForward("success");

			
		}
		else
		{
			saveErrors(request, actionErrors);
			return mapping.findForward("input");
		}
	}
	
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String action = "input";
		
		if (form instanceof AddPackageForm) {
			try {
				AddPackageForm packagefrm = (AddPackageForm) form;
				PackageDAO packDAO = new PackageDAO();
				ActionMessages messages = new ActionMessages();
				packDAO.delete(packDAO.findById(Long.parseLong(packagefrm.getId())));
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("package.delete"));
				saveMessages(request, messages); 
				request.setAttribute("message", "message");
				return mapping.findForward("success");
				
			} catch (Exception e) {
				
				ActionErrors actionErrors = new ActionErrors();
				actionErrors.add("delete", new ActionError("error.delete"));
				saveErrors(request, actionErrors);
				action = "input";
				log.error(e.getMessage(), e);
		}
		}
		return mapping.findForward(action);
	}
	@Override
	protected Map<String, String> getKeyMethodMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("button.submit", "Submit");
		map.put("button.update","Update");
		map.put("button.delete", "delete");
		return map;
	}
	
	
}
