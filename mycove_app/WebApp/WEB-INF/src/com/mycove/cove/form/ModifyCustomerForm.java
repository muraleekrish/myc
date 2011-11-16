package com.mycove.cove.form;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class ModifyCustomerForm extends ActionForm {

	private String id;
	private String customerName;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipCode;
	private String primaryContactFirstName;
	private String primaryContactLastName;
	private String primaryContactMiddleName;
	private String emailAddress;
	private String phoneNumber;
	private String secondaryPhoneNumber;
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
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}
	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}
	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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
	 * @return the primaryContactMiddleName
	 */
	public String getPrimaryContactMiddleName() {
		return primaryContactMiddleName;
	}
	/**
	 * @param primaryContactMiddleName the primaryContactMiddleName to set
	 */
	public void setPrimaryContactMiddleName(String primaryContactMiddleName) {
		this.primaryContactMiddleName = primaryContactMiddleName;
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