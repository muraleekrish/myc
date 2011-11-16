package com.mycove.vo;

import java.sql.Timestamp;

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
@Table(name = "maintenance_request", schema = "public")
public class MaintenanceRequest implements java.io.Serializable {

	// Fields

	private Long id;
	private Property property;
	private Apartment apartment;
	private String maintenanceYear;
	private String maintenanceMonth;
	private String maintenanceDay;
	private String problem;
	private String maintenanceLocation;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp modifiedDate;
	private Boolean closeFlag;
	private Timestamp closedDate;
	private String maintenanceRequest;
	private Boolean entryPermission;
	private String dayTimeContactNo;

	// Constructors

	/** default constructor */
	public MaintenanceRequest() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	@Column(name = "maintenance_year", length = 4)
	public String getMaintenanceYear() {
		return this.maintenanceYear;
	}

	public void setMaintenanceYear(String maintenanceYear) {
		this.maintenanceYear = maintenanceYear;
	}

	@Column(name = "maintenance_month", length = 2)
	public String getMaintenanceMonth() {
		return this.maintenanceMonth;
	}

	public void setMaintenanceMonth(String maintenanceMonth) {
		this.maintenanceMonth = maintenanceMonth;
	}

	@Column(name = "maintenance_day", length = 2)
	public String getMaintenanceDay() {
		return this.maintenanceDay;
	}

	public void setMaintenanceDay(String maintenanceDay) {
		this.maintenanceDay = maintenanceDay;
	}

	@Column(name = "problem")
	public String getProblem() {
		return this.problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	@Column(name = "maintenance_location", length = 50)
	public String getMaintenanceLocation() {
		return this.maintenanceLocation;
	}

	public void setMaintenanceLocation(String maintenanceLocation) {
		this.maintenanceLocation = maintenanceLocation;
	}

	@Column(name = "created_by")
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "created_date", length = 29)
	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "modified_by")
	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Column(name = "modified_date", length = 29)
	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Column(name = "close_flag")
	public Boolean getCloseFlag() {
		return this.closeFlag;
	}

	public void setCloseFlag(Boolean closeFlag) {
		this.closeFlag = closeFlag;
	}

	@Column(name = "closed_date", length = 29)
	public Timestamp getClosedDate() {
		return this.closedDate;
	}

	public void setClosedDate(Timestamp closedDate) {
		this.closedDate = closedDate;
	}

	@Column(name = "maintenance_request", length = 1000)
	public String getMaintenanceRequest() {
		return this.maintenanceRequest;
	}

	public void setMaintenanceRequest(String maintenanceRequest) {
		this.maintenanceRequest = maintenanceRequest;
	}

	@Column(name = "entry_permission")
	public Boolean getEntryPermission() {
		return this.entryPermission;
	}

	public void setEntryPermission(Boolean entryPermission) {
		this.entryPermission = entryPermission;
	}

	@Column(name = "day_time_contact_no", length = 50)
	public String getDayTimeContactNo() {
		return this.dayTimeContactNo;
	}

	public void setDayTimeContactNo(String dayTimeContactNo) {
		this.dayTimeContactNo = dayTimeContactNo;
	}

}