
package com.mycove.cove.trans;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mycove.cove.form.MailViewForm;
import com.mycove.dao.MessagesDAO;
import com.mycove.dao.TenantDAO;
import com.mycove.dao.UserDAO;
import com.mycove.util.email.EmailUtil;
import com.mycove.vo.Messages;
import com.mycove.vo.Property;
import com.mycove.vo.User;

public class MailForward extends MessageHandlerForward {
	
	private final static Logger log = Logger.getLogger(MailForward.class); 
	
	/**
	 * @param mailViewForm
	 * @throws Exception 
	 */
	 
	
	public void execute(MailViewForm mailViewForm, Long userId , List<Long> emailToUserIds) throws Exception {
		log.info("Mail forward  execution starts...");
		MessagesDAO messagesDAO = new MessagesDAO();
		Messages messages = messagesDAO.findById(Long.parseLong(mailViewForm.getId()));
		UserDAO userDAO = new UserDAO();
		User mailFromUser = userDAO.findById(userId);
		Property property = messages.getProperty();
		 
		try{
			EmailUtil emailUtil = new EmailUtil();
			emailUtil.setEmailFrom(mailFromUser.getEmail());
			List<String> emailTo = new ArrayList<String>();
			String subject = "Fwd:" + mailViewForm.getSubject();
	        String messageText = mailViewForm.getReplyMessage();
	        List<User> mailTo = new ArrayList<User>();  
	        User emailToUser = new User();
			for (int i = 0; i < emailToUserIds.size(); i++) {
			emailToUser = new TenantDAO().findById(emailToUserIds.get(i));
		    
		mailTo.add((emailToUser));
		emailTo.add(emailToUser.getEmail());
		System.out.println("id:"+emailTo);
		 
			}
			saveEmail(property, mailFromUser, emailToUser, emailTo,mailTo, messageText, subject);
			
		emailUtil.setEmailTo(emailTo);
		emailUtil.setSubject(subject);
		emailUtil.setBody(messageText, EmailUtil.MIME_TYPE_TEXT);	 
			 
			Thread thread = new Thread(emailUtil);
			thread.start();
			log.info("Mail forward  execution starts...");
		} catch (Exception e) {
			log.error("Error on mail forward execution. ", e);
			throw e;
		}
		

	}

}
