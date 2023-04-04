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
@Table(name = "UserFoodMetByDate")
public class UserFoodMetByDate {
	

	@Column(name = "ufmId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

}
