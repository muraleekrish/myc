/**
 * 
 */
package com.mycove.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Karthikeyan
 *
 */
@Entity
public class PropertyDTO {

	@Id
	@Column(name="id")
	private long id;
	@Column(name="primary_contact_last_name")
	private String primaryContactLastName;
	@Column(name="primary_contact_first_name")
	private String primaryContactFirstName;
	@Column(name="property_name")
	private String name;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the primaryContactLastName
	 */
	public String getPrimaryContactLastName() {
		return primaryContactLastName;
	}
	/**
	 * @param primaryContactLastName the primaryContactLastName to set
	 */
	public void setPrimaryContactLastName(String primaryContactLastName) {
		this.primaryContactLastName = primaryContactLastName;
	}
	/**
	 * @return the primaryContactFirstName
	 */
	public String getPrimaryContactFirstName() {
		return primaryContactFirstName;
	}
	/**
	 * @param primaryContactFirstName the primaryContactFirstName to set
	 */
	public void setPrimaryContactFirstName(String primaryContactFirstName) {
		this.primaryContactFirstName = primaryContactFirstName;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
