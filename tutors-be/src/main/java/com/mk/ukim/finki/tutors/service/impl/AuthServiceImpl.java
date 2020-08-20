package com.mk.ukim.finki.tutors.service.impl;

import com.mk.ukim.finki.tutors.jwt.JwtTokenUtil;
import com.mk.ukim.finki.tutors.model.Cart;
import com.mk.ukim.finki.tutors.model.Role;
import com.mk.ukim.finki.tutors.model.UserDetailed;
import com.mk.ukim.finki.tutors.model.requests.SignupRequest;
import com.mk.ukim.finki.tutors.model.User;
import com.mk.ukim.finki.tutors.model.response.LoginResponse;
import com.mk.ukim.finki.tutors.model.response.StringResponse;
import com.mk.ukim.finki.tutors.repository.*;
import com.mk.ukim.finki.tutors.service.AuthService;
import com.mk.ukim.finki.tutors.service.UserService;
import com.mk.ukim.finki.tutors.validators.UserValidator;
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
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Service
public class AuthServiceImpl implements AuthService {
    Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserService userService;
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    UserDetailedRepository userDetailedRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    CartRepository cartRepository;

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
    public StringResponse signupUser(SignupRequest signUpRequest) throws Exception {
        signUpRequest.setUsername(signUpRequest.getUsername().toLowerCase());

        try{
            UserValidator.validateSignUpRequest(signUpRequest, userRepository);
        }catch (Exception e){
            logger.error(e.getLocalizedMessage());
            return new StringResponse(e.getMessage());
        }

        Role role = roleRepository.findByName(signUpRequest.getRole());
        User user = new User(signUpRequest.getUsername(), this.passwordEncoder.encode(signUpRequest.getPassword()), role);

        UserDetailed userDetailed = new UserDetailed();
        userDetailed.setFirstName(signUpRequest.getName().split(" ")[0]);
        if(signUpRequest.getName().split(" ").length > 1)
            userDetailed.setLastName(signUpRequest.getName().split(" ")[1]);
        userDetailed.setUser(user);

        Cart cart = new Cart();
        cart.setCreateDate(LocalDateTime.now());
        cart.setUserDetailed(userDetailed);
        userDetailed.setCart(cart);

        this.userDetailedRepository.save(userDetailed);
        this.userService.registerUser(user);
        this.cartRepository.save(cart);

        return new StringResponse("Successful signup");
    }

    @Override
    public LoginResponse loginUser(SignupRequest request) throws Exception {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = userService
                .loadUserByUsername(request.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);

        return new LoginResponse(token);
    }


    @PostConstruct
    public void init() {
        // todo fix this
//        if (!this.userRepository.existsByUsername("admin")) {
//            User admin = new User("admin", this.passwordEncoder.encode("admin"));
//            admin.setRoles();
//            this.userRepository.save(admin);
        }

}
