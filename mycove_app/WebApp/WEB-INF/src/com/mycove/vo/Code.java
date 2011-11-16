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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Code entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "code_master", schema = "public")
public class Code implements java.io.Serializable {

	// Fields

	private Long id;
	private String code;
	private String description;
	private Set<CodeDetail> codeDetails = new HashSet<CodeDetail>(0);

	// Constructors

	/** default constructor */
	public Code() {
	}

	/** minimal constructor */
	public Code(Long id) {
		this.id = id;
	}

	/** full constructor */
	public Code(Long id, String code, String description,
			Set<CodeDetail> codeDetails) {
		this.id = id;
		this.code = code;
		this.description = description;
		this.codeDetails = codeDetails;
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

	@Column(name = "code")
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "description", length = 1000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "code")
	public Set<CodeDetail> getCodeDetails() {
		return this.codeDetails;
	}

	public void setCodeDetails(Set<CodeDetail> codeDetails) {
		this.codeDetails = codeDetails;
	}

}