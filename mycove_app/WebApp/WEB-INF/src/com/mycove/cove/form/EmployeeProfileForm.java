package com.mycove.cove.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.mycove.dao.TenantDAO;
import com.mycove.util.util.FormUtil;
import com.mycove.vo.Tenant;

@SuppressWarnings("serial")
public class EmployeeProfileForm extends ActionForm {

	private String employeeType;
	private String userName;
	private String password;
	private String email;
	private String gender;
	private String firstName;
	private String middleName;
	private String lastName;
	private String homePhone;
	private String workPhone;
	private String cellPhone;
	private Boolean emailsms;
	private String carrier;
	private Boolean activeFlag;
	private String userId;
	private String authList;
	private String address1;
	private String address2;
	private String formAction;
	private Long id;
	
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
	 * @return the employeeType
	 */
	public String getEmployeeType() {
		return employeeType;
	}
	/**
	 * @param employeeType the employeeType to set
	 */
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the homePhone
	 */
	public String getHomePhone() {
		return homePhone;
	}
	/**
	 * @param homePhone the homePhone to set
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	/**
	 * @return the workPhone
	 */
	public String getWorkPhone() {
		return workPhone;
	}
	/**
	 * @param workPhone the workPhone to set
	 */
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	/**
	 * @return the cellPhone
	 */
	public String getCellPhone() {
		return cellPhone;
	}
	/**
	 * @param cellPhone the cellPhone to set
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	/**
	 * @return the carrier
	 */
	public String getCarrier() {
		return carrier;
	}
	/**
	 * @param carrier the carrier to set
	 */
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	/**
	 * @return the activeFlag
	 */
	public Boolean getActiveFlag() {
		return activeFlag;
	}
	/**
	 * @param activeFlag the activeFlag to set
	 */
	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	
	/**
	 * @return the emailsms
	 */
	public Boolean getEmailsms() {
		return emailsms;
	}
	/**
	 * @param emailsms the emailsms to set
	 */
	public void setEmailsms(Boolean emailsms) {
		this.emailsms = emailsms;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the authList
	 */
	public String getAuthList() {
		return authList;
	}
	/**
	 * @param authList the authList to set
	 */
	public void setAuthList(String authList) {
		this.authList = authList;
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
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		super.validate(mapping, request);
		ActionErrors errors = new ActionErrors();
		if (this.getEmployeeType().equalsIgnoreCase("0"))
			errors.add("employeeType", new ActionError("select.Apartid"));
		/*else
		{
			 java.util.List<Tenant> tenants = new TenantDAO().findByPropertyName(TenantDAO.APARTMENT_ID, apartmentId);
			 if(tenants.size() > 0)
				 errors.add("apartmentId", new ActionError("apartid.exist"));
		}*/
		if (FormUtil.isNullOrBlank(this.getUserName()))
			errors.add("userName", new ActionError("select.userid"));	
		
		if (FormUtil.isNullOrBlank(this.getPassword()))
			errors.add("password", new ActionError("select.password"));
		if (FormUtil.isNullOrBlank(this.getEmail()))
		    errors.add("email",new ActionError("select.email"));
		if (FormUtil.isNullOrBlank(this.getFirstName()))
		    errors.add("firstName",new ActionError("select.fname"));
		if (FormUtil.isNullOrBlank(this.getLastName()))
		    errors.add("lastName",new ActionError("select.lname"));
			
		/*if (this.getSendEmailSms()==true)
		{
		if (FormUtil.isNullOrBlank(this.getCellPhone()))
			*/
		 
		return errors;
	}

}
