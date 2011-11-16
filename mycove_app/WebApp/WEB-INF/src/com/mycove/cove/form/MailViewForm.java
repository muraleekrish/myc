package com.mycove.cove.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.mycove.util.util.FormUtil;

public class MailViewForm extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3527096821649653531L;
	
	private String from;
	private String to;
	private String message;
	private String date;
	private String subject;
	private String formAction;
	private String id;
	private String[] residentId;
	private String replyMessage;
	private String replyToAll;
	
	
	
	public String getReplyToAll() {
		return replyToAll;
	}
	public void setReplyToAll(String replyToAll) {
		this.replyToAll = replyToAll;
	}
	public String getReplyMessage() {
		return replyMessage;
	}
	public void setReplyMessage(String replyMessage) {
		this.replyMessage = replyMessage;
	}
	public String[] getResidentId() {
		return residentId;
	}
	public void setResidentId(String[] residentId) {
		this.residentId = residentId;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the to
	 */
	public String getTo() {
		return to;
	}
	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
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

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		super.validate(mapping, request);
		ActionErrors errors = new ActionErrors();
		if (FormUtil.isNullOrBlank(this.getResidentId()))
			errors.add("residentId", new ActionError("add.replyMessage"));
		/*if (FormUtil.isNullOrBlank(this.getMessage()))
			errors.add("message", new ActionError("add.message"));*/
		if (FormUtil.isNullOrBlank(this.getSubject()))
			errors.add("subject", new ActionError("add.subject"));
		return errors;
	}
	
	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
	}
}


