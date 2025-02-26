package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
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
public class Landlord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int landlordId;
	
	@NotBlank(message = "Landlord name cannot be blank")
	private String landlordName ;
	
	@NotNull(message = "Landlord age cannot be blank")
	private int landlordAge  ;
	
	@NotBlank(message = "Email cannot be blank")
	@Email(message = "Email should be valid")
	private String email;

	@NotBlank(message = "Phone number cannot be blank")
	@Pattern(regexp = "^[+]?[0-9]{10,15}$", message = "Phone number should be valid")
	private String phoneNumber;

	
	
}

