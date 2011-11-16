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

public class PackageMail extends MessageHandler {
	
	private final static Logger log = Logger.getLogger(PackageMail.class);
	
	private Long loggedUserId;
	private com.mycove.vo.Package pack; 
	private Long emailToUserId;
	
	public PackageMail(Long userId, com.mycove.vo.Package pack,
			Long emailToUserId) {

		this.loggedUserId = userId;
		this.pack = pack;
		this.emailToUserId = emailToUserId;
	}
	
	public void execute() throws Exception {
		log.info("package execution Starts");
		EmailUtil emailUtil;
		User user = new UserDAO().findById(loggedUserId);
		//com.mycove.vo.Package pack = new PackageDAO().findById(packageId);
				
		try {
				User emailToUser = new TenantDAO().findById(emailToUserId);
				
				System.out.println("rrrrrr"+emailToUser.getEmail());
				 
				emailUtil = new EmailUtil();
				emailUtil.setEmailFrom(user.getEmail());

				List<String> emailTo = new ArrayList<String>();
				emailTo.add(emailToUser.getEmail());				
				emailUtil.setEmailTo(emailTo);
				
				//System.out.println("sdsdsd"+emailToUser.getEmail());
				String subject = pack.getSubject();
				emailUtil.setSubject(subject);
                String mailBody = getMailBody(user);
				emailUtil.setBody(mailBody, EmailUtil.MIME_TYPE_TEXT);
				
				log.info("Storing the message");
				saveEmail(pack.getProperty(), user, emailToUser, emailTo, mailBody, subject);
				log.info("Message stored successfully");

				Thread thread = new Thread(emailUtil);
				thread.start();

				log.info("package execution Ends");
			} catch (Exception e) {
				e.printStackTrace();
				log.error("Error on package execution. ", e);
				throw e;
			}
		
	}
	private String getMailBody(User user) {
		StringBuffer bodyBuff = new StringBuffer();
		
		bodyBuff.append("Dear ").append(pack.getResidentName()).append(",\n")
		.append("Subject:").append(pack.getSubject()).append("\n\n")
		.append("We have received package(s) for you. The details are as follows:-\n")
		.append("Date:").append(pack.getPackageMonth()).append("/").append(pack.getPackageDay()).append("/").append(pack.getPackageYear()).append("\n")
		.append("Description:").append(pack.getPackageDescription()).append("\n")
		.append("Pieces:").append(pack.getPieces()).append("\n")
		.append("Carrier:").append(pack.getCarrier()).append("\n")
		.append("Location(closet):").append(pack.getPackageLocation()).append("\n")
		.append("Message:").append(pack.getMessage()).append("\n")
		.append("Notes:").append(pack.getNotes()).append("\n")
		.append("\n\nThanks & Regards,\n").append(user.getFirstName()).append(" ").append(user.getLastName()).append(",").append("\n")
		.append("Email:").append(user.getEmail()).append("\n")
		.append("Phone:").append(user.getCellPhone()).append("\n");

		return bodyBuff.toString();
	}

}
