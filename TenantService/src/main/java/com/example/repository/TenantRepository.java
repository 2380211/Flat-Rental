package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Tenant;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Integer> {

	
}
