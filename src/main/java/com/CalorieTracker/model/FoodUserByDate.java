package com.CalorieTracker.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "FoodUserByDate")
public class FoodUserByDate {
	
	@Column(name = "fuId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@Column(name = "createdAt", updatable = false)
//	@CreationTimestamp
//	private LocalDateTime createdAt;
	
	@Column(name = "consumingDate")
	private LocalDate consumingDate;
		
	@Column(name = "serving")
	private String serving;	
	
//	@ManyToOne
//	private FoodFile foodFile;
//	
//	
//	@ManyToOne
//	private FoodGroup foodGroup;
//
//	@ManyToOne
//	private User user;
	
}
