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
import java.util.List;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager entityManager;
    private List<Course> courses = new ArrayList<>();

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

        Student student1 = new Student(2006L,"Ram",passport, courses);
        student1.setPassport(passport);
        entityManager.persist(student1);
    }


    public void insertHardCodeStudentAndCourse()
    {
        Passport passport = null;
        Student student = new Student(2007L, "Sourav", passport , courses);
        List<Review> reviews = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        java.time.LocalDateTime now = java.time.LocalDateTime.now();
        Course courses = new Course(7L, "React",now,now,reviews, students);
        entityManager.persist(student);
        entityManager.persist(courses);

//        Relationship
        student.addCourses(courses);
        courses.addStudents(student);
        entityManager.persist(student);
    }

    public void insertStudentAndCourse(Student students, Course course)
    {
        students.addCourses(course);
        course.addStudents(students);
        entityManager.persist(students);
        entityManager.persist(course);
    }

}
