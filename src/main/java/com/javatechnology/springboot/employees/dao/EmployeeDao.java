package com.javatechnology.springboot.employees.dao;

import com.javatechnology.springboot.employees.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> findAll();

    public Employee findById(long theId);

    public  Employee save(Employee theEmployee);

    void deleteById(long theId);
}
