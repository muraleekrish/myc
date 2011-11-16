package com.mycove.cove.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

@SuppressWarnings("serial")
public class ModifyResidentForm extends ActionForm {

	private String id;
	private String propertyId;
	private String buildingName;
	private String roleId;
	private String apartmentId;
	private FormFile residentFile;
	
	
	/**
	 * @return the roleId
	 */
	public String getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
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
	 * @return the propertyId
	 */
	public String getPropertyId() {
		return propertyId;
	}
	/**
	 * @param propertyId the propertyId to set
	 */
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	/**
	 * @return the buildingName
	 */
	public String getBuildingName() {
		return buildingName;
	}
	/**
	 * @param buildingName the buildingName to set
	 */
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
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
	 * @return the residentFile
	 */
	public FormFile getResidentFile() {
		return residentFile;
	}
	/**
	 * @param residentFile the residentFile to set
	 */
	public void setResidentFile(FormFile residentFile) {
		this.residentFile = residentFile;
	}
	
	
}