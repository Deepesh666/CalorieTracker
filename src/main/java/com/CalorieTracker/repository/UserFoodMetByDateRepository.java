package com.CalorieTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CalorieTracker.model.FoodUserByDate;

@Repository
public interface UserFoodMetByDateRepository extends JpaRepository<FoodUserByDate, Long>{

}
