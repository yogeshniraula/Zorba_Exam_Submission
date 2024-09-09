package org.springmvc.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid email format")
    private String userEmail;
    @Column(name = "user_mobile")
    private long userMobile;
    @Column(name = "user_username")
    private String userUsername;

    @Column(name = "user_password")
    @NotEmpty(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String userPassword;
}