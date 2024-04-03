package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Employee;
import com.backend.tinkoff_backend.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employees")
    public ResponseEntity<Long> createEmployee(@RequestBody Employee employee) {
        Optional<Long> employeeData = employeeService.createEmployee(employee);
        if (employeeData.isPresent()) {
            return new ResponseEntity<>(employeeData.get(), HttpStatus.CREATED);
        }
        throw new DataIntegrityViolationException("This user can't be an employee");
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
        Optional<Employee> employeeData = employeeService.getEmployeeById(employeeId);
        if(employeeData.isPresent()) {
            return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
        }
        throw new DataRetrievalFailureException("No employee has such id");
    }

    @GetMapping("/employees/{userId}")
    public ResponseEntity<Employee> getEmployeeByUserId(@PathVariable("userId") long userId) {
        Optional<Employee> employeeData = employeeService.getEmployeeByUserId(userId);
        if(employeeData.isPresent()) {
            return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
        }
        throw new DataRetrievalFailureException("This user is not employee");
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId, @RequestBody Employee employee) {
        Optional<Employee> employeeData = employeeService.updateEmployee(employeeId, employee);

        if (employeeData.isPresent()) {
            return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
        }
        throw new DataRetrievalFailureException("No employee has such id");
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") long employeeId) {
        Optional<Employee> employeeData = employeeService.deleteEmployee(employeeId);
        if (employeeData.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        throw new DataRetrievalFailureException("No employee has such id");
    }

    @DeleteMapping("/employees")
    public ResponseEntity<Employee> deleteAllEmployees() {
        employeeService.deleteAllEmployees();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
