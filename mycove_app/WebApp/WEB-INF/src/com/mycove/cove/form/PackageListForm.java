package com.mycove.cove.form;

import org.apache.struts.action.ActionForm;

import com.mycove.vo.Apartment;
import com.mycove.vo.Property;

@SuppressWarnings("serial")
public class PackageListForm extends ActionForm{
	
	 private Long id;
     private Property property;
     private Apartment apartment;
     private String date;
     private String notes;
     private String carrier;
     private String packageDescription;
     private String subject;
     private String packageLocation;
     private String residentName;
     private String message;
     private String pieces;
     private String packageYear;
     private String packageMonth;
     private String packageDay;
     private Boolean pickupFlag;
     private String pickupYear;
     private String pickupMonth;
     private String pickupDay;
     private String pickupBy;
     private String sign;
     private String formAction;
	
	
	
	


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
	 * @return the apartment
	 */
	public Apartment getApartment() {
		return apartment;
	}



	/**
	 * @param apartment the apartment to set
	 */
	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}



	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}



	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
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
	 * @return the packageDescription
	 */
	public String getPackageDescription() {
		return packageDescription;
	}



	/**
	 * @param packageDescription the packageDescription to set
	 */
	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}



	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}



	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}



	/**
	 * @return the packageLocation
	 */
	public String getPackageLocation() {
		return packageLocation;
	}



	/**
	 * @param packageLocation the packageLocation to set
	 */
	public void setPackageLocation(String packageLocation) {
		this.packageLocation = packageLocation;
	}



	/**
	 * @return the residentName
	 */
	public String getResidentName() {
		return residentName;
	}



	/**
	 * @param residentName the residentName to set
	 */
	public void setResidentName(String residentName) {
		this.residentName = residentName;
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
	 * @return the pieces
	 */
	public String getPieces() {
		return pieces;
	}



	/**
	 * @param pieces the pieces to set
	 */
	public void setPieces(String pieces) {
		this.pieces = pieces;
	}



	/**
	 * @return the packageYear
	 */
	public String getPackageYear() {
		return packageYear;
	}



	/**
	 * @param packageYear the packageYear to set
	 */
	public void setPackageYear(String packageYear) {
		this.packageYear = packageYear;
	}



	/**
	 * @return the packageMonth
	 */
	public String getPackageMonth() {
		return packageMonth;
	}



	/**
	 * @param packageMonth the packageMonth to set
	 */
	public void setPackageMonth(String packageMonth) {
		this.packageMonth = packageMonth;
	}



	/**
	 * @return the packageDay
	 */
	public String getPackageDay() {
		return packageDay;
	}



	/**
	 * @param packageDay the packageDay to set
	 */
	public void setPackageDay(String packageDay) {
		this.packageDay = packageDay;
	}



	/**
	 * @return the pickupFlag
	 */
	public Boolean getPickupFlag() {
		return pickupFlag;
	}



	/**
	 * @param pickupFlag the pickupFlag to set
	 */
	public void setPickupFlag(Boolean pickupFlag) {
		this.pickupFlag = pickupFlag;
	}



	/**
	 * @return the pickupYear
	 */
	public String getPickupYear() {
		return pickupYear;
	}



	/**
	 * @param pickupYear the pickupYear to set
	 */
	public void setPickupYear(String pickupYear) {
		this.pickupYear = pickupYear;
	}



	/**
	 * @return the pickupMonth
	 */
	public String getPickupMonth() {
		return pickupMonth;
	}



	/**
	 * @param pickupMonth the pickupMonth to set
	 */
	public void setPickupMonth(String pickupMonth) {
		this.pickupMonth = pickupMonth;
	}



	/**
	 * @return the pickupDay
	 */
	public String getPickupDay() {
		return pickupDay;
	}



	/**
	 * @param pickupDay the pickupDay to set
	 */
	public void setPickupDay(String pickupDay) {
		this.pickupDay = pickupDay;
	}



	/**
	 * @return the pickupBy
	 */
	public String getPickupBy() {
		return pickupBy;
	}



	/**
	 * @param pickupBy the pickupBy to set
	 */
	public void setPickupBy(String pickupBy) {
		this.pickupBy = pickupBy;
	}



	/**
	 * @return the sign
	 */
	public String getSign() {
		return sign;
	}



	/**
	 * @param sign the sign to set
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}



	/**
	 * @return the formAction
	 */
	public String getFormAction() {
		return formAction;
	}



	public void setFormAction(String formAction) {
		this.formAction = formAction;
	}
	
	
	    
	    
}