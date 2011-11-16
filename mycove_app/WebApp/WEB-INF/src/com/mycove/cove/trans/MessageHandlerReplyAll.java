/**
 * 
 */
package com.mycove.cove.trans;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mycove.dao.MessagesDAO;
import com.mycove.vo.Messages;
import com.mycove.vo.MessagesTo;
import com.mycove.vo.Property;
import com.mycove.vo.User;

 
public class MessageHandlerReplyAll {

	private static final int SUBJECT_PROBLEM_LEN = 30;
    private static final String FOLDER_INBOX = "INBOX";
    private static final String FOLDER_SENT_ITEMS = "SENT ITEMS";
	
	
	/**
	 * 
	 * @param property
	 * @param mailFromUser
	 * @param mailToUser
	 * @param emailTo
	 * @param messageText
	 * @param subject
	 * @throws Exception
	 */
	public void saveEmail(Property property, User mailFromUser, User mailToUser,
			List<String> emailTo,List<User> mailTo, String messageText, String subject) throws Exception {
		int i=0;
		Messages messageFrom = new Messages();
		messageFrom.setCreatedBy(mailFromUser.getUserId());
		messageFrom.setCreatedDate(new Timestamp(new Date().getTime()));
		messageFrom.setFolderName(FOLDER_SENT_ITEMS);
		messageFrom.setFromUser(mailFromUser);
		
		
		messageFrom.setMessageText(messageText);
		messageFrom.setProperty(property);
		messageFrom.setSubject(subject);
		messageFrom.setUser(mailFromUser);
		for(i=0;i<mailTo.size();i++)
		{
		Set<MessagesTo> messagesTos = new HashSet<MessagesTo>();
		messagesTos.add(new MessagesTo(mailTo.get(i), messageFrom));
		messageFrom.setMessagesTos(messagesTos);
		MessagesDAO messagesDAO = new MessagesDAO();
		messagesDAO.save(messageFrom);
		}
		MessagesDAO messagesDAO = new MessagesDAO();
		messagesDAO.save(messageFrom);

        for(i=0;i<mailTo.size();i++)
        {
		Messages messageTo = new Messages();
		messageTo.setCreatedBy(mailFromUser.getUserId());
		messageTo.setCreatedDate(new Timestamp(new Date().getTime()));
		messageTo.setFolderName(FOLDER_INBOX);
		messageTo.setFromUser(mailFromUser);
		 
		messageTo.setMessageText(messageText);
		messageTo.setProperty(property);
		messageTo.setSubject(subject);		 
		messageTo.setUser(mailTo.get(i));
		int j=0;
		for(j=0;j<mailTo.size();j++)
		{
		Set<MessagesTo> messagesTos1 = new HashSet<MessagesTo>();
		messagesTos1.add(new MessagesTo(mailTo.get(j), messageTo));
		messageTo.setMessagesTos(messagesTos1);
		messagesDAO.save(messageTo);
		}
		messagesDAO.save(messageTo);
        }
	}

	public String getProblemSummary(String problem) {
        if (problem == null) {
            return "";
        }
        if (problem.length() > SUBJECT_PROBLEM_LEN) {
            return problem.substring(0, SUBJECT_PROBLEM_LEN);
        }
        return problem;
    }
}
