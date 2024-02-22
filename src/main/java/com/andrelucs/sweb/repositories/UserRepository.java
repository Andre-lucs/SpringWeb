package com.andrelucs.sweb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.andrelucs.sweb.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
}
