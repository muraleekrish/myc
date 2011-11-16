package com.mycove.cove.form;

import org.apache.struts.action.ActionForm;

import com.mycove.vo.Property;

@SuppressWarnings("serial")
public class TemplateListForm extends ActionForm{
	
	private int id;
	private Property property;
	private String templateName;
	private String subject;
	private String messageText;
	private String formAction;
	private String pmid;
	
	
	
	/**
	 * @return the pmid
	 */
	public String getPmid() {
		return pmid;
	}
	/**
	 * @param pmid the pmid to set
	 */
	public void setPmid(String pmid) {
		this.pmid = pmid;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the property
	 */
	public Property getProperty() {
		return property;
	}
	/**
	 * @param property the property to set
	 */
	public void setProperty(Property property) {
		this.property = property;
	}
	/**
	 * @return the templateName
	 */
	public String getTemplateName() {
		return templateName;
	}
	/**
	 * @param templateName the templateName to set
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
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
	
	
	    
	    
}