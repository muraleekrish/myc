package com.mycove.vo;

// default package

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer", schema = "public")
public class Customer implements java.io.Serializable {

	private static final long serialVersionUID = 3327398320222215521L;

	// Fields
	private Long id;
	private String clientName;
	private String streetAddress;
	private String address2;
	private String city;
	private String state;
	private String zipCode;
	private String customerAdminUsername;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp modifiedDate;
	private Boolean activeFlag;
	private String primaryContactFirstName;
	private String primaryContactLastName;
	private String primaryContactEmailAddress;
	private String primaryContactPhoneNumber;
	private String primaryContactMiddleName;
	private String primaryContactSecondaryPhone;
	private Set<CustomerProperty> customerProperties = new HashSet<CustomerProperty>(0);

	// Constructors

	/** default constructor */
	public Customer() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "client_name", nullable = false, length = 500)
	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@Column(name = "street_address", length = 1000)
	public String getStreetAddress() {
		return this.streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	@Column(name = "address2", length = 1000)
	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "city", length = 50)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state", length = 50)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "zip_code", length = 25)
	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Column(name = "customer_admin_username")
	public String getCustomerAdminUsername() {
		return this.customerAdminUsername;
	}

	public void setCustomerAdminUsername(String customerAdminUsername) {
		this.customerAdminUsername = customerAdminUsername;
	}

	@Column(name = "created_by")
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "created_date", length = 29)
	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "modified_by")
	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Column(name = "modified_date", length = 29)
	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Column(name = "active_flag")
	public Boolean getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Column(name = "primary_contact_first_name")
	public String getPrimaryContactFirstName() {
		return this.primaryContactFirstName;
	}

	public void setPrimaryContactFirstName(String primaryContactFirstName) {
		this.primaryContactFirstName = primaryContactFirstName;
	}

	@Column(name = "primary_contact_last_name")
	public String getPrimaryContactLastName() {
		return this.primaryContactLastName;
	}

	public void setPrimaryContactLastName(String primaryContactLastName) {
		this.primaryContactLastName = primaryContactLastName;
	}

	@Column(name = "primary_contact_email_address")
	public String getPrimaryContactEmailAddress() {
		return this.primaryContactEmailAddress;
	}

	public void setPrimaryContactEmailAddress(String primaryContactEmailAddress) {
		this.primaryContactEmailAddress = primaryContactEmailAddress;
	}

	@Column(name = "primary_contact_phone_number")
	public String getPrimaryContactPhoneNumber() {
		return this.primaryContactPhoneNumber;
	}

	public void setPrimaryContactPhoneNumber(String primaryContactPhoneNumber) {
		this.primaryContactPhoneNumber = primaryContactPhoneNumber;
	}

	@Column(name = "primary_contact_middle_name")
	public String getPrimaryContactMiddleName() {
		return this.primaryContactMiddleName;
	}

	public void setPrimaryContactMiddleName(String primaryContactMiddleName) {
		this.primaryContactMiddleName = primaryContactMiddleName;
	}

	@Column(name = "primary_contact_secondary_phone", length = 50)
	public String getPrimaryContactSecondaryPhone() {
		return this.primaryContactSecondaryPhone;
	}

	public void setPrimaryContactSecondaryPhone(
			String primaryContactSecondaryPhone) {
		this.primaryContactSecondaryPhone = primaryContactSecondaryPhone;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<CustomerProperty> getCustomerProperties() {
		return this.customerProperties;
	}

	public void setCustomerProperties(Set<CustomerProperty> customerProperties) {
		this.customerProperties = customerProperties;
	}

}