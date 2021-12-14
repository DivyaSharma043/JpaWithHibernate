package com.jpaWithHibernate.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;


@Getter
@Setter
@Entity
public class FullTimeEmployee extends Employee{

    protected FullTimeEmployee() {

    }

    public FullTimeEmployee(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }

    private BigDecimal salary;
}
