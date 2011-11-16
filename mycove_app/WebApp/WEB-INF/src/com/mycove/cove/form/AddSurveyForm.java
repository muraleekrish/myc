package com.mycove.cove.form;

import org.apache.struts.action.ActionForm;

import com.mycove.vo.Property;

@SuppressWarnings("serial")
public class AddSurveyForm extends ActionForm{
	
	private int propertyid;
    private String propertyManagerID;
    private Property property;
    private String startDate;
    private String startMonth;
    private String startYear;
    private String endDate;
    private String endMonth;
    private String endYear;
    private String tenantIDs;
    private String surveyID;
    private String currentDate;
    private String message;
    private String question;
    //private ArrayList surveyList;
   //private String selectedSurveys[];
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String option5;
    private String employeeIDs;
    //private String loginDetails[][];
    private String formAction;
    
    
	/**
	 * @return the property
	 */
	public Property getProperty() {
		return property;
	}
	/**
	 * @param property the property to set
	 */
	public void setProperty(Property property) {
		this.property = property;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
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
	 * @return the propertyid
	 */
	public int getPropertyid() {
		return propertyid;
	}
	/**
	 * @param propertyid the propertyid to set
	 */
	public void setPropertyid(int propertyid) {
		this.propertyid = propertyid;
	}
	/**
	 * @return the propertyManagerID
	 */
	public String getPropertyManagerID() {
		return propertyManagerID;
	}
	/**
	 * @param propertyManagerID the propertyManagerID to set
	 */
	public void setPropertyManagerID(String propertyManagerID) {
		this.propertyManagerID = propertyManagerID;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the tenantIDs
	 */
	public String getTenantIDs() {
		return tenantIDs;
	}
	/**
	 * @param tenantIDs the tenantIDs to set
	 */
	public void setTenantIDs(String tenantIDs) {
		this.tenantIDs = tenantIDs;
	}
	/**
	 * @return the surveyID
	 */
	public String getSurveyID() {
		return surveyID;
	}
	/**
	 * @param surveyID the surveyID to set
	 */
	public void setSurveyID(String surveyID) {
		this.surveyID = surveyID;
	}
	/**
	 * @return the currentDate
	 */
	public String getCurrentDate() {
		return currentDate;
	}
	/**
	 * @param currentDate the currentDate to set
	 */
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * @return the option1
	 */
	public String getOption1() {
		return option1;
	}
	/**
	 * @param option1 the option1 to set
	 */
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	/**
	 * @return the option2
	 */
	public String getOption2() {
		return option2;
	}
	/**
	 * @param option2 the option2 to set
	 */
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	/**
	 * @return the option3
	 */
	public String getOption3() {
		return option3;
	}
	/**
	 * @param option3 the option3 to set
	 */
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	/**
	 * @return the option4
	 */
	public String getOption4() {
		return option4;
	}
	/**
	 * @param option4 the option4 to set
	 */
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	/**
	 * @return the option5
	 */
	public String getOption5() {
		return option5;
	}
	/**
	 * @param option5 the option5 to set
	 */
	public void setOption5(String option5) {
		this.option5 = option5;
	}
	/**
	 * @return the employeeIDs
	 */
	public String getEmployeeIDs() {
		return employeeIDs;
	}
	/**
	 * @param employeeIDs the employeeIDs to set
	 */
	public void setEmployeeIDs(String employeeIDs) {
		this.employeeIDs = employeeIDs;
	}
	/**
	 * @return the startMonth
	 */
	public String getStartMonth() {
		return startMonth;
	}
	/**
	 * @param startMonth the startMonth to set
	 */
	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}
	/**
	 * @return the startYear
	 */
	public String getStartYear() {
		return startYear;
	}
	/**
	 * @param startYear the startYear to set
	 */
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}
	/**
	 * @return the endMonth
	 */
	public String getEndMonth() {
		return endMonth;
	}
	/**
	 * @param endMonth the endMonth to set
	 */
	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}
	/**
	 * @return the endYear
	 */
	public String getEndYear() {
		return endYear;
	}
	/**
	 * @param endYear the endYear to set
	 */
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	    
	    
		
	    
	    
}