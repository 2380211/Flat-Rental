package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.client.BookingClient;
import com.example.client.FlatClient;
import com.example.dto.BookingDTO;
import com.example.dto.FlatDTO;
import com.example.entity.Tenant;
import com.example.exception.TenantNotFoundException;
import com.example.repository.TenantRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class TenantServiceImpl implements TenantService {

	@Autowired
	TenantRepository repo ;
	
	@Autowired
	BookingClient bookingClient ;
	
	@Autowired
	FlatClient flatClient ;
	
	@Override
	public String addTenant(Tenant tenant) {
		repo.save(tenant) ;
		return "Tenant has been added successfully";
	}

	@Override
	public Tenant getTenant(int tenantId) throws TenantNotFoundException {
		Optional<Tenant> optional = repo.findById(tenantId) ;
		if(optional.isEmpty()) {
			throw new TenantNotFoundException("Tenant Not Found") ;
		}
		return   optional.get() ;	
	}

	@Override
	public List<Tenant> getAllTenant() {
		return repo.findAll()	;
	}

	@Override
	public String updateTenant(Tenant tenant) throws TenantNotFoundException {
		getTenant(tenant.getTenantId()) ;
		repo.save(tenant) ;
		return "Tenant have been Updated Successfully";
	}

	@Override
	public String deleteTenant(int tenantId) throws TenantNotFoundException {
		getTenant(tenantId) ;
		repo.deleteById(tenantId);
		return "Tenant have been removed" ;
	}

	@CircuitBreaker(name = "bookFlat", fallbackMethod = "fallBackBookingService")
	@Override
	public String bookFlat(int tenantId, int flatId) {
		return bookingClient.bookFlat(tenantId , flatId) ;
	}

	@Override
	public List<FlatDTO> getAllAvailableFlats() {
		return flatClient.getAllAvailableFlats() ;
	}
	
	public String fallBackBookingService(int tenantId, int flatId, Throwable throwable) {
		return "Sorry! Booking service is not available";
	}
	
	
	@Override
	public List<BookingDTO> getAllTenantBookings(int tenantId) {
		return bookingClient.getAllBookingsByTenantId(tenantId) ;
	}


}
