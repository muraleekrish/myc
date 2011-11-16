package com.mycove.vo;

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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "mycove_user", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "user_id"))
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3327398320222215521L;
	// Fields

	protected String userId;
	protected String userPassword;
	protected String email;
	protected String gender;
	protected String firstName;
	protected String middleName;
	private String lastName;
	protected String homePhone;
	protected String workPhone;
	protected String cellPhone;
	protected Boolean sendEmailSms;
	protected String cellularProvider;
	protected Boolean activeFlag;
	protected String createdBy;
	protected Timestamp createdDate;
	protected String modifiedBy;
	protected Timestamp modifiedDate;
	protected Role role;
	protected Boolean temppwdChanged;
	protected Set<SurveyResults> surveyResultses = new HashSet<SurveyResults>(0);
	protected Set<MessageCC> messageCCs = new HashSet<MessageCC>(0);
	protected Set<MessagesTo> messagesTos = new HashSet<MessagesTo>(0);
	protected Set<UserProperty> userProperties = new HashSet<UserProperty>(0);
	protected Set<Messages> messageses = new HashSet<Messages>(0);
	protected Long id;

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

	// Constructors

	/** default constructor */
	public User() {
		this.temppwdChanged=false;
	}

	@Column(name = "user_id", unique = true, nullable = false)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "user_password")
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "gender", length = 6)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "first_name", length = 100)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "middle_name", length = 100)
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "last_name", length = 100)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "home_phone", length = 25)
	public String getHomePhone() {
		return this.homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	@Column(name = "work_phone", length = 25)
	public String getWorkPhone() {
		return this.workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	@Column(name = "cell_phone", length = 25)
	public String getCellPhone() {
		return this.cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	@Column(name = "send_email_sms")
	public Boolean getSendEmailSms() {
		return this.sendEmailSms;
	}

	public void setSendEmailSms(Boolean sendEmailSms) {
		this.sendEmailSms = sendEmailSms;
	}

	@Column(name = "cellular_provider", length = 100)
	public String getCellularProvider() {
		return this.cellularProvider;
	}

	public void setCellularProvider(String cellularProvider) {
		this.cellularProvider = cellularProvider;
	}

	@Column(name = "active_flag")
	public Boolean getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
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

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "temppwd_changed")
	public Boolean getTemppwdChanged() {
		return this.temppwdChanged;
	}

	public void setTemppwdChanged(Boolean temppwdChanged) {
		this.temppwdChanged = temppwdChanged;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<SurveyResults> getSurveyResultses() {
		return this.surveyResultses;
	}

	public void setSurveyResultses(Set<SurveyResults> surveyResultses) {
		this.surveyResultses = surveyResultses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<MessageCC> getMessageCCs() {
		return this.messageCCs;
	}

	public void setMessageCCs(Set<MessageCC> messageCCs) {
		this.messageCCs = messageCCs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<MessagesTo> getMessagesTos() {
		return this.messagesTos;
	}

	public void setMessagesTos(Set<MessagesTo> messagesTos) {
		this.messagesTos = messagesTos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserProperty> getUserProperties() {
		return this.userProperties;
	}

	public void setUserProperties(Set<UserProperty> userProperties) {
		this.userProperties = userProperties;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Messages> getMessageses() {
		return this.messageses;
	}

	public void setMessageses(Set<Messages> messageses) {
		this.messageses = messageses;
	}
}