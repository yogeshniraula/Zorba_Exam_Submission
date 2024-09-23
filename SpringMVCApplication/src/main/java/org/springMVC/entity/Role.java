package org.springMVC.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "role_info")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "role_name")
    private String roleName;
}
