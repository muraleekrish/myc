package com.mycove.cove.form;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class MaintenanceListForm extends ActionForm{
	    private String id;
	    private String date;
	    private String pmId;
	    private String searchtype;
	    private String problem;
	    private String location;
	    private String searchResultString;
	    public  String apartment;
	    private String formAction;
	    
	    
	    
	    
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
		 * @return the date
		 */
		public String getDate() {
			return date;
		}
		/**
		 * @param date the date to set
		 */
		public void setDate(String date) {
			this.date = date;
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
		 * @return the problem
		 */
		public String getProblem() {
			return problem;
		}
		/**
		 * @param problem the problem to set
		 */
		public void setProblem(String problem) {
			this.problem = problem;
		}
		/**
		 * @return the location
		 */
		public String getLocation() {
			return location;
		}
		/**
		 * @param location the location to set
		 */
		public void setLocation(String location) {
			this.location = location;
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
	    
	  	    
	    
}