package com.mk.ukim.finki.tutors.config;

import com.mk.ukim.finki.tutors.jwt.JwtAuthenticationEntryPoint;
import com.mk.ukim.finki.tutors.jwt.JwtRequestFilter;
import com.mk.ukim.finki.tutors.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private UserServiceImpl jwtUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .httpBasic()
                .and().cors().and()
                .authorizeRequests()
                .antMatchers("/", "/api/login", "/api/login/signup", "/api/login/login")
                .permitAll()
                .antMatchers("/api/users/change-password").permitAll()
                .antMatchers("/api/users/update-details").permitAll()
                .antMatchers("/api/users/update-subjects").permitAll()
                .antMatchers("/api/subjects/all").permitAll()
                .antMatchers("/api/cart").permitAll()
                .anyRequest().authenticated()
//                        .and()
//                    .formLogin()
//                        .loginPage("/login").permitAll()
//                        .and()
//                    .logout()
//                        .permitAll()
                .and()
                .csrf().disable()

                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//         Add a filter to validate the tokens with every request
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers(HttpMethod.GET, "/products/**")
//                .and().ignoring().antMatchers(HttpMethod.GET, "/review")
//                .and().ignoring().antMatchers("/contact/send")
//                .and().ignoring().antMatchers("/products");
//    }
}
