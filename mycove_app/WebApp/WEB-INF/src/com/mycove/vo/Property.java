/**
 * 
 */
package com.mycove.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Karthikeyan
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="property_master")
public class Property implements Serializable {

	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false, updatable=true)
	private Long id;
	
	@Column(name="created_by", length=255)
	private String createdBy;
	
	@Column(name="created_date")
	private Timestamp createdDate;
	
	@Column(name="modified_by", length=255)
	private String modifiedBy;
	
	@Column(name="modified_date")
	private Timestamp modifiedDate;
	
	@Column(name="Status_Id", nullable=false)
	private Integer statusId;
	
	@Column(name="property_name", nullable=false, length=255)
	private String propertyName;
	
	@Column(name="mailing_address_line1", length=1000)
	private String mailingAddressLine1;
	
	@Column(name="mailing_address_line2", length=1000)
	private String mailingAddressLine2;
	
	@Column(name="mailing_address_city", length=50)
	private String mailingAddressCity;
	
	@Column(name="mailing_address_state", length=50)
	private String mailingAddressState;

	@Column(name="mailing_address_zipcode", length=25)
	private String mailingAddressZipcode;
	
	@Column(name="billing_address_line1", length=1000)
	private String billingAddressLine1;
	
	@Column(name="billing_address_line2", length=1000)
	private String billingAddressLine2;
	
	@Column(name="billing_address_city", length=50)
	private String billingAddressCity;
	
	@Column(name="billing_address_state", length=50)
	private String billingAddressState;
	
	@Column(name="billing_address_zipcode", length=25)
	private String billingAddressZipcode;
	
	@Column(name="property_admin_username", length=255)
	private String adminUserName;
	
	@Column(name="active_flag")
	private Boolean activeFlag;
	
	@Column(name="primary_contact_first_name", length=255)
	private String primaryContactFirstName;
	
	@Column(name="primary_contact_middle_name", length=255)
	private String primaryContactMiddleName;
	
	@Column(name="primary_contact_last_name", length=255)
	private String primaryContactLastName;
	
	@Column(name="primary_contact_email_address", length=255)
	private String primaryContactEmailAddress;
	
	@Column(name="primary_contact_phone_number", length=255)
	private String primaryContactPhoneNumber;
	
	@Column(name="primary_contact_secondary_phone", length=50)
	private String primaryContactSecondaryPhone;

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
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the modifiedDate
	 */
	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * @return the statusId
	 */
	public int getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(int statusId) {
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
	 * @return the mailingAddressLine1
	 */
	public String getMailingAddressLine1() {
		return mailingAddressLine1;
	}

	/**
	 * @param mailingAddressLine1 the mailingAddressLine1 to set
	 */
	public void setMailingAddressLine1(String mailingAddressLine1) {
		this.mailingAddressLine1 = mailingAddressLine1;
	}

	/**
	 * @return the mailingAddressLine2
	 */
	public String getMailingAddressLine2() {
		return mailingAddressLine2;
	}

	/**
	 * @param mailingAddressLine2 the mailingAddressLine2 to set
	 */
	public void setMailingAddressLine2(String mailingAddressLine2) {
		this.mailingAddressLine2 = mailingAddressLine2;
	}

	/**
	 * @return the mailingAddressCity
	 */
	public String getMailingAddressCity() {
		return mailingAddressCity;
	}

	/**
	 * @param mailingAddressCity the mailingAddressCity to set
	 */
	public void setMailingAddressCity(String mailingAddressCity) {
		this.mailingAddressCity = mailingAddressCity;
	}

	/**
	 * @return the mailingAddressState
	 */
	public String getMailingAddressState() {
		return mailingAddressState;
	}

	/**
	 * @param mailingAddressState the mailingAddressState to set
	 */
	public void setMailingAddressState(String mailingAddressState) {
		this.mailingAddressState = mailingAddressState;
	}

	/**
	 * @return the mailingAddressZipcode
	 */
	public String getMailingAddressZipcode() {
		return mailingAddressZipcode;
	}

	/**
	 * @param mailingAddressZipcode the mailingAddressZipcode to set
	 */
	public void setMailingAddressZipcode(String mailingAddressZipcode) {
		this.mailingAddressZipcode = mailingAddressZipcode;
	}

	/**
	 * @return the billingAddressLine1
	 */
	public String getBillingAddressLine1() {
		return billingAddressLine1;
	}

	/**
	 * @param billingAddressLine1 the billingAddressLine1 to set
	 */
	public void setBillingAddressLine1(String billingAddressLine1) {
		this.billingAddressLine1 = billingAddressLine1;
	}

	/**
	 * @return the billingAddressLine2
	 */
	public String getBillingAddressLine2() {
		return billingAddressLine2;
	}

	/**
	 * @param billingAddressLine2 the billingAddressLine2 to set
	 */
	public void setBillingAddressLine2(String billingAddressLine2) {
		this.billingAddressLine2 = billingAddressLine2;
	}

	/**
	 * @return the billingAddressCity
	 */
	public String getBillingAddressCity() {
		return billingAddressCity;
	}

	/**
	 * @param billingAddressCity the billingAddressCity to set
	 */
	public void setBillingAddressCity(String billingAddressCity) {
		this.billingAddressCity = billingAddressCity;
	}

	/**
	 * @return the billingAddressState
	 */
	public String getBillingAddressState() {
		return billingAddressState;
	}

	/**
	 * @param billingAddressState the billingAddressState to set
	 */
	public void setBillingAddressState(String billingAddressState) {
		this.billingAddressState = billingAddressState;
	}

	/**
	 * @return the billingAddressZipcode
	 */
	public String getBillingAddressZipcode() {
		return billingAddressZipcode;
	}

	/**
	 * @param billingAddressZipcode the billingAddressZipcode to set
	 */
	public void setBillingAddressZipcode(String billingAddressZipcode) {
		this.billingAddressZipcode = billingAddressZipcode;
	}

	/**
	 * @return the adminUserName
	 */
	public String getAdminUserName() {
		return adminUserName;
	}

	/**
	 * @param adminUserName the adminUserName to set
	 */
	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	/**
	 * @return the activeFlag
	 */
	public boolean isActive() {
		return activeFlag;
	}

	/**
	 * @param activeFlag the activeFlag to set
	 */
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
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
	 * @return the primaryContactEmailAddress
	 */
	public String getPrimaryContactEmailAddress() {
		return primaryContactEmailAddress;
	}

	/**
	 * @param primaryContactEmailAddress the primaryContactEmailAddress to set
	 */
	public void setPrimaryContactEmailAddress(String primaryContactEmailAddress) {
		this.primaryContactEmailAddress = primaryContactEmailAddress;
	}

	/**
	 * @return the primaryContactPhoneNumber
	 */
	public String getPrimaryContactPhoneNumber() {
		return primaryContactPhoneNumber;
	}

	/**
	 * @param primaryContactPhoneNumber the primaryContactPhoneNumber to set
	 */
	public void setPrimaryContactPhoneNumber(String primaryContactPhoneNumber) {
		this.primaryContactPhoneNumber = primaryContactPhoneNumber;
	}

	/**
	 * @return the primaryContactSecondaryPhone
	 */
	public String getPrimaryContactSecondaryPhone() {
		return primaryContactSecondaryPhone;
	}

	/**
	 * @param primaryContactSecondaryPhone the primaryContactSecondaryPhone to set
	 */
	public void setPrimaryContactSecondaryPhone(String primaryContactSecondaryPhone) {
		this.primaryContactSecondaryPhone = primaryContactSecondaryPhone;
	}
}
