package org.springMVC.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "execution_audit_check")
public class ExecutionAuditCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_controller")
    private String nameOfController;

    @Column(name = "name_of_method")
    private String nameOfMethod;

    @Column(name = "execution_time")
    private Long executionTime;


}

