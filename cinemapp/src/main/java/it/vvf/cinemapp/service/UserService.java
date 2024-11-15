package it.vvf.cinemapp.service;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.vvf.cinemapp.dto.UserRegistrationRequest;
import it.vvf.cinemapp.dto.UserResponse;
import it.vvf.cinemapp.exceptions.ResourceNotFoundException;
import it.vvf.cinemapp.model.User;
import it.vvf.cinemapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
   
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    public UserResponse registerUser(UserRegistrationRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ResourceNotFoundException("Email già registrata: " + request.getEmail());
        }
        
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .fullName(request.getFullName())
                .registrationDate(LocalDateTime.now())
                .build();
        
        User savedUser = userRepository.save(user);
        log.info("Nuovo utente registrato con ID: {}", savedUser.getId());
        
        return UserResponse.builder()
                .id(savedUser.getId())
                .email(savedUser.getEmail())
                .fullName(savedUser.getFullName())
                .registrationDate(savedUser.getRegistrationDate())
                .build();
    }
}

