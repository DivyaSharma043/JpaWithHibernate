package com.jpaWithHibernate.repository;

import com.jpaWithHibernate.entites.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

}
