package it.vvf.cinemapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.vvf.cinemapp.dto.ErrorResponse;
import it.vvf.cinemapp.dto.LoginRequest;
import it.vvf.cinemapp.dto.LoginResponse;
import it.vvf.cinemapp.dto.SuccessResponse;
import it.vvf.cinemapp.model.User;
import it.vvf.cinemapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        log.info("Tentativo di login per l'utente: {}", loginRequest.getEmail());
        
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginRequest.getEmail(), 
                    loginRequest.getPassword()
                )
            );
            
            SecurityContextHolder.getContext().setAuthentication(authentication);
            
            User user = userService.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));
            
            LoginResponse response = LoginResponse.builder()
                .email(user.getEmail())
                .fullName(user.getFullName())
                .message("Login effettuato con successo")
                .build();
                
            log.info("Login effettuato con successo per l'utente: {}", loginRequest.getEmail());
            return ResponseEntity.ok(response);
            
        } catch (AuthenticationException e) {
            log.error("Errore di autenticazione per l'utente {}: {}", loginRequest.getEmail(), e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErrorResponse("Credenziali non valide"));
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok().body(new SuccessResponse("Logout effettuato con successo"));
    }
}
