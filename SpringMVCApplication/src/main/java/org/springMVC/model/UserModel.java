package org.springMVC.model;

import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserModel {
    private Integer userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private Long userMobile;
    private String userRole;
}