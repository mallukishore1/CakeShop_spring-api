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
import com.cakeshop_springapi.dao.UserRepository;
import com.cakeshop_springapi.model.User;


	@RestController

	public class UserDetailsController {
		@Autowired
		UserRepository userRepository;
		@PostMapping("user/save")
		public void save(@RequestBody User user) {
			userRepository.save(user);
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

	}



