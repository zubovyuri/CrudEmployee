package com.zubov.CrudEmployee.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "employee_generator")
    @SequenceGenerator(name = "employee_generator", sequenceName = "employees_id_seq")
    private Long id;

    @Column(name = "name", nullable = false, length = 300)
    private String name;

    @Column(name = "service_number", nullable = false)
    private String serviceNumber;

    @Column(name = "date_appointment", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateAppointment;

    @Column(name = "date_dismissal")
    @Temporal(TemporalType.DATE)
    private Date dateDismissal;

    @Column(name = "salary", nullable = false, precision = 19, scale = 2)
    private BigDecimal salary;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public Date getDateAppointment() {
        return dateAppointment;
    }

    public void setDateAppointment(Date dateAppointment) {
        this.dateAppointment = dateAppointment;
    }

    public Date getDateDismissal() {
        return dateDismissal;
    }

    public void setDateDismissal(Date dateDismissal) {
        this.dateDismissal = dateDismissal;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
