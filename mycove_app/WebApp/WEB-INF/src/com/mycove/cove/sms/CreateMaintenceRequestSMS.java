/**
 * 
 */
package com.mycove.cove.sms;

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
 * @author muralee
 *
 */
public class CreateMaintenceRequestSMS  {
	
	private final static Logger log = Logger.getLogger(CreateMaintenceRequestSMS.class);

	private MaintenanceRequest maintenanceRequest;
	private Long userId;
	
    
	/**
	 * @param configurationFilePath
	 * @param userId 
	 * @param main
	 * @param attribute
	 */
	public CreateMaintenceRequestSMS(MaintenanceRequest maintenanceRequest, Long userId) {

		this.maintenanceRequest = maintenanceRequest;
		this.userId = userId;
	}

	public void execute() throws Exception {
		log.info("CreateMaintenceRequestSMS execution Starts");
		try {
			 
			SmsUtil smsUtil = new SmsUtil();
			Tenant tenant = (Tenant)new TenantDAO().findById(userId);
			//SmsUtil.setEmailFrom(tenant.getEmail());
			
			//List<String> msgTo = new ArrayList<String>();
			Property property = tenant.getApartment().getBuilding().getProperty();
			//msgTo.add(property.getPrimaryContactPhoneNumber());
			System.out.println(property.getPrimaryContactPhoneNumber());
			String msgTo = (property.getPrimaryContactPhoneNumber());
			smsUtil.setMsgTo(msgTo);
			
			String subject = "Maintenance Request Created";
			smsUtil.setSubject(subject);
			System.out.println(smsUtil.getSubject());
			String mailBody = getMailBody(property, tenant);
			//emailUtil.setBody(mailBody, EmailUtil.MIME_TYPE_TEXT);
			smsUtil.setMsgBody(mailBody);
			/*UserDAO userDAO = new UserDAO();
			List<User> users = userDAO.findByProperty(UserDAO.USER_ID, property.getAdminUserName());
			if(users.size()>0)
			{
				log.info("Storing the message");
				saveEmail(property, tenant, users.get(0), emailTo, mailBody, subject);
				log.info("Message stored successfully");
			}*/
			
			smsUtil.sendSms(smsUtil);
			//Thread thread = new Thread(smsUtil);
			//thread.start();
			
			
			log.info("CreateMaintenceRequestSMS execution Ends");
		} catch (Exception e) {
			log.error("Error on CreateMaintenceRequestSMS execution. ", e);
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
		.append("Subject: Maintenance Request Created").append("\n\n")
		//.append("This is to inform you that a new maintenance request has been submitted. The details are as follows:-\n")
		//.append("Date:\t").append(maintenanceRequest.getMaintenanceMonth()).append("/").append(maintenanceRequest.getMaintenanceDay()).append("/").append(maintenanceRequest.getMaintenanceYear()).append("\n")
		//.append("Apartment:\t").append(maintenanceRequest.getApartment().getApartmentNumber()).append("\n")
		//.append("Location:\t").append(maintenanceRequest.getMaintenanceLocation()).append("\n")
		//.append("Request:\t").append(maintenanceRequest.getMaintenanceRequest()).append("\n")
		//.append("Problem:\t").append(maintenanceRequest.getProblem()).append("\n")
		//.append("Day-time phone:\t").append(maintenanceRequest.getDayTimeContactNo()).append("\n")		
		//.append("Permission to enter:").append(request).append("\n\n")		
		.append("\n\nThanks & Regards,\n").append(user.getFirstName()).append(" ").append(user.getLastName()).append("\n");
		//.append("Email:").append(user.getEmail()).append("\n")
		//.append("Phone:").append(user.getCellPhone()).append("\n");

		return bodyBuff.toString();
	}
}
