package org.springMVC.model;

import lombok.Data;
import lombok.Getter;

@Data
public class UserModel {
    private Integer userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private Long userMobile;
}