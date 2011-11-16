package com.mycove.cove.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.mycove.util.util.FormUtil;

@SuppressWarnings("serial")
public class MaintenanceRequestForm extends ActionForm  {
	private String id;
	private String apartment;
	private String name;
	private String contactNo;
	private String maintenanceRequest;
	private String maintenanceLocation;
	private String description;
	private boolean permission;
	private String residentID;
	private String buildingID;
	private String formAction;
	private boolean closeflag;

	public MaintenanceRequestForm() {
		apartment = "";
		name = "";
		contactNo = "";
		closeflag=true;
		maintenanceRequest = "";
		maintenanceLocation = "";
		description = "";
		
		residentID = "";
		buildingID = "";
		formAction = "";
	}

	/**
	 * @return the closeflag
	 */
	public boolean isCloseflag() {
		return closeflag;
	}

	/**
	 * @param closeflag the closeflag to set
	 */
	public void setCloseflag(boolean closeflag) {
		this.closeflag = closeflag;
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
	 * @param formAction
	 *            the formAction to set
	 */
	public void setFormAction(String formAction) {
		this.formAction = formAction;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getMaintenanceRequest() {
		return maintenanceRequest;
	}

	public void setMaintenanceRequest(String maintenanceRequest) {
		this.maintenanceRequest = maintenanceRequest;
	}

	public String getMaintenanceLocation() {
		return maintenanceLocation;
	}

	public void setMaintenanceLocation(String maintenanceLocation) {
		this.maintenanceLocation = maintenanceLocation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the permission
	 */
	public boolean isPermission() {
		return permission;
	}

	/**
	 * @param permission the permission to set
	 */
	public void setPermission(boolean permission) {
		this.permission = permission;
	}

	public String getResidentID() {
		return residentID;
	}

	public void setResidentID(String residentID) {
		this.residentID = residentID;
	}

	public String getBuildingID() {
		return buildingID;
	}

	public void setBuildingID(String buildingID) {
		this.buildingID = buildingID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts.action.ActionForm#validate(org.apache.struts.action
	 * .ActionMapping, javax.servlet.ServletRequest)
	 */
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		super.validate(mapping, request);
		ActionErrors errors = new ActionErrors();
		if (FormUtil.isNullOrBlank(this.getContactNo()))
			errors.add("contactNo", new ActionError("edit.dayPhoneNumber"));
		if (FormUtil.isNullOrBlank(this.getMaintenanceRequest()))
			errors.add("maintenanceRequest", new ActionError("add.request"));
		if (FormUtil.isNullOrBlank(this.getMaintenanceLocation()))
		    errors.add("maintenanceLocation",new ActionError("add.location"));
		
		return errors;
	}
	
	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.maintenanceLocation="";
		this.maintenanceRequest="";
		this.description="";
	}
}
