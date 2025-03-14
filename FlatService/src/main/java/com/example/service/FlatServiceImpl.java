package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Flat;
import com.example.exception.FlatNotFoundException;
import com.example.repository.FlatRepository;

@Service
public class FlatServiceImpl implements FlatService {

	@Autowired
	FlatRepository repo;
	
	@Override
	public Flat addFlat(Flat flat) {

		return repo.save(flat);
	}

	
	@Override
	public Flat getFlat(int flatId) throws FlatNotFoundException {

		Flat optional = repo.findById(flatId).orElseThrow(() -> new FlatNotFoundException("Flat not found"));
		return optional;

	}

	
	@Override
	public List<Flat> getAllFlats() {

		return repo.findAll();

	}

	@Override
	public String updateFlat(Flat flat) throws FlatNotFoundException {
		getFlat(flat.getFlatId());
		repo.save(flat);
		return "Flat details have been updated successfully";
	}

	
	@Override
	public String deleteFlat(int flatId) throws FlatNotFoundException {
		getFlat(flatId);
		repo.deleteById(flatId);
		return "Flat deleted successfully";
	}

	// Additional methods

	
	@Override
	public List<Flat> getAllFlatsByLandlordId(int landlordId)  {
		List<Flat> list = repo.getAllFlatsByLandlordId(landlordId);
		return list;

	}


	@Override
	public List<Flat> getAllAvailableFlats() {

		List<Flat> availableFlatList = repo.getAllAvailableFlats();
		
		if (availableFlatList.isEmpty()) {
			throw new FlatNotFoundException("No Flats Available");
		}
		return availableFlatList;

	}

	@Override
	public void setStatus(int flatId, String status) {
		getFlat(flatId) ;
		repo.setStatus(flatId, status);
	}

}
