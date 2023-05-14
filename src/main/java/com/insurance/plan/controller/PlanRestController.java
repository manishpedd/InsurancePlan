package com.insurance.plan.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.plan.entity.Plan;
import com.insurance.plan.service.PlanServiceI;

@RestController
@RequestMapping("/plan")
public class PlanRestController {

	@Autowired
	private PlanServiceI planServiceI;

	// Get all categories

	@GetMapping()
	public ResponseEntity<Map<Integer,String>> getAllCategories() {

		Map<Integer, String> allCategories = planServiceI.getAllCategories();

		return new ResponseEntity<Map<Integer,String>>(allCategories,HttpStatus.OK);

	}

	// Create plan
	@PostMapping("/create")
	public ResponseEntity<String> createPlan(@RequestBody Plan plan) {

		String responsemsg = "";
		Boolean savePlan = planServiceI.savePlan(plan);
		
		if(savePlan) {
			responsemsg = "plan saved successfully";
		}else {
			responsemsg="plan not saved successfully";
		}

		return new ResponseEntity<String>(responsemsg,HttpStatus.CREATED);
	}

	// View/edit plan by id
	@GetMapping("/planid/{planId}")
	public ResponseEntity<Plan> viewPlanById(@PathVariable Integer planId) {

		Plan singlePlanById = planServiceI.getSinglePlanById(planId);

		return new ResponseEntity<Plan>(singlePlanById, HttpStatus.OK);

	}
	
	//get all plans
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> getAllPlans() {
		List<Plan> allPlans = planServiceI.getAllPlans();
		return new ResponseEntity<List<Plan>> (allPlans,HttpStatus.OK);
		
	}
	
	// Update plan
	@PutMapping("/update")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan) {

		Boolean savePlan = planServiceI.savePlan(plan);
		
		String responsemsg="";
		if(savePlan) {
			responsemsg="plan updated successfully";
		}else {
			responsemsg="plan not updated successfully";
		}

		return new ResponseEntity<String>(responsemsg,HttpStatus.CREATED);
	}

	// Planstatuschange
     @PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> planStatusChange(@PathVariable Integer planId,@PathVariable String status) {
    	 
		Boolean planStatusChange = planServiceI.planStatusChange(planId, status);
		
		 String responsemsg = "";
		 
		if(planStatusChange) {
			responsemsg="status changed";
		}else {
			responsemsg="status not changed";
		}
		return new ResponseEntity<String>(responsemsg,HttpStatus.OK);
	}
     
     @DeleteMapping("/delete/{planId}")
 	public ResponseEntity<String> deletePlan(Integer planId) {

    	 String responsemsg = "";
 		 Boolean isDeleted = planServiceI.deletePlanById(planId);
 		 if(isDeleted) {
 			responsemsg = "is deleted";
 		 }else {
 			responsemsg = "not deleted";
 		 }

 		return new ResponseEntity<String>(responsemsg,HttpStatus.CREATED);
 	}
     
	}



