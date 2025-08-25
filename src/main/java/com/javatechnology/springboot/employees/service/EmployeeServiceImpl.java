package com.javatechnology.springboot.employees.service;

import com.javatechnology.springboot.employees.dao.EmployeeDao;
import com.javatechnology.springboot.employees.entity.Employee;
import com.javatechnology.springboot.employees.request.EmployeeRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl  implements  EmployeeService{

    private EmployeeDao employeeDao;


    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(long theId) {
     Employee theEmployee=employeeDao.findById(theId);
     return  theEmployee;
    }

    @Transactional
    @Override
    public Employee save(EmployeeRequest theEmployeeRequest) {
      Employee theEmployee= convertToEmployee(0,theEmployeeRequest);
      return employeeDao.save(theEmployee);

    }

    @Override
    public Employee convertToEmployee(long id, EmployeeRequest employeeRequest) {


        return new Employee (id,employeeRequest.getFirstName(),employeeRequest.getLastName(),employeeRequest.getEmail());
    }
    @Transactional
    @Override
    public Employee update(long id, EmployeeRequest theEmployeeRequest) {
        Employee theEmployee = convertToEmployee(id, theEmployeeRequest);
        return employeeDao.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(long theId) {
  employeeDao.deleteById(theId);
    }


}
