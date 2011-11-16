package com.mycove.cove.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import antlr.collections.List;

import com.mycove.dao.TenantDAO;
import com.mycove.dao.UserDAO;
import com.mycove.util.util.FormUtil;
import com.mycove.vo.Tenant;
import com.mycove.vo.User;

@SuppressWarnings("serial")
public class TenantProfileForm extends ActionForm{

	private String apartmentId;
	private String id;
	private String userName;
	private String password;
	private String emailAddress;
	private String gender;
	private String firstName;
	private String middleName;
	private String lastName;
	private String homePhone;
	private String workPhone;
	private String cellPhone;
	private boolean sendEmailSms;
	private String carrier;
	private String leaseStartDate;
	private String leaseEndDate;
	private String parking;
	private String tagnumber;
	private String leaseStartMonth;
	private String leaseStartYear;
	private String leaseEndMonth;
	private String leaseEndYear;
	private boolean activeFlag;
	private String tenantId;
	private String formAction;
	
	/**
	 * @return the apartmentId
	 */
	public String getApartmentId() {
		return apartmentId;
	}
	/**
	 * @param apartmentId the apartmentId to set
	 */
	public void setApartmentId(String apartmentId) {
		this.apartmentId = apartmentId;
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
	 * 
	 */
	public TenantProfileForm() {
		activeFlag = true;
		//sendEmailSms = true;
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
	 * @return the sendEmailSms
	 */
	public boolean getSendEmailSms() {
		return sendEmailSms;
	}
	/**
	 * @param sendEmailSms the sendEmailSms to set
	 */
	public void setSendEmailSms(boolean sendEmailSms) {
		this.sendEmailSms = sendEmailSms;
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
	 * @return the leaseStartDate
	 */
	public String getLeaseStartDate() {
		return leaseStartDate;
	}
	/**
	 * @param leaseStartDate the leaseStartDate to set
	 */
	public void setLeaseStartDate(String leaseStartDate) {
		this.leaseStartDate = leaseStartDate;
	}
	/**
	 * @return the leaseEndDate
	 */
	public String getLeaseEndDate() {
		return leaseEndDate;
	}
	/**
	 * @param leaseEndDate the leaseEndDate to set
	 */
	public void setLeaseEndDate(String leaseEndDate) {
		this.leaseEndDate = leaseEndDate;
	}
	/**
	 * @return the parking
	 */
	public String getParking() {
		return parking;
	}
	/**
	 * @param parking the parking to set
	 */
	public void setParking(String parking) {
		this.parking = parking;
	}
	/**
	 * @return the tagnumber
	 */
	public String getTagnumber() {
		return tagnumber;
	}
	/**
	 * @param tagnumber the tagnumber to set
	 */
	public void setTagnumber(String tagnumber) {
		this.tagnumber = tagnumber;
	}
	/**
	 * @return the leaseStartMonth
	 */
	public String getLeaseStartMonth() {
		return leaseStartMonth;
	}
	/**
	 * @param leaseStartMonth the leaseStartMonth to set
	 */
	public void setLeaseStartMonth(String leaseStartMonth) {
		this.leaseStartMonth = leaseStartMonth;
	}
	/**
	 * @return the leaseStartYear
	 */
	public String getLeaseStartYear() {
		return leaseStartYear;
	}
	/**
	 * @param leaseStartYear the leaseStartYear to set
	 */
	public void setLeaseStartYear(String leaseStartYear) {
		this.leaseStartYear = leaseStartYear;
	}
	/**
	 * @return the leaseEndMonth
	 */
	public String getLeaseEndMonth() {
		return leaseEndMonth;
	}
	/**
	 * @param leaseEndMonth the leaseEndMonth to set
	 */
	public void setLeaseEndMonth(String leaseEndMonth) {
		this.leaseEndMonth = leaseEndMonth;
	}
	/**
	 * @return the leaseEndYear
	 */
	public String getLeaseEndYear() {
		return leaseEndYear;
	}
	/**
	 * @param leaseEndYear the leaseEndYear to set
	 */
	public void setLeaseEndYear(String leaseEndYear) {
		this.leaseEndYear = leaseEndYear;
	}
	/**
	 * @return the activeFlag
	 */
	public boolean getActiveFlag() {
		return activeFlag;
	}
	/**
	 * @param activeFlag the activeFlag to set
	 */
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	/**
	 * @return the tenantId
	 */
	public String getTenantId() {
		return tenantId;
	}
	/**
	 * @param tenantId the tenantId to set
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
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
		if (this.getApartmentId().equalsIgnoreCase("0"))
			errors.add("apartmentId", new ActionError("select.Apartid"));
		/*else
		{
			 java.util.List<Tenant> tenants = new TenantDAO().findByPropertyName(TenantDAO.APARTMENT_ID, apartmentId);
			 if(tenants.size() > 0)
				 errors.add("apartmentId", new ActionError("apartid.exist"));
		}*/
		if (FormUtil.isNullOrBlank(this.getUserName()))
			errors.add("userName", new ActionError("select.userid"));	
		else
		{ 
			Tenant tenant= new TenantDAO().findByUserId(userName);
			
			if(tenant != null && (FormUtil.isNotNull(request.getParameter(mapping.getParameter()))
					&& request.getParameter(mapping.getParameter()).equals("Save"))) 
				errors.add("userName",new ActionError("userid.exist"));
		}
		if (FormUtil.isNullOrBlank(this.getPassword()))
			errors.add("password", new ActionError("select.password"));
		if (FormUtil.isNullOrBlank(this.getEmailAddress()))
		    errors.add("emailAddress",new ActionError("select.email"));
		if (FormUtil.isNullOrBlank(this.getFirstName()))
		    errors.add("firstName",new ActionError("select.fname"));
		if (FormUtil.isNullOrBlank(this.getLastName()))
		    errors.add("lastName",new ActionError("select.lname"));
		if (FormUtil.isNullOrBlank(this.getLeaseStartDate()))
		    errors.add("leaseStartDate",new ActionError("select.lsd"));
		if (FormUtil.isNullOrBlank(this.getLeaseEndDate()))
		    errors.add("leaseEndDate",new ActionError("select.led"));
		
		if (this.getSendEmailSms()==true)
		{
		if (FormUtil.isNullOrBlank(this.getCellPhone()))
			 errors.add("cellPhone",new ActionError("select.cellphone"));
		}
		 
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
