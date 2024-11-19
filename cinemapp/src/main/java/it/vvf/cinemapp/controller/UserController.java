package it.vvf.cinemapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.vvf.cinemapp.dto.UserRegistrationRequest;
import it.vvf.cinemapp.dto.UserResponse;
import it.vvf.cinemapp.exceptions.BadRequestException;
import it.vvf.cinemapp.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {
    
    private final UserService userService;
    
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @Operation(summary = "Registrazione nuovo utente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Utente registrato con successo"),
        @ApiResponse(responseCode = "400", description = "Dati non validi o email già registrata")
    })
    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody UserRegistrationRequest request) throws BadRequestException {
        log.info("Ricevuta richiesta di registrazione: {}", request);
        
        
        if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
            throw new BadRequestException("L'email è obbligatoria");
        }
        if (request.getPassword() == null || request.getPassword().length() < 6) {
            throw new BadRequestException("La password deve essere di almeno 6 caratteri");
        }
        if (request.getFullName() == null || request.getFullName().trim().isEmpty()) {
            throw new BadRequestException("Il nome completo è obbligatorio");
        }
        
        UserResponse response = userService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
