package com.cakeshop_springapi.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cakeshop_springapi.dao.CakeRepository;
import com.cakeshop_springapi.model.ListOfCakes;


@RestController

public class CakeDetailController {
	@Autowired
	CakeRepository CakeRepository;
	@PostMapping("cake/save")
	public void save(@RequestBody ListOfCakes cake) {
		CakeRepository.save(cake);
	}
	@GetMapping("cake/list")
	public List<ListOfCakes> findAll() {
		List<ListOfCakes> cakeList = CakeRepository.findAll();
		return cakeList;
	}
	@DeleteMapping("cake/{id}")
	public void delete(@PathVariable("id") Integer id) {
		CakeRepository.deleteById(id);
	}
	@PutMapping("cake/{id}")
	public void update(@PathVariable("id") Integer id, @RequestBody ListOfCakes cake) {
	 cake.setId(id);
		CakeRepository.save(cake);
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
