//package org.springMVC.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springMVC.service.UserInfoDetailService;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    //Read the username / password and validate with database
//    @Bean
//    public UserDetailsService userDetails() {
//        return new UserInfoDetailService();
//    }
//
//    @Bean
//    public AuthenticationProvider userAuthentication(){
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setUserDetailsService(this.userDetails());
//        daoAuthenticationProvider.setPasswordEncoder(this.encoder());
//        return daoAuthenticationProvider;
//    }
//
//
//
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    //Authorization part
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/admin/loadLoginPage","/customer/loadLoginPage","/vendor/loadLoginPage").permitAll()
//
//                .antMatchers("/admin/**").hasAuthority("admin")
//                .antMatchers("/vendor/**").hasAuthority("vendor")
//                .antMatchers("/customer/**").hasAuthority("customer")
//                .anyRequest().authenticated()
//                .and()
//
//                .formLogin()
//                .loginPage("/admin/loadLoginPage")
//                .loginProcessingUrl("/admin/login")
//                .defaultSuccessUrl("/admin/dashboard", true)
//                .permitAll()
//                .and()
//
//                .formLogin()
//                .loginPage("/vendor/loadLoginPage")
//                .loginProcessingUrl("/vendor/login")
//                .defaultSuccessUrl("/vendor/dashboard", true)
//                .permitAll()
//                .and()
//
//                .formLogin()
//                .loginPage("/customer/loadLoginPage")
//                .loginProcessingUrl("/customer/login")
//                .defaultSuccessUrl("/customer/dashboard", true)
//                .permitAll()
//                .and()
//
//                //Logout Setup
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login?logout")
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .permitAll()
//                .and()
//                .csrf().disable();
//    }
//}
