package com.daniel.estudos.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.daniel.estudos.domain.Post;
import com.daniel.estudos.domain.User;
import com.daniel.estudos.dto.AuthorDTO;
import com.daniel.estudos.repository.PostRepository;
import com.daniel.estudos.repository.UserRepository;

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

		userRepository.saveAll(Arrays.asList(alex, bob, maria));

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços",
				new AuthorDTO(maria));
		Post post2 = new Post(null, new Date(), "Bom Dia!", "Acordei feliz Hoje!!", new AuthorDTO(maria));

		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
