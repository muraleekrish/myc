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

/**
 * Building entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "building_master", schema = "public")
public class Building implements java.io.Serializable {

	// Fields

	private Long id;
	private Property property;
	private String buildingName;
	private Set<Apartment> apartments = new HashSet<Apartment>(0);

	// Constructors

	/** default constructor */
	public Building() {
	}

	/** minimal constructor */
	public Building(Long id, Property property, String buildingName) {
		this.id = id;
		this.property = property;
		this.buildingName = buildingName;
	}

	/** full constructor */
	public Building(Long id, Property property, String buildingName,
			Set<Apartment> apartments) {
		this.id = id;
		this.property = property;
		this.buildingName = buildingName;
		this.apartments = apartments;
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

	@Column(name = "building_name", nullable = false)
	public String getBuildingName() {
		return this.buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "building")
	public Set<Apartment> getApartments() {
		return this.apartments;
	}

	public void setApartments(Set<Apartment> apartments) {
		this.apartments = apartments;
	}

}