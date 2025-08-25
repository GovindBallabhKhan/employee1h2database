package com.javatechnology.springboot.employees.controller;


import com.javatechnology.springboot.employees.dao.EmployeeDao;
import com.javatechnology.springboot.employees.entity.Employee;
import com.javatechnology.springboot.employees.request.EmployeeRequest;
import com.javatechnology.springboot.employees.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee Rest Api Endpoints", description = "Operations related to employees")
public class EmployeeRestController {


    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all employee", description = "Retrieve a list of all employee")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Fetch single employee", description = "Get a single  employee from database")
    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable @Min(value = 1) long employeeId) {
        Employee theEmpLoyee = employeeService.findById(employeeId);
        return theEmpLoyee;
    }

    @Operation(summary = "Create new Employee", description = "Add a new Employee in Database")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Employee addEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
        Employee dbEmployee = employeeService.save(employeeRequest);
        return dbEmployee;
    }

    @Operation(summary = "Update  an Employee", description = "Update the details of current employee")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@Valid @Min(value = 1) long employeeId,@RequestBody EmployeeRequest employeeRequest)

    {
       Employee employeeDb= employeeService.update(employeeId,employeeRequest);
       return  employeeDb;

    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete  an Employee", description = "Delete the employee by Id")
    @DeleteMapping("/{employeeId}")
    public void  deleteEmployee(@Valid @Min(value = 1) long employeeId)
    {
        employeeService.deleteById(employeeId);
    }

}



