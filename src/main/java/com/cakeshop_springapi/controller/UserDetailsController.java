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

import com.cakeshop_springapi.Service.UserService;
import com.cakeshop_springapi.dao.UserRepository;
import com.cakeshop_springapi.dto.MessageDTO;
import com.cakeshop_springapi.model.User;


@RestController
public class UserDetailsController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@PostMapping("user/save") // register
	public ResponseEntity<?> save(@RequestBody User user) {
		try {
			userService.save(user);
			MessageDTO message = new MessageDTO("Success");
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}
		@GetMapping("user/list")
		public List<User> findAll() {
			List<User> userList = userRepository.findAll();
			return userList;
		}
		@DeleteMapping("user/{id}")
		public void delete(@PathVariable("id") Integer id) {
			userRepository.deleteById(id);
		}
		@PutMapping("user/{id}")
		public void update(@PathVariable("id") Integer id, @RequestBody User user) {
			User user2 = new User();
			user2.setId(id);
			userRepository.save(user);
		}
		@GetMapping("user/{id}")
		public User findById(@PathVariable("id") Integer id) {
			Optional<User> user = userRepository.findById(id);
			if (user.isPresent()) {
				User userObj = user.get();
				return userObj;
			} else {
				return null;
			}
		}
		@PostMapping("user/login")
		public ResponseEntity<?> login(@RequestBody User user) {
			try {
				User users=userRepository.findByEmailAndPassword(user.getEmail());
				if(users==null)
				{
					MessageDTO message=new MessageDTO("no records found");
					return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
				}
				else if(users.getPassword().equals(user.getPassword()))
				{
					return new ResponseEntity<>(users,HttpStatus.OK);
				}
				else
				{
					MessageDTO message=new MessageDTO("invalid password");
					return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				MessageDTO message = new MessageDTO(e.getMessage());
				e.printStackTrace();
				return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
			}
		}	

	}



