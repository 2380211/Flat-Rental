package com.example.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dto.FlatDTO;

@FeignClient(name = "FLATSERVICE", path = "/flat")  
public interface FlatClient {

	@GetMapping("/getAllFlatsOfLandlord/{landlordId}")
	public List<FlatDTO> getAllFlatsOfLandlord(@PathVariable int landlordId) ;
	
	// flat crud operation by Landlord
	
	@PostMapping("/add")
	public String addFlat(@RequestBody FlatDTO flat);
	
	@GetMapping("/get/{flatId}")
	public FlatDTO getFlat(@PathVariable int flatId) ;
	
	@PutMapping("/update")
	public String updateFlat(@RequestBody FlatDTO flat) ;
	
	@DeleteMapping("/delete/{flatId}")
	public String deleteFlat( @PathVariable int flatId) ;
	
}
