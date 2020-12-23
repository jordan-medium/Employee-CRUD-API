package com.employee.crudapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> findAll(){

        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        employeeRepository.save(theEmployee);

        return theEmployee;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable(name ="employeeId" ) int employeeId	) {

        Employee theEmployee = employeeRepository.findById(employeeId).get();
        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable(name ="employeeId" ) int employeeId) {

        employeeRepository.deleteById(employeeId);
        return "Delete employee id - "+ employeeId;
    }


}
