package it.vvf.cinemapp.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@CrossOrigin(value = "*")
@Slf4j
public class CinemappController {

    @GetMapping("/welcome")
    public ResponseEntity<Map<String, String>> getWelcomeMessage() {
        log.info("Receiving welcome request");
        
        Map<String, String> response = new HashMap<>();
        response.put("message", "Benvenuto in Cinemapp!");
        response.put("status", "success");
        response.put("timestamp", LocalDateTime.now().toString());
        
        log.info("Sending welcome response: {}", response);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/status")
    public ResponseEntity<String> getApiStatus() {
        log.info("Checking API status");
        return ResponseEntity.ok("Cinemapp API is running!");
    }
}