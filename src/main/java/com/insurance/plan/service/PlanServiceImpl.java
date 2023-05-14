package com.insurance.plan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.plan.dao.PlanCategoryRepo;
import com.insurance.plan.dao.PlanRepo;
import com.insurance.plan.entity.Plan;
import com.insurance.plan.entity.PlanCategory;

@Service
public class PlanServiceImpl implements PlanServiceI {

	@Autowired
	private PlanRepo planRepo;

	@Autowired
	private PlanCategoryRepo planCategoryRepo;

	@Override
	public Map<Integer, String> getAllCategories() {

		List<PlanCategory> listOfCategories = planCategoryRepo.findAll();

		// Converting list collection data into map as return type of method is Map
		// And putting into map

		Map<Integer, String> categoryMap = new HashMap<Integer, String>();

		listOfCategories.forEach(category -> {
			categoryMap.put(category.getCategoryId(), category.getCategoryName());
		});

		return categoryMap;
	}

	@Override
	public Boolean savePlan(Plan plan) {
		Plan save = planRepo.save(plan);

		// Using normal if else

//		if (save.getPlanId()!=null){
//			return true;
//		}else {
//			return false;

		// Using ternary operator
//		return save.getPlanId()!=null ? true : false ;

		// Code for 3 year experienced
		return save.getPlanId() != null;

	}

	@Override
	public List<Plan> getAllPlans() {
		List<Plan> listOfPlan = planRepo.findAll();
		return listOfPlan;
	}

	@Override
	public Plan getSinglePlanById(Integer planId) {
		Optional<Plan> findById = planRepo.findById(planId);
		if (findById.isPresent()) {
			return findById.get();
		} else {
			return null;
		}

	}

	@Override
	public Boolean updatePlan(Plan plan) {
		Plan save = planRepo.save(plan);
		// upsert method
		// It will insert if primary key not available
		// It will insert if primary key is available
		return save.getPlanId() != null;
	}

	@Override
	public Boolean deletePlanById(Integer planId) {

		boolean status = false;

		try {
			planRepo.deleteById(planId);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public Boolean planStatusChange(Integer planId, String status) {
		Optional<Plan> plan = planRepo.findById(planId);
		if(plan.isPresent()) {
			Plan plan2 = plan.get();
			plan2.setActiveSwitch(status);
			planRepo.save(plan2);
			return true;
		}
		return false;
	}

}
