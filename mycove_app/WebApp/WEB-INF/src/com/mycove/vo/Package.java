package com.mycove.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "package", schema = "public")
public class Package implements java.io.Serializable {

	// Fields

	private Long id;
	private Property property;
	private Apartment apartment;
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

	// Constructors

	/** default constructor */
	public Package() {
	}

	/** minimal constructor */
	public Package(Long id, Property property, Apartment apartment) {
		this.id = id;
		this.property = property;
		this.apartment = apartment;
	}

	/** full constructor */
	public Package(Long id, Property property, Apartment apartment,
			String notes, String carrier, String packageDescription,
			String subject, String packageLocation, String residentName,
			String message, String pieces, String packageYear,
			String packageMonth, String packageDay, Boolean pickupFlag,
			String pickupYear, String pickupMonth, String pickupDay,
			String pickupBy, String sign) {
		this.id = id;
		this.property = property;
		this.apartment = apartment;
		this.notes = notes;
		this.carrier = carrier;
		this.packageDescription = packageDescription;
		this.subject = subject;
		this.packageLocation = packageLocation;
		this.residentName = residentName;
		this.message = message;
		this.pieces = pieces;
		this.packageYear = packageYear;
		this.packageMonth = packageMonth;
		this.packageDay = packageDay;
		this.pickupFlag = pickupFlag;
		this.pickupYear = pickupYear;
		this.pickupMonth = pickupMonth;
		this.pickupDay = pickupDay;
		this.pickupBy = pickupBy;
		this.sign = sign;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "property_id", nullable = false)
	public Property getProperty() {
		return this.property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "apartment_id", nullable = false)
	public Apartment getApartment() {
		return this.apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	@Column(name = "notes", length = 500)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(name = "carrier", length = 50)
	public String getCarrier() {
		return this.carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	@Column(name = "package_description", length = 500)
	public String getPackageDescription() {
		return this.packageDescription;
	}

	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	@Column(name = "subject", length = 500)
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(name = "package_location", length = 50)
	public String getPackageLocation() {
		return this.packageLocation;
	}

	public void setPackageLocation(String packageLocation) {
		this.packageLocation = packageLocation;
	}

	@Column(name = "resident_name", length = 150)
	public String getResidentName() {
		return this.residentName;
	}

	public void setResidentName(String residentName) {
		this.residentName = residentName;
	}

	@Column(name = "message")
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "pieces", length = 50)
	public String getPieces() {
		return this.pieces;
	}

	public void setPieces(String pieces) {
		this.pieces = pieces;
	}

	@Column(name = "package_year", length = 4)
	public String getPackageYear() {
		return this.packageYear;
	}

	public void setPackageYear(String packageYear) {
		this.packageYear = packageYear;
	}

	@Column(name = "package_month", length = 2)
	public String getPackageMonth() {
		return this.packageMonth;
	}

	public void setPackageMonth(String packageMonth) {
		this.packageMonth = packageMonth;
	}

	@Column(name = "package_day", length = 2)
	public String getPackageDay() {
		return this.packageDay;
	}

	public void setPackageDay(String packageDay) {
		this.packageDay = packageDay;
	}

	@Column(name = "pickup_flag")
	public Boolean getPickupFlag() {
		return this.pickupFlag;
	}

	public void setPickupFlag(Boolean pickupFlag) {
		this.pickupFlag = pickupFlag;
	}

	@Column(name = "pickup_year", length = 4)
	public String getPickupYear() {
		return this.pickupYear;
	}

	public void setPickupYear(String pickupYear) {
		this.pickupYear = pickupYear;
	}

	@Column(name = "pickup_month", length = 2)
	public String getPickupMonth() {
		return this.pickupMonth;
	}

	public void setPickupMonth(String pickupMonth) {
		this.pickupMonth = pickupMonth;
	}

	@Column(name = "pickup_day", length = 2)
	public String getPickupDay() {
		return this.pickupDay;
	}

	public void setPickupDay(String pickupDay) {
		this.pickupDay = pickupDay;
	}

	@Column(name = "pickup_by")
	public String getPickupBy() {
		return this.pickupBy;
	}

	public void setPickupBy(String pickupBy) {
		this.pickupBy = pickupBy;
	}

	@Column(name = "sign")
	public String getSign() {
		return this.sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}