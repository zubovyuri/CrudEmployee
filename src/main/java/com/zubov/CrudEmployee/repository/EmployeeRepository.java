package com.zubov.CrudEmployee.repository;

import com.zubov.CrudEmployee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * Getting a list of employees by salary through query
     * @param x Lower salary
     * @param y Upper salary
     * @return List of employees
     */
    @Query(value = "from Employee e where e.salary BETWEEN :x AND :y")
    List<Employee> getBySalary(@Param("x") BigDecimal x,
                               @Param("y") BigDecimal y);
}
