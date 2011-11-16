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

public class CustomMessage extends MessageHandler {
	
	private final static Logger log = Logger.getLogger(CustomMessage.class);
	
	private Long loggedUserId;
	private String custommessage;
	private String customsub;
	private List<Long> emailToUserIds;
	
	public CustomMessage(Long userId, String custommessage,String customsub,
			List<Long> emailToUserIds) {

		this.loggedUserId = userId;
		this.custommessage = custommessage;
		this.customsub = customsub;
		this.emailToUserIds = emailToUserIds;
	}
	
	public void execute() throws Exception {
		log.info("SendNotification execution Starts");
		EmailUtil emailUtil;
		User user = new UserDAO().findById(loggedUserId);
		//MessageTemplate messageTemplate = new MessageTemplateDAO().findById(templateId);
		
		
		String mailBody = custommessage;
		for (int i = 0; i < emailToUserIds.size(); i++) {
			try {
				User emailToUser = new TenantDAO().findById(emailToUserIds.get(i));
				emailUtil = new EmailUtil();
				emailUtil.setEmailFrom(user.getEmail());

				List<String> emailTo = new ArrayList<String>();
				emailTo.add(emailToUser.getEmail());
				emailUtil.setEmailTo(emailTo);

				String subject = customsub;
				emailUtil.setSubject(subject);

				emailUtil.setBody(mailBody, EmailUtil.MIME_TYPE_TEXT);
				
				log.info("Storing the message");
				saveEmail(null, user, emailToUser, emailTo, mailBody, subject);
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
