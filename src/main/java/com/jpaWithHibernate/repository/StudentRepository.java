package com.jpaWithHibernate.repository;

import com.jpaWithHibernate.entites.Course;
import com.jpaWithHibernate.entites.Passport;
import com.jpaWithHibernate.entites.Review;
import com.jpaWithHibernate.entites.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
//    @PersistenceContext
    EntityManager entityManager;
    private List<Course> course;
    private Object LocalDateTime;

    public Student findById(long id)
    {
        return entityManager.find(Student.class, id);
    }

    public Student save(Student student)
    {
        if(student.getId()==null)
        {
            entityManager.persist(student);
        }
        else
        {
            entityManager.merge(student);
        }
        return student;
    }

    public void deleteById(long id)
    {
        Student student = findById(id);
        entityManager.remove(student);

    }

    public void saveStudentWithPassport()
    {
        Student student= null;
        Passport passport = new Passport(3006L,"SDF345666KO", student);
        entityManager.persist(passport);

        Student student1 = new Student(2006L,"Ram",passport, course);
        student1.setPassport(passport);
        entityManager.persist(student1);
    }


//    public void insertHardCodeStudentAndCourse()
//    {
//        Passport passport = null;
//        Student student = new Student(2007L, "Sourav", passport, course);
//        List<Review> reviews = new ArrayList<>();
//        List<Student> students = new ArrayList<>();
//        Date localDateTime = new Date();
//        Course course = new Course(6L, "React",localDateTime,localDateTime,reviews, students);
//    }
}
