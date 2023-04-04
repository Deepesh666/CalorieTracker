package com.CalorieTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CalorieTracker.model.FoodFile;

@Repository
public interface FoodFileRepository extends JpaRepository<FoodFile, Long> {

	@Query(value = "select * from food_file f where f.food_name=:foodName", nativeQuery = true)
	FoodFile findByFoodName(@Param("foodName") String foodName);
	
}
