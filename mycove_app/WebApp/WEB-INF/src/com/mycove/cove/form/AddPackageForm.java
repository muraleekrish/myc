package com.mycove.cove.form;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.mycove.util.util.FormUtil;
import com.mycove.vo.Apartment;

@SuppressWarnings("serial")
public class AddPackageForm extends ActionForm{
	
	private Collection<Apartment> apartments;
	 private String id;
     private String propertyId;
     private String apartmentId;
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
     private String pickupDate;
     private String pickupBy;
     private String sign;
     private String formAction;
     private String apartmentNumber;
     private String apartId;
     
     
	
	
	
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
	 * @return the pickupDate
	 */
	public String getPickupDate() {
		return pickupDate;
	}
	/**
	 * @param pickupDate the pickupDate to set
	 */
	public void setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
	}
	/**
	 * @return the apartments
	 */
	public Collection<Apartment> getApartments() {
		return apartments;
	}
	/**
	 * @param apartments the apartments to set
	 */
	public void setApartments(Collection<Apartment> apartments) {
		this.apartments = apartments;
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
	/**
	 * @param formAction the formAction to set
	 */
	public void setFormAction(String formAction) {
		this.formAction = formAction;
	}
	
	
	public String getApartId() {
		return apartId;
	}
	public void setApartId(String apartId) {
		this.apartId = apartId;
	}
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		super.validate(mapping, request);
		ActionErrors errors = new ActionErrors();

		if (FormUtil.isNullOrBlank(this.getDate()))
			errors.add("date", new ActionError("select.date"));	
		/*if(formAction !="edit")
		{
		if (this.getApartmentId().equals("0"))
		    errors.add("apartmentId",new ActionError("select.apt"));
		}*/
		if (FormUtil.isNullOrBlank(this.getCarrier()))
		    errors.add("carrier",new ActionError("select.carrier"));
		if (FormUtil.isNullOrBlank(this.getPieces()))
		    errors.add("pieces",new ActionError("select.pieces"));
		if (FormUtil.isNullOrBlank(this.getPackageLocation()))
		   errors.add("packageLocation",new ActionError("select.packageLocation"));
	 	if(FormUtil.isNullOrBlank(this.getResidentName()))
	 		errors.add("residentName",new ActionError("select.residentName"));
	 	if(FormUtil.isNullOrBlank(this.getNotes()))
	 		errors.add("notes",new ActionError("select.notes"));
	 	if(FormUtil.isNullOrBlank(this.getSubject()))
	 		errors.add("subject",new ActionError("select.subject"));
	 	if(FormUtil.isNullOrBlank(this.getMessage()))
	 		errors.add("message",new ActionError("select.message"));
		
		return errors;
	}
}