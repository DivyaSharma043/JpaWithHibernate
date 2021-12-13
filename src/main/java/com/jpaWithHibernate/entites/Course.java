package com.jpaWithHibernate.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @UpdateTimestamp
    private LocalDateTime updatedLastDate;

    @CreationTimestamp
    private LocalDateTime createdDate;


    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    public Course(long id, String react, Date localDateTime, Date localDateTime1, List<Review> reviews, List<Student> students) {
    }

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



}
