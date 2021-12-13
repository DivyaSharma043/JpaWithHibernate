package com.jpaWithHibernate.repository;

import com.jpaWithHibernate.JpaWithHibernateApplication;
import com.jpaWithHibernate.entites.Course;
import com.jpaWithHibernate.entites.Review;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNull;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = JpaWithHibernateApplication.class)
class CourseRepositoryTests {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepository courseRepository;

	@Autowired
	EntityManager entityManager;

	@Test
	void findById() {

		Course course = courseRepository.findById(1L);
		assertEquals("Java", course.getName());
	}

//	@Test
//	@DirtiesContext
//	public void deleteById_basic() {
//		courseRepository.deleteById(1L);
//		assertNull("CourseDeleted",courseRepository.findById(1L));
//	}

	@Test
	@DirtiesContext
	void save_basic() {
		Course course = courseRepository.findById(2L);
		assertEquals("Spring Boot", course.getName());

		course.setName("Spring Boot-updation");
		courseRepository.save(course);

		Course course1 = courseRepository.findById(2L);
		assertEquals("Spring Boot-updation", course1.getName());

	}

	@Test
	@Transactional
	public void retreiveReviewsFromCourse()
	{
		Course course = courseRepository.findById(2L);
		logger.info("Courses -> {}", course.getReviews());
	}

	@Test
	@Transactional
	public void retreiveCourseFromReviews()
	{
		Review review = entityManager.find(Review.class, 4004L);
		logger.info("Reviews -> {}", review.getCourse());
	}


}
