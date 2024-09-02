package org.springmvc.model;

import lombok.Data;

@Data
public class UserModel {
    private Integer userId;
    private String userName;
    private String userEmail;
    private String userUsername;
    private String userPassword;
    private Long userMobile;
}