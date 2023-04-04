package com.CalorieTracker.model;

import java.util.List;

import javax.validation.constraints.NotBlank;

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
@Table(name = "User")
public class User {
	
	@Column(name = "UserId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	@NotBlank(message = "name is mandatory")
	private String name;
	
	@Column(name = "weight")
	@NotBlank(message = "weight is mandatory")
	private String weight;
	
	@Column(name = "height")
	@NotBlank(message = "height is mandatory")
	private String height;
	
	@Column(name = "gender")
	@NotBlank(message = "gender is mandatory")
	private String gender;
	
	@Column(name = "age")
	@NotBlank(message = "age is mandatory")
	private String age;
	
	@Column(name = "bmr")
	private Double bmr;
	
//	@OneToMany(mappedBy = "user")
//	private List<MetUserByDate> metUserByDate;
//	
//	@OneToMany(mappedBy = "user")
//	private List<FoodUserByDate> foodUserByDate;
	
}
