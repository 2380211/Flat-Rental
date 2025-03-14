package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlatDTO {
	
	private Integer flatId ;
	
	private Double flatRent;
	
	private String flatAddress;
	
	private String status;
	
	private Integer landlordId ;
	

}
