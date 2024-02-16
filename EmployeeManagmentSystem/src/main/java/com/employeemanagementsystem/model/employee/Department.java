package com.employeemanagementsystem.model.employee;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="department")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="dept_id")
    private String deptId;

    @Column(name="dept_name")
    private String deptName;
}
