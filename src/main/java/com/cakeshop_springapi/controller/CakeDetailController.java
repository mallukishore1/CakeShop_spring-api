package com.cakeshop_springapi.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cakeshop_springapi.Service.CakeService;
import com.cakeshop_springapi.Service.CakeService;
import com.cakeshop_springapi.dao.CakeRepository;
import com.cakeshop_springapi.dto.MessageDTO;
import com.cakeshop_springapi.model.ListOfCakes;


@RestController

public class CakeDetailController {
	@Autowired
	CakeRepository CakeRepository;
	
	@Autowired
	CakeService cakeservice;
	
	@PostMapping("cake/save")
	public ResponseEntity<?> save(@RequestBody ListOfCakes cake) {
		try {
			MessageDTO message = new MessageDTO("Success");
			cakeservice.save(cake);
			return new ResponseEntity<>( HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("cake/list")
	public List<ListOfCakes> findAll() {
		List<ListOfCakes> cakeList = CakeRepository.findAll();
		return cakeList;
	}
	@DeleteMapping("cake/{id}")
	public ResponseEntity<?> deletebyid(@PathVariable("id") Integer id) {
		try {
		CakeRepository.deleteById(id);
		MessageDTO message = new MessageDTO("success");
		return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
			
		}
		
	}
	@PutMapping("cake/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody ListOfCakes cake) {
		try {
			cakeservice.update(id,cake);
			MessageDTO message = new MessageDTO("success");
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("cake/{id}")
	public ListOfCakes findById(@PathVariable("id") Integer id) {
		Optional<ListOfCakes> cake = CakeRepository.findById(id);
		if (cake.isPresent()) {
			ListOfCakes cakeObj = cake.get();
			return cakeObj;
		} else {
			return null;
		}
	}

}
