package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Flat;

import jakarta.transaction.Transactional;

@Repository
public interface FlatRepository extends JpaRepository<Flat, Integer> {

	@Query("SELECT f FROM Flat f WHERE f.landlordId=?1")
	public List<Flat> getAllFlatsByLandlordId(int landlordId);

	@Query("SELECT f FROM Flat f WHERE f.status=\"AVAILABLE\"")
	public List<Flat> getAllAvailableFlats();

	@Modifying
    @Transactional
	@Query("UPDATE Flat f SET f.status = ?2 WHERE f.flatId = ?1")
	public int setStatus(int flatId, String status);

	
}
