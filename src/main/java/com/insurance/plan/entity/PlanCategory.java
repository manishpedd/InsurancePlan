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
@Data
@Table(name="plan_category")
public class PlanCategory {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="category_id")
	private Integer categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	@Column(name="is_active_switch")
	private String isactive;
	
	@Column(name="created_date",updatable= false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(name="updated_date",insertable = false)
	private LocalDate updatedDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="updated_by")
	private String updatedBy;
	

}
