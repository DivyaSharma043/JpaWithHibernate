package com.jpaWithHibernate.repository;

import com.jpaWithHibernate.JpaWithHibernateApplication;
import com.jpaWithHibernate.entites.Course;
import com.jpaWithHibernate.entites.Review;
import com.jpaWithHibernate.entites.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = JpaWithHibernateApplication.class)
class CourseSpringDataRepositoryTests {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseSpringDataRepository repository;

	@Test
	public void findById_CoursePresent()
	{
		Optional<Course> courseOptional = repository.findById(1L);
		assertTrue(courseOptional.isPresent());
		logger.info("Course is present {}", courseOptional.isPresent());
	}

	@Test
	public void findById_CourseIsNotPresent()
	{
		Optional<Course> courseOptional = repository.findById(100L);
		assertFalse(courseOptional.isPresent());
		logger.info("Course is not present {}", courseOptional.isPresent());
	}

	@Test
	public void save()
	{
		List<Review> review = new ArrayList<>();
		List<Student> student = new ArrayList<>();
		Course course = new Course(23L,"Racloop",LocalDateTime.now(), LocalDateTime.now(), review, student);
		repository.save(course);

		Optional<Course> courseOptional = repository.findById(23L);
		assertTrue(courseOptional.isPresent());
		logger.info("Course is present {}", courseOptional.isPresent(), course.getName());
		logger.info("All courses Before -> {}", repository.findAll());

		course.setName("Racloop Technology");
		repository.save(course);
		logger.info("All courses After-> {}", repository.findAll());
	}

	@Test
	public void findAllAndCount()
	{
		logger.info("All courses -> {}", repository.findAll());
		logger.info("Count of courses -> {}", repository.count());
	}

	@Test
	public void sort()
	{
		Sort sort = Sort.by(Sort.Direction.DESC, "name");
		logger.info("Sorting in descending order -> {}", repository.findAll(sort));

		Sort sort1 = Sort.by(Sort.Direction.ASC, "name");
		logger.info("Sorting in ascending order -> {}", repository.findAll(sort1));
	}

	@Test
	public void pagination()
	{
		PageRequest pageRequest = PageRequest.of(0,2);
		Page<Course> firstPage = repository.findAll(pageRequest);
		logger.info("First Page -> {}", firstPage.getContent());

		Pageable secondPageable = firstPage.nextPageable();
		Page<Course> secondPage = repository.findAll(secondPageable);
		logger.info("Second Page -> {}", secondPage.getContent());

		Pageable thirdPageable = secondPage.nextPageable();
		Page<Course> thirdPage = repository.findAll(thirdPageable);
		logger.info("third Page -> {}", thirdPage.getContent());
	}

	@Test
	public void findByName()
	{
		logger.info("Find Course By Name -> {}", repository.findByName("JPA"));
	}



}
