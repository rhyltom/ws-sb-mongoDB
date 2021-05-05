package com.educandoweb.wsmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.educandoweb.wsmongo.domain.Post;
import com.educandoweb.wsmongo.domain.User;
import com.educandoweb.wsmongo.dto.AuthorDTO;
import com.educandoweb.wsmongo.dto.CommentDTO;
import com.educandoweb.wsmongo.repository.PostRepository;
import com.educandoweb.wsmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "partiu viagem", "vou viajar para S. Paulo", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "bom dia", "acordei feliz", new AuthorDTO(maria));	
		
		CommentDTO c1 = new CommentDTO("boa viagem", sdf.parse("21/03/2008"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("aproveite", sdf.parse("22/03/2008"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("otimo dia", sdf.parse("23/03/2008"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}
