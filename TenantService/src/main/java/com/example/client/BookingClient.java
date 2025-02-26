package com.example.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dto.BookingDTO;

@FeignClient(name = "BOOKINGSERVICE", path = "/booking")
public interface BookingClient {

	@PostMapping("/add/{tenantId}/{flatId}")
	public String bookFlat(@PathVariable int tenantId, @PathVariable int flatId);
	
	@GetMapping("/getAllByTenantId/{tenantId}")
	public List<BookingDTO> getAllBookingsByTenantId(@PathVariable int tenantId) ;
}
