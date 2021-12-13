package com.jpaWithHibernate.repository;

import com.jpaWithHibernate.entites.Course;
import com.jpaWithHibernate.entites.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

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


    public void addHardCodedReviewsForCourse() {

//        get the course
        Course course = findById(3);
        logger.info("course.getReviews() -> {} ", course.getReviews());

//        Add 2 reviews to it
        Review review1= new Review(4006L,"0", "Very Poor",course );
        Review review2= new Review(4007L,"6", "Superb",course );

//        Setting the relationship
        course.addReviews(review1);
        review1.setCourse(course);

        course.addReviews(review2);
        review2.setCourse(course);

//        Save it to the database
        entityManager.persist(review1);
        entityManager.persist(review2);

    }

    public void addReviewsForCourse(Long courseId, List<Review> reviews) {

//        get the course
        Course course = findById(courseId);
        logger.info("course.getReviews() -> {} ", course.getReviews());

//        Setting the relationship
        for (Review review:reviews) {
            course.addReviews(review);
            review.setCourse(course);

//        Save it to the database
            entityManager.persist(review);
        }

    }
}
