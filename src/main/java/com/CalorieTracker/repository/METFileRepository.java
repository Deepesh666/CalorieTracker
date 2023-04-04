package com.CalorieTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CalorieTracker.model.METFile;

@Repository
public interface METFileRepository extends JpaRepository<METFile, Long> {

	@Query(value = "select * from met_file f where f.specific_motion=:specificMotion", nativeQuery = true)
	METFile findBySpecficMotion(@Param("specificMotion") String specificMotion);
	
}
