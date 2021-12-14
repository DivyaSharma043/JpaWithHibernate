package com.jpaWithHibernate.entites;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Employee {

    @Id
    @GeneratedValue
//    @GeneratedValue(
//            strategy= GenerationType.AUTO,
//            generator="native"
//    )
//    @GenericGenerator(
//            name = "native",
//            strategy = "native"
//    )
    private Long id;

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
