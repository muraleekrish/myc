/**
 * 
 */
package com.mycove.dto;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mycove.util.util.FormUtil;
import com.mycove.vo.Messages;

/**
 * @author Karthikeyan
 *
 */
public class Message {

	private Long id;
	private String fromUserName;
	private Timestamp createdDate;
	private String subject;
	private String messageText;
	private String folderName;
	private String mailDate;
	/**
	 * 
	 * @param message
	 */
	public Message(Messages message) {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
		this.id = message.getId();
		this.fromUserName = message.getFromUser().getFirstName();
		this.createdDate = message.getCreatedDate();
		this.subject = message.getSubject();
		this.messageText = message.getMessageText();
		this.folderName = message.getFolderName();
		if(FormUtil.isNotNull(createdDate))
			this.mailDate = dateFormat.format(new Date(createdDate.getTime()));
	}
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the createdDate
	 */
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the messageText
	 */
	public String getMessageText() {
		return messageText;
	}
	/**
	 * @param messageText the messageText to set
	 */
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	/**
	 * @return the folderName
	 */
	public String getFolderName() {
		return folderName;
	}
	/**
	 * @param folderName the folderName to set
	 */
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	/**
	 * @return the fromUserName
	 */
	public String getFromUserName() {
		return fromUserName;
	}

	/**
	 * @param fromUserName the fromUserName to set
	 */
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	/**
	 * @return the mailDate
	 */
	public String getMailDate() {
		return mailDate;
	}
}
