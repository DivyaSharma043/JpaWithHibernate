package com.jpaWithHibernate.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@NamedQuery(name = "find_all_persons", query = "select p from Person p")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private String name;
    private String location;
    private Date birthDate;
}
