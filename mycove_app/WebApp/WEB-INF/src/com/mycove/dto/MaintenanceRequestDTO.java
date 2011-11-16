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
public class MaintenanceRequestDTO {

	@Id
	private Long id;
	@Column
	private Integer maintenanceYear;
	@Column
	private Integer maintenanceMonth;
	@Column
	private Integer maintenanceDay;
	@Column
	private String problem;
	@Column
	private String location;
	@Column
	private String request;
	@Column
	private String apartmentNumber;
	
	
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
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
	 * @return the maintenanceYear
	 */
	public Integer getMaintenanceYear() {
		return maintenanceYear;
	}
	/**
	 * @param maintenanceYear the maintenanceYear to set
	 */
	public void setMaintenanceYear(Integer maintenanceYear) {
		this.maintenanceYear = maintenanceYear;
	}
	/**
	 * @return the maintenanceMonth
	 */
	public Integer getMaintenanceMonth() {
		return maintenanceMonth;
	}
	/**
	 * @param maintenanceMonth the maintenanceMonth to set
	 */
	public void setMaintenanceMonth(Integer maintenanceMonth) {
		this.maintenanceMonth = maintenanceMonth;
	}
	/**
	 * @return the maintenanceDay
	 */
	public Integer getMaintenanceDay() {
		return maintenanceDay;
	}
	/**
	 * @param maintenanceDay the maintenanceDay to set
	 */
	public void setMaintenanceDay(Integer maintenanceDay) {
		this.maintenanceDay = maintenanceDay;
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
}
