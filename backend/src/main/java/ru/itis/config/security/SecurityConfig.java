package ru.itis.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                 .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login", "/").permitAll()
                .antMatchers("/profile")
                .hasRole("USER")
                .antMatchers("/**")
                .permitAll()
                .and()
                    .formLogin()

//                        .loginPage("/login")
//                        .usernameParameter("username")
//                        .passwordParameter("password")
//                        .loginProcessingUrl("/auth")
                        .defaultSuccessUrl("/profile", true)
//                        .failureUrl("/")
//                        .permitAll()
                .and()
                    .logout()
                        .logoutSuccessUrl("/login")
                ;
    }

}
