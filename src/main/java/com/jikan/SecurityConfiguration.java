package com.jikan;

import com.jikan.services.UserDetailsLoader;
import com.jikan.services.UserWithRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by V-Rod on 2/23/17.
 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = UserWithRoles.class)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsLoader userDetails;

    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/projects") // user's home page, it can be any URL
                .permitAll() // Anyone can go to the login page
                .and()
                // non logged-in users
                .authorizeRequests()
                .antMatchers("/", "/logout") // anyone can see the home and logout page
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout") // append a query string value
                .and()
                // restricted area
                .authorizeRequests()
                // only authenticated users can create projects and this is where you add the pages that you want protected
                .antMatchers("/projects/create", "/projects", "/projects/{projectid}/tasks/new", "/projects/{projectid}/print")
                .authenticated()
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder());
    }



}
