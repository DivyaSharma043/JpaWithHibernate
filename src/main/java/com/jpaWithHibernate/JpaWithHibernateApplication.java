package com.jpaWithHibernate;

import com.jpaWithHibernate.entites.*;
import com.jpaWithHibernate.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {CourseSpringDataRepository.class})
public class JpaWithHibernateApplication implements CommandLineRunner {

//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	JpaRepository repository;
//
//	@Autowired
//	CourseRepository courseRepository;
//
//	@Autowired
//	StudentRepository studentRepository;
//
//	@Autowired
//	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaWithHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Person
//		logger.info("User id 1001 -> {}", repository.findById(1001));
//		logger.info("Inserting -> {}", repository.insert(new Person(1004,"D","D",new Date())));
//		logger.info("Update 1003 -> {}", repository.update(new Person(1003, "Shabnam", "Jammu", new Date())));
//		logger.info("All Users -> {}", repository.findAll());
//		repository.delete(1002);
//
////		Course
////		logger.info("User id 1 -> {}", courseRepository.findById(1L));
////		courseRepository.addHardCodedReviewsForCourse();
//
//		List<Review> reviews = new ArrayList<>();
//		Course course = courseRepository.findById(4L);
//		reviews.add(new Review(4008L,"0", "Very Poor",course ));
//		reviews.add(new Review(4009L,"6", "Superb",course ));
//		courseRepository.addReviewsForCourse(2L, reviews);
//
////		Student
//		studentRepository.saveStudentWithPassport();
//		studentRepository.insertHardCodeStudentAndCourse();
//
//		Passport passport = null;
//		List<Course> courses = new ArrayList<>();
//		List<Student> students = new ArrayList<>();
//		LocalDateTime now = java.time.LocalDateTime.now();
//		studentRepository.insertStudentAndCourse(new Student(2008L, "Rajesh", passport , courses), new Course(8L, "C++",now,now,reviews, students));


//		employeeRepository.insert(new FullTimeEmployee("Divya",new BigDecimal(900000)));
//		employeeRepository.insert(new PartTimeEmployee("Sham",new BigDecimal(2300)));
////		logger.info("All Employess -> {}", employeeRepository.retrieveAllEmployees());
//
//		logger.info("Full Time Employess -> {}", employeeRepository.retrieveFullTimeEmployees());
//		logger.info("Part Time Employess -> {}", employeeRepository.retrievePartTimeEmployees());

	}

}
