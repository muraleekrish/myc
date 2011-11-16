package com.mycove.vo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "role_master", schema = "public")
public class Role implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private Set<RolePrivilege> rolePrivileges = new HashSet<RolePrivilege>(0);
	private Set<UserProperty> userProperties = new HashSet<UserProperty>(0);

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public Role(Long id, String name, Set<RolePrivilege> rolePrivileges,
			Set<UserProperty> userProperties) {
		this.id = id;
		this.name = name;
		this.rolePrivileges = rolePrivileges;
		this.userProperties = userProperties;
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

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	public Set<RolePrivilege> getRolePrivileges() {
		return this.rolePrivileges;
	}

	public void setRolePrivileges(Set<RolePrivilege> rolePrivileges) {
		this.rolePrivileges = rolePrivileges;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	public Set<UserProperty> getUserProperties() {
		return this.userProperties;
	}

	public void setUserProperties(Set<UserProperty> userProperties) {
		this.userProperties = userProperties;
	}

}