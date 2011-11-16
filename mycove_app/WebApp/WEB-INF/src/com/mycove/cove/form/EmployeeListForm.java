package com.mycove.cove.form;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class EmployeeListForm extends ActionForm{
	
	    private String fname;
	    private String pmId;
	    private String searchtype;
	    private String lname;
	    private String emailadd;
	    private String searchResultString;
	    private String surveyid;
	    public  String apartment;
	    private String formAction;
	    
	    
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
	    
	    
}