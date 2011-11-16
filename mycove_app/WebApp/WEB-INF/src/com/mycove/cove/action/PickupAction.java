package com.mycove.cove.action;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.LookupDispatchAction;

import com.mycove.cove.form.AddPickupForm;
import com.mycove.cove.trans.PackageMail;
import com.mycove.cove.trans.PickupMail;
import com.mycove.dao.ApartmentDAO;
import com.mycove.dao.PackageDAO;
import com.mycove.util.util.FormUtil;
import com.mycove.vo.Apartment;

public class PickupAction extends LookupDispatchAction {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (form instanceof AddPickupForm) {
			try {
				Collection<Apartment> apartments = new ApartmentDAO().getAllApartmentByPropertyManagerId((Long)request.getSession().getAttribute("userId"));
				request.setAttribute("apartments", apartments);
				if (FormUtil.isNotNull(request.getParameter(mapping.getParameter()))
						&& request.getParameter(mapping.getParameter()).equals("Submit")) {
					return this.submit(mapping, form, request, response);
				} 
				
				else
				{
					return this.view(mapping, form, request, response);
				}
			}catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
		return mapping.findForward("input");
	}
	
public ActionForward view(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	String action = "input"; 
	AddPickupForm pickupfrm = (AddPickupForm) form;
	Calendar currentDate = Calendar.getInstance();
	  SimpleDateFormat formatter= 
	    new SimpleDateFormat("MM/dd/yy");
	  String dateNow = formatter.format(currentDate.getTime());
	  System.out.println("Now the date is :=>  " + dateNow);

	
	  Long packageId = 0L;
							
		if (FormUtil.isNotNull(request.getParameter("packageId"))) {
			 packageId = Long.parseLong(request.getParameter("packageId"));
				 PackageDAO packDAO = new PackageDAO();
				
				com.mycove.vo.Package pack = packDAO.findById(packageId);
				if (FormUtil.isNotNull(pack.getPackageDay()))
					pickupfrm.setDate(pack.getPackageMonth() + "/"
							+ pack.getPackageDay() + "/"
							+ pack.getPackageYear());
				pickupfrm.setId(String.valueOf(pack.getId()));
				pickupfrm.setCarrier(FormUtil.setNullToBlank(pack.getCarrier()));
				pickupfrm.setPieces(FormUtil.setNullToBlank(pack.getPieces()));
				pickupfrm.setPackageDescription(FormUtil.setNullToBlank(pack.getPackageDescription()));
				pickupfrm.setPackageLocation(FormUtil.setNullToBlank(pack.getPackageLocation()));
				pickupfrm.setResidentName(FormUtil.setNullToBlank(pack.getResidentName()));
				pickupfrm.setNotes(FormUtil.setNullToBlank(pack.getNotes()));
				pickupfrm.setApartmentId(String.valueOf(pack.getApartment().getId()));
				pickupfrm.setMessage(FormUtil.setNullToBlank(pack.getMessage()));
				pickupfrm.setSubject(FormUtil.setNullToBlank(pack.getSubject()));
				pickupfrm.setPickupDate(dateNow);
						
				
				action = "input";

			} 
		else
		{
			action = "input";
		}
	
	return mapping.findForward(action);
}
	public ActionForward submit(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("11");
		ActionMessages messages = new ActionMessages();
		AddPickupForm pickupfrm = (AddPickupForm) form;
		ActionErrors actionErrors = pickupfrm.validate(mapping, request);
		if(actionErrors.isEmpty())
		{	
			System.out.println("22");
			DateFormat year = new SimpleDateFormat("yy");
			DateFormat month = new SimpleDateFormat("MM");
			DateFormat day = new SimpleDateFormat("dd");
			Date date = null;
			  
			Date pickupdate =null;
	
			try {
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
				pickupdate = dateFormat.parse(pickupfrm.getPickupDate());
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
			System.out.println("33");
			PackageDAO packDAO = new PackageDAO();
			com.mycove.vo.Package pack = packDAO.findById(Long.parseLong(pickupfrm.getId()));
			pack.setCarrier(pack.getCarrier());
			pack.setSubject(pickupfrm.getSubject());
			pack.setMessage(pickupfrm.getMessage());
			pack.setPackageLocation(pickupfrm.getPackageLocation());
			pack.setPackageDescription(pickupfrm.getPackageDescription());
			pack.setNotes(pickupfrm.getNotes());
			pack.setPieces(pickupfrm.getPieces());
			System.out.println("1111");
			Apartment  apartment = new ApartmentDAO().findById((pack.getApartment().getId()));
			pack.setApartment(apartment);
			pack.setProperty(apartment.getBuilding().getProperty());
			pack.setPickupFlag(true);
			pack.setPickupBy(pickupfrm.getPickupBy());
		
			 
			pack.setResidentName(pickupfrm.getResidentName());
			if(FormUtil.isNotNull(pickupdate))
			{
				pack.setPickupDay(day.format(pickupdate));
				pack.setPickupMonth(month.format(pickupdate));
				pack.setPickupYear(year.format(pickupdate));
			}
			packDAO.update(pack);
			//Long apartmentId = (pack.getApartment().getId());
			PickupMail pickupmail = new PickupMail((Long) request.getSession().getAttribute("userId"),pack);
			pickupmail.execute();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("pickup.add"));
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

	/* (non-Javadoc)
	 * @see org.apache.struts.actions.LookupDispatchAction#getKeyMethodMap()
	 */
	@Override
	protected Map<String, String> getKeyMethodMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("button.submit", "Submit");
		return map;
	}
}
