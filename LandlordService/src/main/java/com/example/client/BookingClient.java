package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BOOKINGSERVICE", path = "/booking")
public interface BookingClient {

	@DeleteMapping("/cancel/{flatId}")
	public String cancelBookingOfFlat(@PathVariable int flatId) ;
}
