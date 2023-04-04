package com.CalorieTracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "metFile")
public class METFile {

	@Column(name = "metId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "activity")
	private String activity;
	
	@Column(name = "specificMotion")
	private String specificMotion;
	
	@Column(name = "mets")
	private Double met;
	
}
