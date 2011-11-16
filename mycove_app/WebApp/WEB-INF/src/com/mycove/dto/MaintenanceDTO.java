/**
 * 
 */
package com.mycove.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MaintenanceDTO {

	@Id
	private Long id;
	@Column
	private String dayTimeContact;
	@Column
	private String request;
	@Column
	private String location;
	@Column
	private String description;
	@Column
	private String permission;
	@Column
	private String apartment;
	@Column
	private String date;
	
	
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
	 * @return the dayTimeContact
	 */
	public String getDayTimeContact() {
		return dayTimeContact;
	}
	/**
	 * @param dayTimeContact the dayTimeContact to set
	 */
	public void setDayTimeContact(String dayTimeContact) {
		this.dayTimeContact = dayTimeContact;
	}
	/**
	 * @return the request
	 */
	public String getRequest() {
		return request;
	}
	/**
	 * @param request the request to set
	 */
	public void setRequest(String request) {
		this.request = request;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the permission
	 */
	public String getPermission() {
		return permission;
	}
	/**
	 * @param permission the permission to set
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	
	
	
}
