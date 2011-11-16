/**
 * 
 */
package com.mycove.cove.trans;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mycove.dao.TenantDAO;
import com.mycove.dao.UserDAO;
import com.mycove.util.email.EmailUtil;
import com.mycove.vo.MaintenanceRequest;
import com.mycove.vo.Property;
import com.mycove.vo.Tenant;
import com.mycove.vo.User;


/**
 * @author Karthikeyan
 * 
 */
public class CreateMaintenceRequest extends MessageHandler {
	
	private final static Logger log = Logger.getLogger(CreateMaintenceRequest.class);

	private MaintenanceRequest maintenanceRequest;
	private Long userId;
	
    
	/**
	 * @param configurationFilePath
	 * @param userId 
	 * @param main
	 * @param attribute
	 */
	public CreateMaintenceRequest(MaintenanceRequest maintenanceRequest, Long userId) {

		this.maintenanceRequest = maintenanceRequest;
		this.userId = userId;
	}

	public void execute() throws Exception {
		log.info("CreateMaintenceRequest execution Starts");
		try {
			EmailUtil emailUtil = new EmailUtil();
			Tenant tenant = (Tenant)new TenantDAO().findById(userId);
			emailUtil.setEmailFrom(tenant.getEmail());
			
			List<String> emailTo = new ArrayList<String>();
			Property property = tenant.getApartment().getBuilding().getProperty();
			emailTo.add(property.getPrimaryContactEmailAddress());
			emailUtil.setEmailTo(emailTo);
			
			String subject = "Maintenance Request Created";
			emailUtil.setSubject(getProblemSummary(subject));
			
			String mailBody = getMailBody(property, tenant);
			emailUtil.setBody(mailBody, EmailUtil.MIME_TYPE_TEXT);
			UserDAO userDAO = new UserDAO();
			List<User> users = userDAO.findByProperty(UserDAO.USER_ID, property.getAdminUserName());
			if(users.size()>0)
			{
				log.info("Storing the message");
				saveEmail(property, tenant, users.get(0), emailTo, mailBody, subject);
				log.info("Message stored successfully");
			}
			
			
			Thread thread = new Thread(emailUtil);
			thread.start();
			
			log.info("CreateMaintenceRequest execution Ends");
		} catch (Exception e) {
			log.error("Error on CreateMaintenceRequest execution. ", e);
			throw e;
		}
	}
	
	/**
	 * @param property 
	 * @param user 
	 * 
	 */
	private String getMailBody(Property property, User user) {
			String request; 
		StringBuffer bodyBuff = new StringBuffer();	
		if(maintenanceRequest.getEntryPermission().equals(true))
		{ request = "yes";}
		else{ request = "No";}
		
		bodyBuff.append("Dear ").append(property.getPrimaryContactFirstName()).append(" ").append(property.getPrimaryContactLastName()).append(",\n\n")
		//.append("Subject: Maintenance Request Created").append("\n\n")
		.append("This is to inform you that a new maintenance request has been submitted. The details are as follows:-\n")
		.append("Date:\t").append(maintenanceRequest.getMaintenanceMonth()).append("/").append(maintenanceRequest.getMaintenanceDay()).append("/").append(maintenanceRequest.getMaintenanceYear()).append("\n")
		.append("Apartment:\t").append(maintenanceRequest.getApartment().getApartmentNumber()).append("\n")
		.append("Location:\t").append(maintenanceRequest.getMaintenanceLocation()).append("\n")
		.append("Request:\t").append(maintenanceRequest.getMaintenanceRequest()).append("\n")
		.append("Problem:\t").append(maintenanceRequest.getProblem()).append("\n")
		.append("Day-time phone:\t").append(maintenanceRequest.getDayTimeContactNo()).append("\n")		
		.append("Permission to enter:\t").append(request).append("\n\n")		
		.append("\n\nThanks & Regards,\n").append(user.getFirstName()).append(" ").append(user.getLastName()).append("\n")
		.append("Email:").append(user.getEmail()).append("\n")
		.append("Phone:").append(user.getCellPhone()).append("\n");

		return bodyBuff.toString();
	}
}
