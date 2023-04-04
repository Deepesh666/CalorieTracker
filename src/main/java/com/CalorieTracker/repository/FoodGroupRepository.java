package com.CalorieTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CalorieTracker.model.FoodGroup;

@Repository
public interface FoodGroupRepository extends JpaRepository<FoodGroup, Long>{

	FoodGroup findByFoodGroupName(String foodGroupName);
	
}
