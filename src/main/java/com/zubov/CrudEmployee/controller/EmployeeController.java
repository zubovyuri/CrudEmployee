package com.zubov.CrudEmployee.controller;

import com.zubov.CrudEmployee.model.Employee;
import com.zubov.CrudEmployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class EmployeeController {


    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/employees")
    public ResponseEntity<?> create(@RequestBody Employee employee) {
        employeeService.create(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/employees")
    public ResponseEntity<List<Employee>> get() {
        final List<Employee> employees = employeeService.getAll();
        return employees != null &&  !employees.isEmpty()
                ? new ResponseEntity<>(employees, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/employees/id/{id}")
    public ResponseEntity<Employee> get(@PathVariable(name = "id") long id) {
        final Employee employee = employeeService.getById(id);
        return employee != null
                ? new ResponseEntity<>(employee, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/employees/serviceNumber/{serviceNumber}")
    public ResponseEntity<Employee> get(@PathVariable(name = "serviceNumber") String serviceNumber) {
        final Employee employee = employeeService.getByServiceNumber(serviceNumber);
        return employee != null
                ? new ResponseEntity<>(employee, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/employees/salary/{x}&{y}")
    public ResponseEntity<List<Employee>> get(@PathVariable(name = "x") BigDecimal x, @PathVariable(name = "y") BigDecimal y) {
        final List<Employee> employees = employeeService.getBySalary(x, y);
        return employees != null &&  !employees.isEmpty()
                ? new ResponseEntity<>(employees, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/employees/id/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody Employee client) {
        final boolean updated = employeeService.update(client, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/employees/id/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        final boolean deleted = employeeService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
