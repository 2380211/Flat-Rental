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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Flat;
import com.example.exception.FlatNotFoundException;
import com.example.service.FlatService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/flat")
public class FlatController {

	@Autowired
	FlatService service ;
	
	@PostMapping("/add")
	public String addFlat(@RequestBody @Valid Flat flat) {
		service.addFlat(flat) ;
		return "Flat added successfully" ;
	}
	
	@GetMapping("/get/{flatId}")
	public Flat getFlat(@PathVariable int flatId) throws FlatNotFoundException {
		return service.getFlat(flatId) ;
	}
	
	@GetMapping("/getAll")
	public List<Flat> getAll() {
		return service.getAllFlats() ;
	}
	
	@PutMapping("/update")
	public String updateFlat(@RequestBody Flat flat) throws FlatNotFoundException{
		return service.updateFlat(flat) ;
	}
	
	@DeleteMapping("/delete/{flatId}")
	public String deleteFlat( @PathVariable int flatId) throws FlatNotFoundException {
		return service.deleteFlat(flatId) ;
	}
	
	
	// Additional methods
	
	@GetMapping("/getAllFlatsOfLandlord/{landlordId}")
	public List<Flat> getAllFlatsOfLandlord( @PathVariable int landlordId) {
		return service.getAllFlatsByLandlordId(landlordId) ;
	}
	
	
	@GetMapping("/getAllAvailableFlats")
	public List<Flat> getAllAvailableFlats(){
		return service.getAllAvailableFlats() ;
	}
	
	
	@PutMapping("/setStatus/{flatId}")
	public void setStatus(@PathVariable int flatId , @RequestParam String status) {
		service.setStatus( flatId, status) ;
	}
	
	
}
