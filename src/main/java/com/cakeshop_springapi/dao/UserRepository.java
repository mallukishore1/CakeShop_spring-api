package com.cakeshop_springapi.dao;
	

	import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
    import com.cakeshop_springapi.model.User;

	@Repository

	public interface UserRepository extends JpaRepository<User,Integer>  {
		Optional<User>findByEmailAndPassword(String email,String password);
		 @Query("select u from com.cakeshop_springapi.model.User u where u.email=:email")
		 User findByEmailAndPassword(@Param("email") String email);

	}

