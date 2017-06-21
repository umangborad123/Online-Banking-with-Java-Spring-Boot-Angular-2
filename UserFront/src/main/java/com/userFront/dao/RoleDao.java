package com.userFront.dao;

import org.springframework.data.repository.CrudRepository;

import com.userFront.domain.security.Role;

public interface RoleDao extends CrudRepository<Role, Integer> {

	Role findByName(String name);
}
