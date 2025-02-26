package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	@Query("SELECT b FROM Booking b WHERE flatId=?1")
	public Booking getBookingByFlatId(int flatId);

	@Query("SELECT b FROM Booking b WHERE tenantId=?1")
	public List<Booking> getAllBookingsByTenantId(int tenantId);
	
	
}
