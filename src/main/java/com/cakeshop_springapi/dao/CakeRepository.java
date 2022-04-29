package com.cakeshop_springapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cakeshop_springapi.model.ListOfCakes;

import antlr.collections.List;

@Repository

public interface CakeRepository extends JpaRepository<ListOfCakes,Integer>  {

	//List<ListOfCakes> findAll();
	
}
