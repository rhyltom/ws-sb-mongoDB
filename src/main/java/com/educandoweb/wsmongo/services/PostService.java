package com.educandoweb.wsmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.wsmongo.domain.Post;
import com.educandoweb.wsmongo.repository.PostRepository;
import com.educandoweb.wsmongo.services.exceptions.ObjNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjNotFoundException("obj nao encontrado"));
	}

	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}
	
}
