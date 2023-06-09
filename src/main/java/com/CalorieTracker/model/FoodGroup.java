package com.CalorieTracker.model;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "foodGroup")
public class FoodGroup {

	
	@Column(name = "foodGroupId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "foodGroupName")
	private String foodGroupName;
	
//	@OneToMany(mappedBy = "foodGroup")
//	private List<FoodUserByDate> foodUserByDate;
	
}
