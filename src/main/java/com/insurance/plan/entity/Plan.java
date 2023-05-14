package com.insurance.plan.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="Plan_Master")
@Data
public class Plan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="plan_id")
	private Integer planId;
	
	@Column(name="plan_name")
	private String planName;
	
	@Column(name="plan_start_date")
	private LocalDate planStartDate;
	
	@Column(name="plan_end_date")
	private LocalDate planEndDate;
	
	@Column(name="is_active_switch")
	private String activeSwitch;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	@Column(name="plan_category_id")
	private Integer plancategoryid;
	
	@Column(name="created_date",updatable= false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(name="updated_date",insertable = false)
	private LocalDate updatedDate;
	
	
	 
	

}
