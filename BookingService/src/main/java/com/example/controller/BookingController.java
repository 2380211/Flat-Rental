package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Booking;
import com.example.exception.BookingNotFoundException;
import com.example.service.BookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	BookingService service ;
	
	@PostMapping("/add/{tenantId}/{flatId}")
	public String bookFlat(@PathVariable @Valid int tenantId, @PathVariable @Valid int flatId) {
		return service.bookFlat(flatId, tenantId) ;
		
	}
	
	@DeleteMapping("/cancel/{flatId}")
	public String cancelBooking( @PathVariable int flatId) throws BookingNotFoundException {
		return service.cancelBooking(flatId) ;
	}
	
	@GetMapping("/get/{bookingId}")
	public Booking getBooking(@PathVariable int bookingId) throws BookingNotFoundException {
		return service.getBooking(bookingId) ;
	}
	
	@GetMapping("/getAll")
	public List<Booking> getAllBookings() {
		return service.getAllBookings() ;
	}
	
	@GetMapping("/getAllByTenantId/{tenantId}")
	public List<Booking> getAllBookingsByTenantId(@PathVariable int tenantId){
		return service.getAllBookingsByTenantId(tenantId) ;
	}
	
	
	
	
	
	

}
