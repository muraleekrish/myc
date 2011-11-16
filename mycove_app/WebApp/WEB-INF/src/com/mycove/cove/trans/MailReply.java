/**
 * 
 */
package com.mycove.cove.trans;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mycove.cove.form.MailViewForm;
import com.mycove.dao.MessagesDAO;
import com.mycove.dao.UserDAO;
import com.mycove.util.email.EmailUtil;
import com.mycove.vo.Messages;
import com.mycove.vo.Property;
import com.mycove.vo.User;

/**
 * @author Karthikeyan
 *
 */
public class MailReply extends MessageHandler {
	
	private final static Logger log = Logger.getLogger(MailReply.class); 
	
	/**
	 * @param mailViewForm
	 * @throws Exception 
	 */
	public void execute(MailViewForm mailViewForm, Long userId) throws Exception {
		log.info("Mail reply  execution starts...");
		MessagesDAO messagesDAO = new MessagesDAO();
		Messages messages = messagesDAO.findById(Long.parseLong(mailViewForm.getId()));
		UserDAO userDAO = new UserDAO();
		User mailFromUser = userDAO.findById(userId);
		Property property = messages.getProperty();

		List<String> emailTo = new ArrayList<String>();
		
		emailTo.add(messages.getFromUser().getEmail());
		
		String subject = "Re: " + mailViewForm.getSubject();
		String messageText = mailViewForm.getReplyMessage();

		try {
			saveEmail(property, mailFromUser, messages.getFromUser(), emailTo, messageText, subject);

			EmailUtil emailUtil = new EmailUtil();
			emailUtil.setEmailTo(emailTo);
			emailUtil.setSubject(getProblemSummary(subject));
			emailUtil.setBody(messageText, EmailUtil.MIME_TYPE_TEXT);
			Thread thread = new Thread(emailUtil);
			thread.start();
			log.info("Mail reply  execution starts...");
		} catch (Exception e) {
			log.error("Error on mail reply execution. ", e);
			throw e;
		}

	}

}
