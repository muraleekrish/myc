package com.mycove.vo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tenant", schema = "public")
public class Tenant extends User implements java.io.Serializable {

	
	private static final long serialVersionUID = 3327398320222215521L;
	// Fields
	private String tagnumber;
	private String parking;
	private String leaseStartYear;
	private String leaseStartMonth;
	private String leaseStartDay;
	private String leaseEndYear;
	private String leaseEndMonth;
	private String leaseEndDay;
	private Apartment apartment;
	private Set<TenantPrivilege> tenantPrivileges = new HashSet<TenantPrivilege>(0);

	@Column(name = "tagnumber", length = 50)
	public String getTagnumber() {
		return this.tagnumber;
	}

	public void setTagnumber(String tagnumber) {
		this.tagnumber = tagnumber;
	}

	@Column(name = "parking", length = 50)
	public String getParking() {
		return this.parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	@Column(name = "lease_start_year", length = 4)
	public String getLeaseStartYear() {
		return this.leaseStartYear;
	}

	public void setLeaseStartYear(String leaseStartYear) {
		this.leaseStartYear = leaseStartYear;
	}

	@Column(name = "lease_start_month", length = 2)
	public String getLeaseStartMonth() {
		return this.leaseStartMonth;
	}

	public void setLeaseStartMonth(String leaseStartMonth) {
		this.leaseStartMonth = leaseStartMonth;
	}

	@Column(name = "lease_start_day", length = 2)
	public String getLeaseStartDay() {
		return this.leaseStartDay;
	}

	public void setLeaseStartDay(String leaseStartDay) {
		this.leaseStartDay = leaseStartDay;
	}

	@Column(name = "lease_end_year", length = 4)
	public String getLeaseEndYear() {
		return this.leaseEndYear;
	}

	public void setLeaseEndYear(String leaseEndYear) {
		this.leaseEndYear = leaseEndYear;
	}

	@Column(name = "lease_end_month", length = 2)
	public String getLeaseEndMonth() {
		return this.leaseEndMonth;
	}

	public void setLeaseEndMonth(String leaseEndMonth) {
		this.leaseEndMonth = leaseEndMonth;
	}

	@Column(name = "lease_end_day", length = 2)
	public String getLeaseEndDay() {
		return this.leaseEndDay;
	}

	public void setLeaseEndDay(String leaseEndDay) {
		this.leaseEndDay = leaseEndDay;
	}

	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "apartment_id", nullable = false)
	public Apartment getApartment() {
		return this.apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tenant")
	public Set<TenantPrivilege> getTenantPrivileges() {
		return this.tenantPrivileges;
	}

	public void setTenantPrivileges(Set<TenantPrivilege> tenantPrivileges) {
		this.tenantPrivileges = tenantPrivileges;
	}

}