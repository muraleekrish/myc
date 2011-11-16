package com.mycove.cove.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.mycove.util.util.FormUtil;

@SuppressWarnings("serial")
public class AddResidentForm extends ActionForm{
    private String apttype;
	private String username;
	private String password;
	private String emailadd;
	private String gender;
	private String fname;
	private String mname;
	private String lname;
	private String hphone;
	private String wphone;
	private String cphone;
	private String carrier;
	private String userid;
	private String startdate;
	private String enddate;
	private String parking;
	private String tagno;
	private String formAction;
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * @return the emailadd
	 */
	public String getEmailadd() {
		return emailadd;
	}
	/**
	 * @param emailadd the emailadd to set
	 */
	public void setEmailadd(String emailadd) {
		this.emailadd = emailadd;
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
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}
	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	/**
	 * @return the mname
	 */
	public String getMname() {
		return mname;
	}
	/**
	 * @param mname the mname to set
	 */
	public void setMname(String mname) {
		this.mname = mname;
	}
	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}
	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	/**
	 * @return the hphone
	 */
	public String getHphone() {
		return hphone;
	}
	/**
	 * @param hphone the hphone to set
	 */
	public void setHphone(String hphone) {
		this.hphone = hphone;
	}
	/**
	 * @return the wphone
	 */
	public String getWphone() {
		return wphone;
	}
	/**
	 * @param wphone the wphone to set
	 */
	public void setWphone(String wphone) {
		this.wphone = wphone;
	}
	/**
	 * @return the cphone
	 */
	public String getCphone() {
		return cphone;
	}
	/**
	 * @param cphone the cphone to set
	 */
	public void setCphone(String cphone) {
		this.cphone = cphone;
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
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * @return the authlist
	 */
	
		
	/**
	 * @return the formAction
	 */
	public String getFormAction() {
		return formAction;
	}
	/**
	 * @return the apttype
	 */
	public String getApttype() {
		return apttype;
	}
	/**
	 * @param apttype the apttype to set
	 */
	public void setApttype(String apttype) {
		this.apttype = apttype;
	}
	/**
	 * @return the startdate
	 */
	public String getStartdate() {
		return startdate;
	}
	/**
	 * @param startdate the startdate to set
	 */
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	/**
	 * @return the enddate
	 */
	public String getEnddate() {
		return enddate;
	}
	/**
	 * @param enddate the enddate to set
	 */
	public void setEnddate(String enddate) {
		this.enddate = enddate;
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
	 * @return the tagno
	 */
	public String getTagno() {
		return tagno;
	}
	/**
	 * @param tagno the tagno to set
	 */
	public void setTagno(String tagno) {
		this.tagno = tagno;
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

		if (FormUtil.isNullOrBlank(this.getApttype()))
			errors.add("apttype", new ActionError("select.userid"));	
		if (FormUtil.isNullOrBlank(this.getEmailadd()))
		    errors.add("emailadd",new ActionError("select.email"));
		if (FormUtil.isNullOrBlank(this.getUsername()))
		    errors.add("username",new ActionError("select.fname"));
		if (FormUtil.isNullOrBlank(this.getStartdate()))
		    errors.add("startdate",new ActionError("select.lsd"));
		if (FormUtil.isNullOrBlank(this.getEnddate()))
		    errors.add("enddate",new ActionError("select.led"));
		return errors;
	}
	
	
}
