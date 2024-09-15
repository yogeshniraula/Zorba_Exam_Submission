package org.springMVC.entity;



import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "user_info")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;


    @Column(name = "user_name")
    private String userName;


    @Column(name = "user_email")
    private String userEmail;


    @Column(name = "user_mobile")
    private long userMobile;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_role")
    private String userRole;
}