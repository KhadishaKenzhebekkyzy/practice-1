package com.example.onelab;

import com.example.onelab.controllers.PersonController;
import com.example.onelab.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class OnelabApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(OnelabApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		String sql = "INSERT INTO person (name, age) VALUES (\'Gabrielle\', 25);"+ "INSERT INTO person (name, age) VALUES (\'Anna\', 21);" + "INSERT INTO person (name, age) VALUES (\'Max\', 23);";
		jdbcTemplate.update(sql);
	}
}
