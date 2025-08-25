package com.javatechnology.springboot.employees.service;

import com.javatechnology.springboot.employees.entity.Employee;
import com.javatechnology.springboot.employees.request.EmployeeRequest;

import java.util.List;

public interface EmployeeService {


    List<Employee> findAll();

    public Employee findById(long theId);

    public  Employee save(EmployeeRequest theEmployeeRequest);

    public Employee convertToEmployee(long id,EmployeeRequest employeeRequest);

    public Employee update(long id,EmployeeRequest employeeRequest);

    void deleteById(long theId);
}
