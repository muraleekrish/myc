package com.mycove.cove.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.mycove.util.util.FormUtil;

@SuppressWarnings("serial")
public class SendNotificationListForm extends ActionForm{
	
	    private String propertyId;
	    private String firstName;
	    private String pmId;
	    private String searchtype;
	    private String lastName;
	    private String emailadd;
	    private String searchResultString;
	    private String surveyid;
	    public  String apartment;
	    private String templateName;
	    private String templateId;
	    private String buildingId;
	    private String[] residentId;
	    private String sendMessage;
	    private String apartmentNumber;
	    
	    private String formAction;
	    
	    
		
		
		/**
		 * @return the buildingId
		 */
		public String getBuildingId() {
			return buildingId;
		}
		/**
		 * @param buildingId the buildingId to set
		 */
		public void setBuildingId(String buildingId) {
			this.buildingId = buildingId;
		}
		/**
		 * @return the apartmentNumber
		 */
		public String getApartmentNumber() {
			return apartmentNumber;
		}
		/**
		 * @param apartmentNumber the apartmentNumber to set
		 */
		public void setApartmentNumber(String apartmentNumber) {
			this.apartmentNumber = apartmentNumber;
		}
		/**
		 * @return the sendMessage
		 */
		public String getSendMessage() {
			return sendMessage;
		}
		/**
		 * @param sendMessage the sendMessage to set
		 */
		public void setSendMessage(String sendMessage) {
			this.sendMessage = sendMessage;
		}
		/**
		 * @return the residentId
		 */
		public String[] getResidentId() {
			return residentId;
		}
		/**
		 * @param residentId the residentId to set
		 */
		public void setResidentId(String[] residentId) {
			this.residentId = residentId;
		}
		/**
		 * @return the templateId
		 */
		public String getTemplateId() {
			return templateId;
		}
		/**
		 * @param templateId the templateId to set
		 */
		public void setTemplateId(String templateId) {
			this.templateId = templateId;
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
		 * @return the templateName
		 */
		public String getTemplateName() {
			return templateName;
		}
		/**
		 * @param templateName the templateName to set
		 */
		public void setTemplateName(String templateName) {
			this.templateName = templateName;
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
		 * @return the pmId
		 */
		public String getPmId() {
			return pmId;
		}
		/**
		 * @param pmId the pmId to set
		 */
		public void setPmId(String pmId) {
			this.pmId = pmId;
		}
		/**
		 * @return the searchtype
		 */
		public String getSearchtype() {
			return searchtype;
		}
		/**
		 * @param searchtype the searchtype to set
		 */
		public void setSearchtype(String searchtype) {
			this.searchtype = searchtype;
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
		 * @return the searchResultString
		 */
		public String getSearchResultString() {
			return searchResultString;
		}
		/**
		 * @param searchResultString the searchResultString to set
		 */
		public void setSearchResultString(String searchResultString) {
			this.searchResultString = searchResultString;
		}
		/**
		 * @return the surveyid
		 */
		public String getSurveyid() {
			return surveyid;
		}
		/**
		 * @param surveyid the surveyid to set
		 */
		public void setSurveyid(String surveyid) {
			this.surveyid = surveyid;
		}
		/**
		 * @return the apartment
		 */
		public String getApartment() {
			return apartment;
		}
		/**
		 * @param apartment the apartment to set
		 */
		public void setApartment(String apartment) {
			this.apartment = apartment;
		}
	    
		@Override
		public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

			super.validate(mapping, request);
			ActionErrors errors = new ActionErrors();

			if (FormUtil.isNullOrBlank(this.getTemplateId()))
				errors.add("templateId", new ActionError("select.templateid"));
			if (FormUtil.isNullOrBlank(this.getSendMessage()))
				errors.add("sendMessage", new ActionError("select.type"));
			if(this.getSendMessage().equals("2"))
			{
			if (this.getResidentId().equals(" "))
				errors.add("residentId", new ActionError("select.residentID"));
				}
			
			return errors;
		}  
		
		@Override
		public void reset(ActionMapping mapping, HttpServletRequest request) {
			super.reset(mapping, request);
			this.templateId="";
			this.sendMessage="";
			
		}
}