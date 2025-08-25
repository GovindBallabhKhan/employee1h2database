package com.javatechnology.springboot.employees.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EmployeeRequest {


    @NotBlank(message = "First name is mandatory")
    @Size(min = 2,max = 50,message = "First Name mst be between 2 and 50 character")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Size(min = 2,max = 50,message = "Last Name mst be between 2 and 50 character")
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Please provide a valid email")
    private  String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployeeRequest(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


}
