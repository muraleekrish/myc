package com.mycove.vo;

// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CodeDetail entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "code_detail", schema = "public")
public class CodeDetail implements java.io.Serializable {

	// Fields

	private Long id;
	private Property property;
	private Code code;
	private String code_1;
	private String description;

	// Constructors

	/** default constructor */
	public CodeDetail() {
	}

	/** minimal constructor */
	public CodeDetail(Long id, Code code) {
		this.id = id;
		this.code = code;
	}

	/** full constructor */
	public CodeDetail(Long id, Property property, Code code,
			String code_1, String description) {
		this.id = id;
		this.property = property;
		this.code = code;
		this.code_1 = code_1;
		this.description = description;
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
	@JoinColumn(name = "property_id")
	public Property getProperty() {
		return this.property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "code_id", nullable = false)
	public Code getCode() {
		return this.code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	@Column(name = "code")
	public String getCode_1() {
		return this.code_1;
	}

	public void setCode_1(String code_1) {
		this.code_1 = code_1;
	}

	@Column(name = "description", length = 1000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}