package com.CalorieTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CalorieTracker.model.METFile;

@Repository
public interface METFileRepository extends JpaRepository<METFile, Long> {

	METFile findByActivity(String activity);
	
}
