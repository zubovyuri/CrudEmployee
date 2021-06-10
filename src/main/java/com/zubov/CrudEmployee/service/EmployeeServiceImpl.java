package com.zubov.CrudEmployee.service;

import com.zubov.CrudEmployee.model.Employee;
import com.zubov.CrudEmployee.repository.EmployeeRepository;

import org.springframework.data.domain.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee getByServiceNumber(String serviceNumber) {
        Employee search = new Employee();
        search.setServiceNumber(serviceNumber);
        Example<Employee> example = Example.of(search);
        Optional<Employee> find = employeeRepository.findOne(example);
        return find.orElse(null);
    }

    @Override
    public List<Employee> getBySalary(BigDecimal x, BigDecimal y) {
        return employeeRepository.getBySalary(x, y);
    }

    @Override
    public boolean update(Employee employee, Long id) {
        Optional<Employee> oldOptional = employeeRepository.findById(id);
        if (oldOptional.isPresent()) {
            Employee old = oldOptional.get();
            if (employee.getName() != null) {
                old.setName(employee.getName());
            }
            if (employee.getDateAppointment() != null) {
                old.setDateAppointment(employee.getDateAppointment());
            }
            if (employee.getDateDismissal() != null) {
                old.setDateDismissal(employee.getDateDismissal());
            }
            if (employee.getSalary() != null) {
                old.setSalary(employee.getSalary());
            }
            if (employee.getServiceNumber() != null) {
                old.setServiceNumber(employee.getServiceNumber());
            }
            if (employee.getDateAppointment() != null) {
                old.setDateAppointment(employee.getDateAppointment());
            }
            employeeRepository.save(old);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
