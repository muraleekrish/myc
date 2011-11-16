package com.mycove.vo;

// default package

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "apartment_master", schema = "public")
public class Apartment implements java.io.Serializable {

	// Fields

	private Long id;
	private Building building;
	private String apartmentType;
	private String apartmentNumber;
    private Set<MaintenanceRequest> maintenanceRequests = new HashSet<MaintenanceRequest>(0);
	private Set<Package> packages = new HashSet<Package>(0);
	private Set<Tenant> resident = new HashSet<Tenant>(0);

	// Constructors

	/** default constructor */
	public Apartment() {
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
	@JoinColumn(name = "building_id", nullable = false)
	public Building getBuilding() {
		return this.building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	@Column(name = "apartment_type", nullable = false)
	public String getApartmentType() {
		return this.apartmentType;
	}

	public void setApartmentType(String apartmentType) {
		this.apartmentType = apartmentType;
	}

	@Column(name = "apartment_number", nullable = false)
	public String getApartmentNumber() {
		return this.apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "apartment")
	public Set<MaintenanceRequest> getMaintenanceRequests() {
		return this.maintenanceRequests;
	}

	public void setMaintenanceRequests(
			Set<MaintenanceRequest> maintenanceRequests) {
		this.maintenanceRequests = maintenanceRequests;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "apartment")
	public Set<Package> getPackages() {
		return this.packages;
	}

	public void setPackages(Set<Package> packages) {
		this.packages = packages;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "apartment")
	public Set<Tenant> getResident() {
		return this.resident;
	}

	public void setResident(Set<Tenant> resident) {
		this.resident = resident;
	}
}