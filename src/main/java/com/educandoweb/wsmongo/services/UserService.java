package com.educandoweb.wsmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.wsmongo.domain.User;
import com.educandoweb.wsmongo.repository.UserRepository;
import com.educandoweb.wsmongo.services.exceptions.ObjNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjNotFoundException("obj nao encontrado"));
	}
	
}
