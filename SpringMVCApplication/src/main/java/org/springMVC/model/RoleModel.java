package org.springMVC.model;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class RoleModel {

    private Integer roleId;
    private String roleName;
}
