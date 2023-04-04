package com.CalorieTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CalorieTracker.model.MetUserByDate;

@Repository
public interface MetUserByDateRepository extends JpaRepository<MetUserByDate, Long>{

}
