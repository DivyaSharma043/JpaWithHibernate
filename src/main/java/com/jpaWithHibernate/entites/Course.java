package com.jpaWithHibernate.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@NamedQueries(value = {
        @NamedQuery(name = "query_get_all_courses",
                query = "Select  c  From Course c"),
        @NamedQuery(name = "query_get_all_courses_join_fetch",
                query = "Select  c  From Course c JOIN FETCH c.students s") })

@Entity
public class Course {

    @Id
//    @GeneratedValue
    private Long id;
    private String name;

    @UpdateTimestamp
    private LocalDateTime updatedLastDate;

    @CreationTimestamp
    private LocalDateTime createdDate;


    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    public void addReviews(Review reviews) {
        this.reviews.add(reviews);
    }

    public void removeReviews(Review reviews) {
        this.reviews.remove(reviews);
    }

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    public void addStudents(Student students) {
        this.students.add(students);
    }

    public void removeStudents(Student students) {
        this.students.remove(students);
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}
