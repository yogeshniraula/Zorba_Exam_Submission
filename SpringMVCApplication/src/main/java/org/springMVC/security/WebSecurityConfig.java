//package org.springMVC.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    public void configure(AuthenticationManagerBuilder managerBuilder) throws Exception{
//        managerBuilder.inMemoryAuthentication()
//                .withUser("admin").password(encoder().encode("admin@123")).roles("ADMIN")
//                .and()
//                .withUser("user").password("user@123").roles("USER")
//                .and()
//                .withUser("adminUser").password("adminUser@123").roles("ADMIN", "USER");
//
//    }
//
//    @Bean
//    public PasswordEncoder encoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    //Authorization part
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests()
//                .antMatchers("/student/test").hasRole("ADMIN")
//
//                .antMatchers("/student/first").hasAnyRole("USER")
//
//                .antMatchers("/student/getAllStudData").hasAnyRole("ADMIN", "USER")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().disable()
//                .csrf().disable()
//                .cors().disable;
//
//    }
//}
