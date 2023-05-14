package com.insurance.plan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.plan.entity.PlanCategory;

public interface PlanCategoryRepo extends JpaRepository<PlanCategory,Integer>{

}
