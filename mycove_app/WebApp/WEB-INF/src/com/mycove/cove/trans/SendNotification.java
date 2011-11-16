/**
 * 
 */
package com.mycove.cove.trans;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mycove.dao.MessageTemplateDAO;
import com.mycove.dao.TenantDAO;
import com.mycove.dao.UserDAO;
import com.mycove.util.email.EmailUtil;
import com.mycove.vo.MessageTemplate;
import com.mycove.vo.User;

public class SendNotification extends MessageHandler {
	
	private final static Logger log = Logger.getLogger(SendNotification.class);
	
	private Long loggedUserId;
	private Long templateId;
	private List<Long> emailToUserIds;
	
	public SendNotification(Long userId, Long templateId,
			List<Long> emailToUserIds) {

		this.loggedUserId = userId;
		this.templateId = templateId;
		this.emailToUserIds = emailToUserIds;
	}
	
	public void execute() throws Exception {
		log.info("SendNotification execution Starts");
		EmailUtil emailUtil;
		User user = new UserDAO().findById(loggedUserId);
		MessageTemplate messageTemplate = new MessageTemplateDAO().findById(templateId);
		
		String mailBody = messageTemplate.getMessageText();
		for (int i = 0; i < emailToUserIds.size(); i++) {
			try {
				User emailToUser = new TenantDAO().findById(emailToUserIds.get(i));
				System.out.println("joj"+emailToUserIds.get(i));
				System.out.println(emailToUser.getEmail());
				emailUtil = new EmailUtil();
				emailUtil.setEmailFrom(user.getEmail());

				List<String> emailTo = new ArrayList<String>();
				emailTo.add(emailToUser.getEmail());
				emailUtil.setEmailTo(emailTo);

				String subject = messageTemplate.getSubject();
				emailUtil.setSubject(subject);

				emailUtil.setBody(mailBody, EmailUtil.MIME_TYPE_TEXT);
				
				log.info("Storing the message");
				saveEmail(messageTemplate.getProperty(), user, emailToUser, emailTo, mailBody, subject);
				log.info("Message stored successfully");

				Thread thread = new Thread(emailUtil);
				thread.start();

				log.info("Send Notification execution Ends");
			} catch (Exception e) {
				e.printStackTrace();
				log.error("Error on Send notification execution. ", e);
				throw e;
			}
			
		}
	}

}
