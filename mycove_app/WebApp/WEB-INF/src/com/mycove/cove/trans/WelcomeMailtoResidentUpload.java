/**
 * 
 */
package com.mycove.cove.trans;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mycove.dao.EmployeeDAO;
import com.mycove.util.email.EmailUtil;
import com.mycove.vo.Employee;
import com.mycove.vo.Tenant;

/**
 * @author Karthikeyan
 *
 */
public class WelcomeMailtoResidentUpload extends MessageHandler {

	private final static Logger log = Logger.getLogger(WelcomeMailtoResidentUpload.class);
	
	private Tenant tenant;
	
	
	/**
	 * @param url 
	 * 
	 */
	public WelcomeMailtoResidentUpload(Tenant tenant) {
		
		this.tenant = tenant;
		
	}
	
	/**
	 * @throws Exception 
	 * 
	 */
	public void execute() throws Exception {

		log.info("WelcomeMailtoResident execution Starts");
		try {
			EmailUtil emailUtil = new EmailUtil();
			//Employee employee = (Employee)new EmployeeDAO().findById(userId);
			System.out.println("ttttttttttttttttttttttttttttttttttttttttttttttttt");
			emailUtil.setEmailFrom(tenant.getEmail());
			List<String> emailTo = new ArrayList<String>();
			emailTo.add(tenant.getEmail());
			emailUtil.setEmailTo(emailTo);
			
			String subject = "Welcome to MyCove Community!!!";
			emailUtil.setSubject(subject);
			
			String mailBody = getMailBody(tenant);
			emailUtil.setBody(mailBody, EmailUtil.MIME_TYPE_TEXT);
			Thread thread = new Thread(emailUtil);
			thread.start();
			
			log.info("WelcomeMailtoResident execution Ends");
		} catch (Exception e) {
			log.error("Error on WelcomeMailtoResident execution. ", e);
			throw e;
		}
	

	}

	/**
	 * @param employee
	 * @param tenant2
	 * @return
	 */
	private String getMailBody(Tenant tenant) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Dear ").append(tenant.getFirstName()).append(" ").append(tenant.getLastName()).append(",").append("\n\n")
		.append("\n\nWe are pleased to inform you that you have been registered successfully with the MyCove Community.\n\n")
		
		.append("Your credentials are as follows:-\nLogin:").append(tenant.getUserId()).append("\n")
		.append("Password:").append(tenant.getUserPassword()).append("\n\n\n")
		.append("Thanks & Regards,\nAdministrator,\nMyCove Solutions,\n113,Pavonia Avenue,\nSuite 221,\nJersey city,NJ07310\nPhone: 201-792-1248\n");
		
		return buffer.toString();
	}
}
