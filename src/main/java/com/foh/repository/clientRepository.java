package com.foh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foh.entity.clientEntity;

public interface clientRepository extends JpaRepository<clientEntity, Integer> {

	
}
