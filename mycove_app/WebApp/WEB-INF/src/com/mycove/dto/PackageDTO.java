/**
 * 
 */
package com.mycove.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PackageDTO {

	@Id
	private Long id;
	@Column
	private Integer packageMonth;
	@Column
	private Integer packageDay;
	@Column
	private Integer packageYear;
	@Column
	private String pieces;
	@Column
	private String carrier;
	@Column
	private String packageLocation;
	@Column
	private String firstName;
	@Column
	private String apartmentNumber;
	@Column
	private String lastName;
	@Column
	private String pickupBy;
	@Column
	private String pickupDay;
	@Column
	private String pickupMonth;
	@Column
	private String pickupYear;
	
	
	
	
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
	 * @return the packageMonth
	 */
	public Integer getPackageMonth() {
		return packageMonth;
	}
	/**
	 * @param packageMonth the packageMonth to set
	 */
	public void setPackageMonth(Integer packageMonth) {
		this.packageMonth = packageMonth;
	}
	/**
	 * @return the packageDay
	 */
	public Integer getPackageDay() {
		return packageDay;
	}
	/**
	 * @param packageDay the packageDay to set
	 */
	public void setPackageDay(Integer packageDay) {
		this.packageDay = packageDay;
	}
	/**
	 * @return the packageYear
	 */
	public Integer getPackageYear() {
		return packageYear;
	}
	/**
	 * @param packageYear the packageYear to set
	 */
	public void setPackageYear(Integer packageYear) {
		this.packageYear = packageYear;
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
}
