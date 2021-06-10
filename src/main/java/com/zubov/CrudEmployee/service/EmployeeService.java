package com.zubov.CrudEmployee.service;

import com.zubov.CrudEmployee.model.Employee;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService {

    /**
     * Adding employee
     * @param employee Employee
     */
    void create(Employee employee);

    /**
     * Returns a list of all available employees
     * @return List of employees
     */
    List<Employee> getAll();

    /**
     * Return employee by id
     * @param id ID
     * @return Employee with the selected ID
     */
    Employee getById(long id);

    /**
     * Return employee by service number
     * @param serviceNumber Service number
     * @return Employee with the selected service number
     */
    Employee getByServiceNumber(String serviceNumber);

    /**
     * Returns a list of employees by salary
     * @param x Lower salary
     * @param y Upper salary
     * @return List of employees
     */
    List<Employee> getBySalary(BigDecimal x, BigDecimal y);

    /**
     * Updating employee data
     * @param employee Employee with updated data
     * @param id ID of the employee to update
     * @return true if the data was updated, else false
     */
    boolean update(Employee employee, Long id);

    /**
     * Delete employee
     * @param id ID of the employee to delete
     * @return true if employee was deleted, else false
     */
    boolean delete(long id);

}
