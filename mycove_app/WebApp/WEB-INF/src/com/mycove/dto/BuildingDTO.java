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
public class BuildingDTO {

	@Id
	@Column(name="id")
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="apartmentCount")
	private Integer apartmentCount;
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
	/**
	 * @return the apartmentCount
	 */
	public Integer getApartmentCount() {
		return apartmentCount;
	}
	/**
	 * @param apartmentCount the apartmentCount to set
	 */
	public void setApartmentCount(Integer apartmentCount) {
		this.apartmentCount = apartmentCount;
	}
}
