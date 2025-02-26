package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer flatId;
	
	@NotNull(message = "Flat rent cannot be blank")
	private Double flatRent;
	
	@NotBlank(message = "FlatAddress cannot be blank")
	private String flatAddress;
	
	@NotBlank(message= "Flat type cannot be blank")
	private String type ;
	
	@NotBlank(message= "Status cannot be blank")
	@Pattern(regexp = "AVAILABLE|BOOKED", message = "Status can only be AVAILABLE or BOOKED")
	private String status;
	
	@NotNull(message = "LandlordId cannot be blank")
	private Integer landlordId ;
	}
