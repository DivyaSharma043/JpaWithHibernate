package com.jpaWithHibernate.repository;

import com.jpaWithHibernate.entites.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    @PersistenceContext
    EntityManager entityManager;

    public Course findById(long id)
    {
        return entityManager.find(Course.class, id);
    }

    public Course save(Course course)
    {
        if (course.getId() == null)
        {
            entityManager.persist(course);
        }
        else
        {
            entityManager.merge(course);
        }
        return course;
    }

    public void deleteById(long id)
    {
        Course course = findById(id);
        entityManager.remove(course);

    }


}
