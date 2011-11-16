/**
 * 
 */
package com.mycove.cove.trans;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mycove.dao.MessageTemplateDAO;
import com.mycove.dao.PackageDAO;
import com.mycove.dao.TenantDAO;
import com.mycove.dao.UserDAO;
import com.mycove.util.email.EmailUtil;
import com.mycove.vo.MessageTemplate;
import com.mycove.vo.Property;
import com.mycove.vo.Tenant;
import com.mycove.vo.User;

public class PickupMail extends MessageHandler {
	
	private final static Logger log = Logger.getLogger(PickupMail.class);
	
	private Long loggedUserId;
	private com.mycove.vo.Package pack; 
	 
	
	public PickupMail(Long userId, com.mycove.vo.Package pack) {

		this.loggedUserId = userId;
		this.pack = pack;
		 
	}
	
	public void execute() throws Exception {
		log.info("pickup execution Starts");
		EmailUtil emailUtil;
		User user = new UserDAO().findById(loggedUserId);
		//com.mycove.vo.Package pack = new PackageDAO().findById(packageId);
		
		try {
			TenantDAO tenantDAO = new TenantDAO();
			List<Tenant> tenants = tenantDAO.findTenantByProperty(TenantDAO.APARTMENT_ID, pack.getApartment().getId());
			Tenant tenant = null;
			if(tenants.size() > 0)
			{
			
				tenant = tenants.get(0);
				List<String> emailTo = new ArrayList<String>();
				Property property = pack.getApartment().getBuilding().getProperty();
				emailUtil = new EmailUtil();
				emailTo.add(tenant.getEmail());
				emailUtil.setEmailTo(emailTo);
				
				System.out.println("rrrrrr"+tenant.getEmail());
				 
				
				emailUtil.setEmailFrom(user.getEmail());
						
				//System.out.println("sdsdsd"+emailToUser.getEmail());
				String subject = "Pickup Confirmation";
				emailUtil.setSubject(subject);
                String mailBody = getMailBody(user,tenant);
				emailUtil.setBody(mailBody, EmailUtil.MIME_TYPE_TEXT);
				
				log.info("Storing the message");
				saveEmail(pack.getProperty(), user, tenant, emailTo, mailBody, subject);
				log.info("Message stored successfully");

				Thread thread = new Thread(emailUtil);
				thread.start();
			}
				log.info("pickup execution Ends");
			} catch (Exception e) {
				e.printStackTrace();
				log.error("Error on pickup execution. ", e);
				throw e;
			}
		
	}
	private String getMailBody(User user ,Tenant tenant) {
		StringBuffer bodyBuff = new StringBuffer();
		
		bodyBuff.append("Dear ").append(tenant.getFirstName()).append(" ").append(tenant.getLastName()).append(",\n\n")
		//.append("Subject:").append(pack.getSubject()).append("\n\n")
		.append("This is to confirm that your package has been picked. The details are as follows:-\n")
		.append("Date:").append(pack.getPickupMonth()).append("/").append(pack.getPickupDay()).append("/").append(pack.getPickupYear()).append("\n")
		.append("Pickedup By:").append(pack.getPickupBy()).append("\n")
		.append("\n\nThanks & Regards,\n").append(user.getFirstName()).append(" ").append(user.getLastName()).append(",").append("\n")
		.append("Email:").append(user.getEmail()).append("\n")
		.append("Phone:").append(user.getCellPhone()).append("\n");

		return bodyBuff.toString();
	}

}
