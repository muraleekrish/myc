package com.mycove.vo;

import java.sql.Timestamp;
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
 * Survey entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name="survey"
    ,schema="public"
)

public class Survey  implements java.io.Serializable {


    // Fields    

     private Long id;
     private Property  property;
     private String question;
     private String startYear;
     private String startMonth;
     private String startDay;
     private String endYear;
     private String endMonth;
     private String endDay;
     private String createdBy;
     private Timestamp createdDate;
     private String modifiedBy;
     private Timestamp modifiedDate;
     private Boolean closeFlag;
     private Timestamp closedDate;
     private Set<SurveyOptions> surveyOptionses = new HashSet<SurveyOptions>(0);


    // Constructors

    /** default constructor */
    public Survey() {
    }

    // Property accessors
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="property_id", nullable=false)
    public Property getProperty() {
        return this.property;
    }
    
    public void setProperty(Property property) {
        this.property = property;
    }
    
    @Column(name="question")

    public String getQuestion() {
        return this.question;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }
    
    @Column(name="start_year", length=4)

    public String getStartYear() {
        return this.startYear;
    }
    
    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }
    
    @Column(name="start_month", length=2)

    public String getStartMonth() {
        return this.startMonth;
    }
    
    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }
    
    @Column(name="start_day", length=2)

    public String getStartDay() {
        return this.startDay;
    }
    
    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }
    
    @Column(name="end_year", length=4)

    public String getEndYear() {
        return this.endYear;
    }
    
    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }
    
    @Column(name="end_month", length=2)

    public String getEndMonth() {
        return this.endMonth;
    }
    
    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth;
    }
    
    @Column(name="end_day", length=2)

    public String getEndDay() {
        return this.endDay;
    }
    
    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }
    
    @Column(name="created_by")

    public String getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    
    @Column(name="created_date", length=29)

    public Timestamp getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
    
    @Column(name="modified_by")

    public String getModifiedBy() {
        return this.modifiedBy;
    }
    
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    
    @Column(name="modified_date", length=29)

    public Timestamp getModifiedDate() {
        return this.modifiedDate;
    }
    
    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    
    @Column(name="close_flag")

    public Boolean getCloseFlag() {
        return this.closeFlag;
    }
    
    public void setCloseFlag(Boolean closeFlag) {
        this.closeFlag = closeFlag;
    }
    
    @Column(name="closed_date", length=29)

    public Timestamp getClosedDate() {
        return this.closedDate;
    }
    
    public void setClosedDate(Timestamp closedDate) {
        this.closedDate = closedDate;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="survey")

    public Set<SurveyOptions> getSurveyOptionses() {
        return this.surveyOptionses;
    }
    
    public void setSurveyOptionses(Set<SurveyOptions> surveyOptionses) {
        this.surveyOptionses = surveyOptionses;
    }
   








}