package com.secure;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.secure.entity.User;
import com.secure.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityJwtApplication {
	
	@Autowired
	private UserRepository repository;
	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(
				new User(101,"admin","admin","admin@gmail.com"),
				new User(102,"admin2","admin2","admin2@gmail.com"),
				new User(103,"admin3","admin3","admin3@gmail.com"),
				new User(104,"admin4","admin4","admin4@gmail.com")
				).collect(Collectors.toList());
		repository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

}
