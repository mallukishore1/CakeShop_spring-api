package com.cakeshop_springapi.dao;
	

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;
    import com.cakeshop_springapi.model.User;

	@Repository

	public interface UserRepository extends JpaRepository<User,Integer>  {

	}

