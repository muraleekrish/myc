package com.mycove.vo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee", schema = "public")
public class Employee extends User implements java.io.Serializable {

	
	private static final long serialVersionUID = 3327398320222215521L;
	// Fields
	private String address1;
	private String address2;
	private String employeeType;
	private Set<EmployeePrivilege> employeePrivileges = new HashSet<EmployeePrivilege>(0);

	@Column(name = "address1", length = 1000)
	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "address2", length = 1000)
	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "employee_type", length = 50)
	public String getEmployeeType() {
		return this.employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<EmployeePrivilege> getEmployeePrivileges() {
		return this.employeePrivileges;
	}

	public void setEmployeePrivileges(Set<EmployeePrivilege> employeePrivileges) {
		this.employeePrivileges = employeePrivileges;
	}

}