package com.userFront.Dao;

import org.springframework.data.repository.CrudRepository;

import com.userFront.domain.User;

public interface UserDao extends CrudRepository<User, Long> {

	User findByUsername(String username);
	User findByEmail(String email);
}
