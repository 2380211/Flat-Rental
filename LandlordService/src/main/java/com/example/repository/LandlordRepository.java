package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Landlord;

@Repository
public interface LandlordRepository extends JpaRepository<Landlord, Integer> {

	
	
}
