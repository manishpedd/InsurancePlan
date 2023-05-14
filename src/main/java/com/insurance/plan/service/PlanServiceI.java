package com.insurance.plan.service;

import java.util.List;
import java.util.Map;

import com.insurance.plan.entity.Plan;

public interface PlanServiceI {

	// To get all categories dropdown
	// When we submit key will be submitted and stored in db
	//Category id is present in plan master table 
	// Category name will be displayed on screen

	public Map<Integer, String> getAllCategories();

	// To save Plan
	public Boolean savePlan(Plan plan);

//	public Plan createPlan(Plan plan);

	// For view plan
	public List<Plan> getAllPlans();

	// To get plan in editable mode
	// When user clicks on edit particular plan, id of that plan is sent to the
	// server
	public Plan getSinglePlanById(Integer planId);

	public Boolean updatePlan(Plan plan);

	public Boolean deletePlanById(Integer planId);

	//Soft delete
	public Boolean planStatusChange(Integer planId, String status);

}
