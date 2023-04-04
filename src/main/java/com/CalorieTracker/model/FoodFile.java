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
@Table(name = "FoodFile")
public class FoodFile {

	@Column(name = "foodId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "serialNumber")
	private Long serialNumber;
	
	@Column(name = "foodName")
	private String foodName;
	
	@Column(name = "foodGroup")
	private String foodGroup;
	
	@Column(name = "calories")
	private Long calories;
	
	@Column(name = "fat(g)")
	private Double fat;
	
	@Column(name = "protein(g)")
	private Double protein;
	
	@Column(name = "carbohydrate(g)")
	private Double carbohydrate;
	
	@Column(name = "servingDescription(1g)")
	private String servingDescription;
	
//	@OneToMany(mappedBy = "foodFile")
//	private List<FoodUserByDate> foodUserByDate;
	
}
