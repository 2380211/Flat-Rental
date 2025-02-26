package com.example.service;

import java.util.List;

import com.example.dto.BookingDTO;
import com.example.entity.Booking;
import com.example.exception.BookingNotFoundException;

public interface BookingService {

	public String bookFlat(int flatId, int tenantId);

	public Booking getBooking(int bookingId) throws BookingNotFoundException;

	public List<Booking> getAllBookings();

	public String cancelBooking(int flatId) throws BookingNotFoundException;

	public List<Booking> getAllBookingsByTenantId(int tenantId);

}
