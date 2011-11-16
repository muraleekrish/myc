package com.mycove.cove.form;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class ModifyPropertyForm extends ActionForm {

	private String id;
	private String statusId;
	private String propertyName;
	private String mailingAddress1;
	private String mailingAddress2;
	private String mailingCity;
	private String mailingState;
	private String mailingZipCode;
	private String billingAddress1;
	private String billingAddress2;
	private String billingCity;
	private String billingState;
	private String billingZipCode;
	private String primaryAdminUserName;
	private String primaryContactFirstName;
	private String primaryContactLastName;
	private String emailAddress;
	private String phoneNumber;
	private String secondaryPhoneNumber;
	private Boolean sameAddress;
	
	
	
	public Boolean getSameAddress() {
		return sameAddress;
	}
	public void setSameAddress(Boolean sameAddress) {
		this.sameAddress = sameAddress;
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
	 * @return the statusId
	 */
	public String getStatusId() {
		return statusId;
	}
	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	/**
	 * @return the propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}
	/**
	 * @param propertyName the propertyName to set
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	/**
	 * @return the mailingAddress1
	 */
	public String getMailingAddress1() {
		return mailingAddress1;
	}
	/**
	 * @param mailingAddress1 the mailingAddress1 to set
	 */
	public void setMailingAddress1(String mailingAddress1) {
		this.mailingAddress1 = mailingAddress1;
	}
	/**
	 * @return the mailingAddress2
	 */
	public String getMailingAddress2() {
		return mailingAddress2;
	}
	/**
	 * @param mailingAddress2 the mailingAddress2 to set
	 */
	public void setMailingAddress2(String mailingAddress2) {
		this.mailingAddress2 = mailingAddress2;
	}
	/**
	 * @return the mailingCity
	 */
	public String getMailingCity() {
		return mailingCity;
	}
	/**
	 * @param mailingCity the mailingCity to set
	 */
	public void setMailingCity(String mailingCity) {
		this.mailingCity = mailingCity;
	}
	/**
	 * @return the mailingState
	 */
	public String getMailingState() {
		return mailingState;
	}
	/**
	 * @param mailingState the mailingState to set
	 */
	public void setMailingState(String mailingState) {
		this.mailingState = mailingState;
	}
	/**
	 * @return the mailingZipCode
	 */
	public String getMailingZipCode() {
		return mailingZipCode;
	}
	/**
	 * @param mailingZipCode the mailingZipCode to set
	 */
	public void setMailingZipCode(String mailingZipCode) {
		this.mailingZipCode = mailingZipCode;
	}
	/**
	 * @return the billingAddress1
	 */
	public String getBillingAddress1() {
		return billingAddress1;
	}
	/**
	 * @param billingAddress1 the billingAddress1 to set
	 */
	public void setBillingAddress1(String billingAddress1) {
		this.billingAddress1 = billingAddress1;
	}
	/**
	 * @return the billingAddress2
	 */
	public String getBillingAddress2() {
		return billingAddress2;
	}
	/**
	 * @param billingAddress2 the billingAddress2 to set
	 */
	public void setBillingAddress2(String billingAddress2) {
		this.billingAddress2 = billingAddress2;
	}
	/**
	 * @return the billingCity
	 */
	public String getBillingCity() {
		return billingCity;
	}
	/**
	 * @param billingCity the billingCity to set
	 */
	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}
	/**
	 * @return the billingState
	 */
	public String getBillingState() {
		return billingState;
	}
	/**
	 * @param billingState the billingState to set
	 */
	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}
	/**
	 * @return the billingZipCode
	 */
	public String getBillingZipCode() {
		return billingZipCode;
	}
	/**
	 * @param billingZipCode the billingZipCode to set
	 */
	public void setBillingZipCode(String billingZipCode) {
		this.billingZipCode = billingZipCode;
	}
	/**
	 * @return the primaryAdminUserName
	 */
	public String getPrimaryAdminUserName() {
		return primaryAdminUserName;
	}
	/**
	 * @param primaryAdminUserName the primaryAdminUserName to set
	 */
	public void setPrimaryAdminUserName(String primaryAdminUserName) {
		this.primaryAdminUserName = primaryAdminUserName;
	}
	/**
	 * @return the primaryContactFirstName
	 */
	public String getPrimaryContactFirstName() {
		return primaryContactFirstName;
	}
	/**
	 * @param primaryContactFirstName the primaryContactFirstName to set
	 */
	public void setPrimaryContactFirstName(String primaryContactFirstName) {
		this.primaryContactFirstName = primaryContactFirstName;
	}
	/**
	 * @return the primaryContactLastName
	 */
	public String getPrimaryContactLastName() {
		return primaryContactLastName;
	}
	/**
	 * @param primaryContactLastName the primaryContactLastName to set
	 */
	public void setPrimaryContactLastName(String primaryContactLastName) {
		this.primaryContactLastName = primaryContactLastName;
	}
	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the secondaryPhoneNumber
	 */
	public String getSecondaryPhoneNumber() {
		return secondaryPhoneNumber;
	}
	/**
	 * @param secondaryPhoneNumber the secondaryPhoneNumber to set
	 */
	public void setSecondaryPhoneNumber(String secondaryPhoneNumber) {
		this.secondaryPhoneNumber = secondaryPhoneNumber;
	}
}