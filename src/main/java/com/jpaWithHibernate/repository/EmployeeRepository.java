package com.jpaWithHibernate.repository;

import com.jpaWithHibernate.entites.Employee;
import com.jpaWithHibernate.entites.FullTimeEmployee;
import com.jpaWithHibernate.entites.PartTimeEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    @Autowired
    EntityManager entityManager;

//    Insert
    public void insert(Employee employee)
    {
        entityManager.persist(employee);
    }

//    Retrieve all employees
//    public List<Employee> retrieveAllEmployees()
//    {
//        return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
//    }

//    Retrieve Full Time Employees

    public List<FullTimeEmployee> retrieveFullTimeEmployees() {
        return entityManager.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
    }

//    Retrieve Part Time Employees

    public List<PartTimeEmployee> retrievePartTimeEmployees()
    {
        return entityManager.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
    }


}
