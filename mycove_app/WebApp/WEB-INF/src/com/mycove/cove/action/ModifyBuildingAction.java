package com.mycove.cove.action;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.apache.struts.upload.FormFile;
import org.omg.CORBA.Request;

import com.mycove.cove.form.ModifyBuildingForm;
import com.mycove.cove.trans.WelcomeMailtoResident;
import com.mycove.cove.trans.WelcomeMailtoResidentUpload;
import com.mycove.dao.BuildingDAO;
import com.mycove.dao.PropertyDAO;
import com.mycove.dao.RoleDAO;
import com.mycove.dao.TenantDAO;
import com.mycove.util.util.FormUtil;
import com.mycove.vo.Apartment;
import com.mycove.vo.Building;
import com.mycove.vo.Role;
import com.mycove.vo.Tenant;

public class ModifyBuildingAction extends LookupDispatchAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		String action = "failure";
		try {
			if (form instanceof ModifyBuildingForm) {
				HttpSession session = request.getSession();
				String formAction = FormUtil.setNullToBlank(request.getParameter("formAction"));
				if(FormUtil.isNotNull(session.getAttribute("formAction")))
					formAction = FormUtil.setNullToBlank((String)session.getAttribute("formAction"));
				      session.setAttribute("formAction", formAction);
				ModifyBuildingForm buildingForm = (ModifyBuildingForm) form;
				if (FormUtil.isNotNull(mapping.getParameter()) 
						&& FormUtil.isNotNull(request.getParameter(mapping.getParameter()))
						&& request.getParameter(mapping.getParameter()).equals("Submit")) {
					return this.submit(mapping, form, request, response);
				} else {
					 formAction = FormUtil.setNullToBlank(request.getParameter("formAction"));
					
					if(FormUtil.isNotNull(request.getParameter("propertyId")))
					{
						buildingForm.setPropertyId(request.getParameter("propertyId"));
					}
					if (formAction.equalsIgnoreCase("edit")) {
						if (FormUtil.isNotNull(request.getParameter("buildingId"))) {
							System.out.println("build"+request.getParameter("buildingId"));
							BuildingDAO buildingDAO = new BuildingDAO();
							Building building = buildingDAO.findById(Long.parseLong(request.getParameter("buildingId")));
							buildingForm.setId(request.getParameter("buildingId"));
							buildingForm.setBuildingName(building.getBuildingName());
							action = "input";
						}
					}
					else if(formAction.equalsIgnoreCase("add"))
					{
						action= "input";
					}
					else
					{
						action= "input";
					}
				}
			}
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		return mapping.findForward(action);
	}

	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	private ActionForward submit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String action = "input";
		ActionMessages messages = new ActionMessages();
		 
		 
		ModifyBuildingForm buildingForm = (ModifyBuildingForm) form;
		ActionErrors actionErrors = buildingForm.validate(mapping, request);
		if(actionErrors.isEmpty())
		{
		try {
			 
			FormFile formFile = buildingForm.getApartmentFile();
			
			Building building;
			BuildingDAO buildingDAO =new BuildingDAO();
			if(!FormUtil.isNullOrBlank(buildingForm.getId()))
			{
				System.out.println(buildingForm.getId());
				building = buildingDAO.findById(Long.parseLong(buildingForm.getId()));
				building.setBuildingName(buildingForm.getBuildingName());
				String strFileContent = new String(formFile.getFileData()).trim();
				Set<Apartment> apartments = new HashSet<Apartment>();
				if (strFileContent.length() > 0) {
					
					 
					String[] apartmentArray = strFileContent.split("\n");
					Apartment apartment = null;
					String[] apartmentDetail;
					Tenant tenant = null;
					Set<Tenant> residents = null;
					Role role = new RoleDAO().findById(3L);
					for (int i = 0; i < apartmentArray.length; i++) {
						apartmentDetail = apartmentArray[i].split(",");
						
						if (apartmentDetail.length == 2) {
							System.out.println("apartment1111");
							apartment = new Apartment();
							apartment.setApartmentNumber(apartmentDetail[0]);
							apartment.setApartmentType(apartmentDetail[1]);
							apartment.setBuilding(building);
							apartments.add(apartment);
							building.setApartments(apartments);									
							buildingDAO.update(building);
						}
						else if(apartmentDetail.length == 9) {
							
							DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
							Date lStartDate = null;
							 
							System.out.println("tenant"+tenant);
							apartment = new Apartment();
							tenant = new Tenant();
						
							residents = new HashSet<Tenant>();
							apartment.setApartmentNumber(apartmentDetail[0]);
							apartment.setApartmentType(apartmentDetail[1]);
							apartment.setBuilding(building);
							tenant.setUserId(apartmentDetail[2]);
							tenant.setUserPassword(apartmentDetail[3]);
							tenant.setFirstName(apartmentDetail[4]);
							tenant.setLastName(apartmentDetail[5]);
							tenant.setEmail(apartmentDetail[6]);
							tenant.setApartment(apartment);
							tenant.setRole(role);
						     
							try {
								lStartDate = dateFormat.parse(apartmentDetail[7]);
							     } 
							catch (ParseException e) {
							}
							Date lEndDate = null;
							try {
								lEndDate = dateFormat.parse(apartmentDetail[8]);
							} catch (ParseException e) {
							}
							 
							DateFormat month = new SimpleDateFormat("MM");
							DateFormat day = new SimpleDateFormat("dd");
							DateFormat year = new SimpleDateFormat("yy");
							//if (FormUtil.isNotNull(tenant.getLeaseEndDay()))
							tenant.setLeaseStartDay(day.format(lStartDate));
							tenant.setLeaseStartMonth(month.format(lStartDate));
							tenant.setLeaseStartYear(year.format(lStartDate));
							//if (FormUtil.isNotNull(tenant.getLeaseEndDay()))
							tenant.setLeaseEndDay(day.format(lEndDate));
							tenant.setLeaseEndMonth(month.format(lEndDate));
							tenant.setLeaseEndYear(year.format(lEndDate));
							tenant.setCreatedDate(new Timestamp(new Date().getTime()));
							tenant.setSendEmailSms(true);
							tenant.setTemppwdChanged(false);
							residents.add(tenant);
							apartment.setResident(residents);
							apartments.add(apartment);
							WelcomeMailtoResidentUpload mailtoUpResident = new WelcomeMailtoResidentUpload(tenant);				 
					        System.out.println("2");
							
								Tenant tenant1 = new TenantDAO().findByUserId(tenant.getUserId());
								if(tenant1==null)
								{   System.out.println("coooooooooooooorp");
									building.setApartments(apartments);									
									buildingDAO.update(building);
									
								mailtoUpResident.execute();
								}
								else
								{  System.out.println("errorid"+tenant.getUserId());
								messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("userid.exist","user"+tenant.getUserId()));
									saveMessages(request, messages);
									request.setAttribute("message", "message");
								}
								
						}
						
					}
				} else {
					apartments = new HashSet<Apartment>();
					building.setApartments(apartments);
					
					buildingDAO.update(building);
				}
				
				//building.setApartments(apartments);
				
				//buildingDAO.update(building);
						
			}
			else
			{
				building = new Building();
				building.setProperty(new PropertyDAO().findById(Long.parseLong(buildingForm.getPropertyId())));
				building.setBuildingName(buildingForm.getBuildingName());
				String strFileContent = new String(formFile.getFileData()).trim();
				Set<Apartment> apartments = new HashSet<Apartment>();
				if (strFileContent.length() > 0) {
					System.out.println("apartment1");
					String[] apartmentArray = strFileContent.split("\n");
					Apartment apartment = null;
					String[] apartmentDetail;
					Tenant tenant = null;
					Set<Tenant> residents = null;
					Role role = new RoleDAO().findById(3L);
					for (int i = 0; i < apartmentArray.length; i++) {
						apartmentDetail = apartmentArray[i].split(",");
						System.out.println("apartment1");
						if (apartmentDetail.length == 2) {
							System.out.println("apartment2");
							apartment = new Apartment();
							apartment.setApartmentNumber(apartmentDetail[0]);
							apartment.setApartmentType(apartmentDetail[1]);
							apartment.setBuilding(building);
							apartments.add(apartment);
							building.setApartments(apartments);
							buildingDAO.save(building);
						}
						else if(apartmentDetail.length == 9) {
							
							DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
							Date lStartDate = null;
							 
							System.out.println("tenant"+tenant);
							apartment = new Apartment();
							tenant = new Tenant();
						
							residents = new HashSet<Tenant>();
							apartment.setApartmentNumber(apartmentDetail[0]);
							apartment.setApartmentType(apartmentDetail[1]);
							apartment.setBuilding(building);
							tenant.setUserId(apartmentDetail[2]);
							tenant.setUserPassword(apartmentDetail[3]);
							tenant.setFirstName(apartmentDetail[4]);
							tenant.setLastName(apartmentDetail[5]);
							tenant.setEmail(apartmentDetail[6]);
							tenant.setApartment(apartment);
							tenant.setRole(role);
						     
							try {
								lStartDate = dateFormat.parse(apartmentDetail[7]);
							     } 
							catch (ParseException e) {
							}
							Date lEndDate = null;
							try {
								lEndDate = dateFormat.parse(apartmentDetail[8]);
							} catch (ParseException e) {
							}
							 
							DateFormat month = new SimpleDateFormat("MM");
							DateFormat day = new SimpleDateFormat("dd");
							DateFormat year = new SimpleDateFormat("yy");
							//if (FormUtil.isNotNull(tenant.getLeaseStartDay()))
							tenant.setLeaseStartDay(day.format(lStartDate));
							tenant.setLeaseStartMonth(month.format(lStartDate));
							tenant.setLeaseStartYear(year.format(lStartDate));
							//if (FormUtil.isNotNull(tenant.getLeaseEndDay()))
							tenant.setLeaseEndDay(day.format(lEndDate));
							tenant.setLeaseEndMonth(month.format(lEndDate));
							tenant.setLeaseEndYear(year.format(lEndDate));
							tenant.setCreatedDate(new Timestamp(new Date().getTime()));
							tenant.setSendEmailSms(true);
							tenant.setTemppwdChanged(false);
							residents.add(tenant);
							apartment.setResident(residents);
							apartments.add(apartment);
							WelcomeMailtoResidentUpload mailtoUpResident = new WelcomeMailtoResidentUpload(tenant);				 
					        System.out.println("2");
							
								Tenant tenant1 = new TenantDAO().findByUserId(tenant.getUserId());
								if(tenant1==null)
								{
									building.setApartments(apartments);
									
									buildingDAO.save(building);
									
								mailtoUpResident.execute();
								}
								else
								{  System.out.println("errorid"+tenant.getUserId());
								messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("userid.exist","user",tenant.getUserId()));
									saveMessages(request, messages);
									request.setAttribute("message", "message");
								}
								
						}
						
					}
				} else {
					apartments = new HashSet<Apartment>();
					building.setApartments(apartments);
					
					buildingDAO.save(building);
					
				}
			
				//building.setApartments(apartments);
				
				//buildingDAO.save(building);
				
			}
			
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("file.upload"));
			saveMessages(request, messages);
			request.setAttribute("message", "message");
			HttpSession session = request.getSession();
			session.setAttribute("formAction", null);
			session.removeAttribute("formAction");
			action = "success";
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			//messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("userid.exist"));
			saveMessages(request, messages);
			request.setAttribute("message", "message");
		}
		}
		saveErrors(request, actionErrors);
		return mapping.findForward(action);
	}

	/**
	 * @param strFileContent
	 * @param building 
	 * @return
	 */
	private Set<Apartment> parseApartmentDetails(String strFileContent,Building building ) {
		Set<Apartment> apartments = new HashSet<Apartment>();
		 
		String[] apartmentArray = strFileContent.split("\n");
		Apartment apartment = null;
		String[] apartmentDetail;
		Tenant tenant = null;
		Set<Tenant> residents = null;
		Role role = new RoleDAO().findById(3L);
		for (int i = 0; i < apartmentArray.length; i++) {
			apartmentDetail = apartmentArray[i].split(",");
			if (apartmentDetail.length == 2) {
				apartment = new Apartment();
				apartment.setApartmentNumber(apartmentDetail[0]);
				apartment.setApartmentType(apartmentDetail[1]);
				apartment.setBuilding(building);
				apartments.add(apartment);
			}
			else if(apartmentDetail.length == 9) {
				
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
				Date lStartDate = null;
				 
				System.out.println("tenant"+tenant);
				apartment = new Apartment();
				tenant = new Tenant();
			
				residents = new HashSet<Tenant>();
				apartment.setApartmentNumber(apartmentDetail[0]);
				apartment.setApartmentType(apartmentDetail[1]);
				apartment.setBuilding(building);
				tenant.setUserId(apartmentDetail[2]);
				tenant.setUserPassword(apartmentDetail[3]);
				tenant.setFirstName(apartmentDetail[4]);
				tenant.setLastName(apartmentDetail[5]);
				tenant.setEmail(apartmentDetail[6]);
				tenant.setApartment(apartment);
				tenant.setRole(role);
			     
				try {
					lStartDate = dateFormat.parse(apartmentDetail[7]);
				     } 
				catch (ParseException e) {
				}
				Date lEndDate = null;
				try {
					lEndDate = dateFormat.parse(apartmentDetail[8]);
				} catch (ParseException e) {
				}
				 
				DateFormat month = new SimpleDateFormat("MM");
				DateFormat day = new SimpleDateFormat("dd");
				DateFormat year = new SimpleDateFormat("yy");
				tenant.setLeaseStartDay(day.format(lStartDate));
				tenant.setLeaseStartMonth(month.format(lStartDate));
				tenant.setLeaseStartYear(year.format(lStartDate));
				tenant.setLeaseEndDay(day.format(lEndDate));
				tenant.setLeaseEndMonth(month.format(lEndDate));
				tenant.setLeaseEndYear(year.format(lEndDate));
				tenant.setCreatedDate(new Timestamp(new Date().getTime()));
				tenant.setSendEmailSms(true);
				tenant.setTemppwdChanged(false);
				residents.add(tenant);
				apartment.setResident(residents);
				apartments.add(apartment);
				WelcomeMailtoResidentUpload mailtoUpResident = new WelcomeMailtoResidentUpload(tenant);				 
		        
				try {
					Tenant tenant1 = new TenantDAO().findByUserId(tenant.getUserId());
					if(tenant1==null)
					{
					mailtoUpResident.execute();
					}
					else
					{  
					
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}
		return apartments;
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
