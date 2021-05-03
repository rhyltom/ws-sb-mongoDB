package com.educandoweb.wsmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.wsmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	
	
}
