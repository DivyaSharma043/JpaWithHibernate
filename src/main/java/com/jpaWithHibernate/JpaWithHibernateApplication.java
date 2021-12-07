package com.jpaWithHibernate;

import com.jpaWithHibernate.entites.Person;
import com.jpaWithHibernate.repository.JpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JpaWithHibernateApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	JpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaWithHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 1001 -> {}", repository.findById(1001));
		logger.info("Inserting -> {}", repository.insert(new Person(1,"D","D",new Date())));
		logger.info("Update 1003 -> {}", repository.update(new Person(1003, "Shabnam", "Jammu", new Date())));
		logger.info("All Users -> {}", repository.findAll());
		repository.delete(1002);
	}


}
