package com.javatechnology.springboot.employees.dao;

import com.javatechnology.springboot.employees.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {


    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //execute a query and get result list
        List<Employee> employees = theQuery.getResultList();
        // return result

        return employees;
    }

    @Override
    public Employee findById(long theId) {
       Employee theEmployee= entityManager.find(Employee.class,theId);
       return  theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
      Employee dbEmployee =entityManager.merge(theEmployee);
      return dbEmployee;
    }

    @Override
    public void deleteById(long theId) {
        Employee theEmployee= entityManager.find(Employee.class,theId);
        entityManager.remove(theEmployee);
    }
}
