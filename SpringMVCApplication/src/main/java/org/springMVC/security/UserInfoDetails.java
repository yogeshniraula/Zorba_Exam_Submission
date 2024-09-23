//package org.springMVC.security;
//
//import org.springMVC.model.UserModel;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springMVC.entity.Role;
//import org.springMVC.model.UserModel;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.Set;
//
//public class UserInfoDetails implements UserDetails {
//    private String username;
//    private String password;
//    private Set<Role> roleSet;
//
//    public UserInfoDetails(UserDetails user) {
//        this.username = user.getUsername();
//        this.password = user.getPassword();
//        this.roleSet = user.getRoles();
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List <SimpleGrantedAuthority> grantedAuthorityList = new ArrayList<>();
//        for(Role role : roleSet) {
//            grantedAuthorityList.add(new SimpleGrantedAuthority(role.getRoleName()));
//        }
//        return grantedAuthorityList;
//    }
//
//    @Override
//    public String getPassword() {
//        return this.password;
//    }}

