package com.insurance.plan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.plan.entity.Plan;

public 	interface PlanRepo extends JpaRepository<Plan, Integer> {
	
	

}
