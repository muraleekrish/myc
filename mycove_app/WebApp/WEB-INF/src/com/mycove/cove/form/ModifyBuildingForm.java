package com.mycove.cove.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.mycove.util.util.FormUtil;

@SuppressWarnings("serial")
public class ModifyBuildingForm extends ActionForm {

	private String id;
	private String propertyId;
	private String buildingName;
	private FormFile apartmentFile;
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
	 * @return the apartmentFile
	 */
	public FormFile getApartmentFile() {
		return apartmentFile;
	}
	/**
	 * @param apartmentFile the apartmentFile to set
	 */
	public void setApartmentFile(FormFile apartmentFile) {
		this.apartmentFile = apartmentFile;
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
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
	    super.validate(mapping, request);
		ActionErrors errors = new ActionErrors();
          FormFile size = this.getApartmentFile();
		if (FormUtil.isNullOrBlank(this.getBuildingName()))
			errors.add("buildingName", new ActionError("select.build"));	
		if (apartmentFile.getFileSize() == 0) 
		    errors.add("apartmentFile",new ActionError("select.file"));
				
		return errors;
	}
	
}