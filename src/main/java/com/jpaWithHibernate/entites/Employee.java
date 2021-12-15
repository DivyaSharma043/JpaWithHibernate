package com.jpaWithHibernate.entites;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

//MAPPED SUPER CLASS(No use of entity)

//@Entity

@MappedSuperclass
//SINGLE TABLE
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "EMPLOYEE_TYPE")

//TABLE PER CLASS
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

//JOINED TABLE
//@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {

    @Id
    @GeneratedValue
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
