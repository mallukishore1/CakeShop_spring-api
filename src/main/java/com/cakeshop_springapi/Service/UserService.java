package com.cakeshop_springapi.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cakeshop_springapi.Validation.UserValidation;
import com.cakeshop_springapi.dao.UserRepository;
import com.cakeshop_springapi.model.User;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public void save(User user) throws Exception {
		try {
			UserValidation.validate(user);

			userRepository.save(user);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public String login(User user) throws Exception {
		try {
			UserValidation.loginvalidate(user);
			Optional<User> userObj = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
			if (userObj!=null) {
				// User userObj = user.get();
				return "success";
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public List<User> findAll() throws Exception {
		List<User> listuser = null;
		try {
			listuser = userRepository.findAll();

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return listuser;
	}

	public void deleteById(Integer id) throws Exception {
		try {
			userRepository.deleteById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void update(Integer id, User user) throws Exception {
		try {
			user.setId(id);
			userRepository.save(user);

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public User findById(Integer id) {

		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			User userObj = user.get();
			return userObj;
		} else {
			return null;
		}

	}


	
}