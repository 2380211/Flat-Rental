package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {

	private Integer bookingId ;
	private  Integer tenantId;
	private Integer flatId ;
	
	
}
