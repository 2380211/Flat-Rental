package com.example.service;

import java.util.List;

import com.example.dto.FlatDTO;
import com.example.entity.Landlord;
import com.example.exception.LandlordNotFoundException;

public interface LandlordService {

	public String addLandlord(Landlord tenant);

	public Landlord getLandlord(int landlordId) throws LandlordNotFoundException;

	public List<Landlord> getAllLandlord();

	public String updateLandlord(Landlord landlord) throws LandlordNotFoundException;

	public String deleteLandlord(int landlordId)throws LandlordNotFoundException;

	public List<FlatDTO> getAllFlatsOfLandlord(int landlordId);

	public String addFlat(FlatDTO flat);

	public FlatDTO getFlat(int flatId);

	public String updateFlat(FlatDTO flat);

	public String deleteFlat(int flatId);

	public String cancelBookingOfFlat(int flatId);

}
