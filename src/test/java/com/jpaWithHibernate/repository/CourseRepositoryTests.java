package com.jpaWithHibernate.repository;

import com.jpaWithHibernate.JpaWithHibernateApplication;
import com.jpaWithHibernate.entites.Course;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNull;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = JpaWithHibernateApplication.class)
class CourseRepositoryTests {

	@Autowired
	CourseRepository courseRepository;

	@Test
	void findById() {

		Course course = courseRepository.findById(1L);
		assertEquals("Java", course.getName());
	}

	@Test
	@DirtiesContext
	void deleteById() {

		courseRepository.deleteById(3L);
		assertNull("",courseRepository.findById(3L));
	}

	@Test
	@DirtiesContext
	void save_basic() {
		Course course = courseRepository.findById(2L);
		assertEquals("SpringBoot", course.getName());

		course.setName("SpringBoot-updated");
		courseRepository.save(course);

		Course course1 = courseRepository.findById(2L);
		assertEquals("SpringBoot -updated", course1.getName());

	}


}
