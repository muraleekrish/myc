package com.mycove.cove.form;

import org.apache.struts.action.ActionForm;


public class MailBoxForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2404732337056930091L;
	private String msgid;
	private String date;
	private String from;
	private String subject;
	private String formAction;
	
	/**
	 * @return the msgid
	 */
	public String getMsgid() {
		return msgid;
	}
	/**
	 * @param msgid the msgid to set
	 */
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	/**
	 * @return the formAction
	 */
	public String getFormAction() {
		return formAction;
	}
	/**
	 * @param formAction the formAction to set
	 */
	public void setFormAction(String formAction) {
		this.formAction = formAction;
	}
	
	
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
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
			

	
	
	 
}
