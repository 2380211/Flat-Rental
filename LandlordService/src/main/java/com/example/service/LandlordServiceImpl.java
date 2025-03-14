package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.client.BookingClient;
import com.example.client.FlatClient;
import com.example.dto.FlatDTO;
import com.example.entity.Landlord;
import com.example.exception.LandlordNotFoundException;
import com.example.repository.LandlordRepository;

@Service
public class LandlordServiceImpl implements LandlordService {

	@Autowired
	LandlordRepository repo ;
	
	@Autowired
	FlatClient flatClient ;
	
	@Autowired
	BookingClient bookingClient ;
	
	@Override
	public String addLandlord(Landlord landlord) {
		repo.save(landlord) ;
		return "Landlord has been added successfully";
	}

	@Override
	public Landlord getLandlord(int landlordId) throws LandlordNotFoundException {
		Optional<Landlord> optional = repo.findById(landlordId) ;
		
		if(optional.isEmpty()) {
			throw new LandlordNotFoundException("Landlord Not Found") ;
		}
		return optional.get() ;
	}

	@Override
	public List<Landlord> getAllLandlord() {
		return repo.findAll()	;
	}

	@Override
	public String updateLandlord(Landlord landlord) throws LandlordNotFoundException {
		getLandlord(landlord.getLandlordId()) ;
		repo.save(landlord) ;
		return "Landlord have been Updated Successfully";
	}

	@Override
	public String deleteLandlord(int landlordId) throws LandlordNotFoundException {
		getLandlord(landlordId) ;
		repo.deleteById(landlordId);
		return "Landlord have been removed" ;
	}
	
	// Specific landlord methods

	@Override
	public List<FlatDTO> getAllFlatsOfLandlord(int landlordId) {
		return flatClient.getAllFlatsOfLandlord(landlordId) ;
		
	}

	@Override
	public String addFlat(FlatDTO flat) {
		return flatClient.addFlat(flat);
	}

	@Override
	public FlatDTO getFlat(int flatId) {
		return flatClient.getFlat(flatId) ;
	}

	@Override
	public String updateFlat(FlatDTO flat) {
		return flatClient.updateFlat(flat) ;
	}

	@Override
	public String deleteFlat(int flatId) {
		return flatClient.deleteFlat(flatId) ;
	}

	@Override
	public String cancelBookingOfFlat(int flatId) {
		return bookingClient.cancelBookingOfFlat(flatId) ;
	}
	


}
