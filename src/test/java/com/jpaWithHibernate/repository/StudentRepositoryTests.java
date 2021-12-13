package com.jpaWithHibernate.repository;

import com.jpaWithHibernate.JpaWithHibernateApplication;
import com.jpaWithHibernate.entites.Course;
import com.jpaWithHibernate.entites.Passport;
import com.jpaWithHibernate.entites.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNull;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = JpaWithHibernateApplication.class)
class StudentRepositoryTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	EntityManager entityManager;

	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {

	Student student = entityManager.find(Student.class, 2003L);
	logger.info("student ->{}", student);
	logger.info("passport ->{}", student.getPassport());
	}

	@Test
	@Transactional
	public void retrievePassportAndAssociate() {

		Passport passport = entityManager.find(Passport.class, 3003L);
		logger.info("passport ->{}", passport);
		logger.info("student ->{}", passport.getStudent());
	}

	@Test
	@Transactional
	public void retrieveStudentAndCourse() {

		Student student = entityManager.find(Student.class, 2001L);
		logger.info("student ->{}", student);
		logger.info("course ->{}", student.getCourses());
	}

	@Test
	@Transactional
	public void retrieveCourseAndStudent() {

		Course course = entityManager.find(Course.class, 1L);
		logger.info("course ->{}", course);
		logger.info("student ->{}", course.getStudents());
	}
}
