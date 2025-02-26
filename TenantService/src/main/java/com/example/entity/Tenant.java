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
public class Tenant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tenantId;
	
	@NotBlank(message = "Tenant name cannot be blank")
	private String tenantName;
	
	@NotNull(message = "Tenant age cannot be null")
	private int tenantAge;
	
	@NotBlank(message = "Email cannot be blank")
	@Email(message = "Email should be valid")
	private String email;

	@NotBlank(message = "Phone number cannot be blank")
	@Pattern(regexp = "^[+]?[0-9]{10,15}$", message = "Phone number should be valid")
	private String phoneNumber;

}
