package com.mycove.vo;

import java.sql.Timestamp;
import java.util.Date;
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
 * SurveyOptions entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "survey_options", schema = "public")
public class SurveyOptions implements java.io.Serializable {

	// Fields

	private Long id;
	private Survey survey;
	private String optionText;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp modifiedDate;
	private Set<SurveyResults> surveyResultses = new HashSet<SurveyResults>(0);

	// Constructors

	/** default constructor */
	public SurveyOptions() {
	}

	/** minimal constructor */
	public SurveyOptions(Survey survey, String optionText, String userName) {
		this.survey = survey;
		this.optionText = optionText;
		this.createdBy = userName;
		this.createdDate = new Timestamp(new Date().getTime());
	}

	/** full constructor */
	public SurveyOptions(Long id, Survey survey, String optionText,
			String createdBy, Timestamp createdDate, String modifiedBy,
			Timestamp modifiedDate, Set<SurveyResults> surveyResultses) {
		this.id = id;
		this.survey = survey;
		this.optionText = optionText;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.surveyResultses = surveyResultses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "survey_id", nullable = false)
	public Survey getSurvey() {
		return this.survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	@Column(name = "option_text")
	public String getOptionText() {
		return this.optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "surveyOptions")
	public Set<SurveyResults> getSurveyResultses() {
		return this.surveyResultses;
	}

	public void setSurveyResultses(Set<SurveyResults> surveyResultses) {
		this.surveyResultses = surveyResultses;
	}

}