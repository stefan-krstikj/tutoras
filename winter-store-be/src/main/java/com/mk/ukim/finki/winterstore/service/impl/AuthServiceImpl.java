package com.mk.ukim.finki.winterstore.service.impl;

import com.mk.ukim.finki.winterstore.jwt.JwtTokenUtil;
import com.mk.ukim.finki.winterstore.model.requests.SignupRequest;
import com.mk.ukim.finki.winterstore.model.User;
import com.mk.ukim.finki.winterstore.repository.RoleRepository;
import com.mk.ukim.finki.winterstore.repository.UserRepository;
import com.mk.ukim.finki.winterstore.service.AuthService;
import com.mk.ukim.finki.winterstore.service.UserService;
import com.mk.ukim.finki.winterstore.validators.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


import javax.annotation.PostConstruct;

@Service
public class AuthServiceImpl implements AuthService {
    Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserService userService;
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;


    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           RoleRepository roleRepository,
                           UserService userService,
                           JwtTokenUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Override
    public String getCurrentUserId() {
        return this.getCurrentUser().getUsername();
    }

    @Override
    public User signupUser(SignupRequest signUpRequest) throws Exception {
        signUpRequest.setUsername(signUpRequest.getUsername().toLowerCase());

        try{
            UserValidator.validateSignUpRequest(signUpRequest, userRepository);
        }catch (Exception e){
            logger.error(e.getLocalizedMessage());
        }

        User user = new User(signUpRequest.getUsername(), this.passwordEncoder.encode(signUpRequest.getPassword()));
//        Role userRole = this.roleRepository.findByName("ROLE_USER");
//        user.setRoles(Collections.singleton(userRole));
        return this.userService.registerUser(user);
    }

    @Override
    public String loginUser(SignupRequest request) throws Exception {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = userService
                .loadUserByUsername(request.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
        return token;
    }


    @PostConstruct
    public void init() {
        // todo fix this
        if (!this.userRepository.existsByUsername("admin")) {
            User admin = new User("admin", this.passwordEncoder.encode("admin"));
//            admin.setRoles();
            this.userRepository.save(admin);
        }
    }
}
