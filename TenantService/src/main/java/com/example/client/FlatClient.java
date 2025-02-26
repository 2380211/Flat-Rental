package com.example.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.dto.FlatDTO;

@FeignClient(name = "FLATSERVICE" , url = "http://localhost:1111/flat")
public interface FlatClient {
	
	@GetMapping("/getAllAvailableFlats")
	public List<FlatDTO> getAllAvailableFlats() ;
}
