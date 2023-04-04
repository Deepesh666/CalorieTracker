package com.CalorieTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CalorieTracker.model.FoodFile;

@Repository
public interface FoodFileRepository extends JpaRepository<FoodFile, Long> {

	FoodFile findByFoodName(String foodName);
	
}
