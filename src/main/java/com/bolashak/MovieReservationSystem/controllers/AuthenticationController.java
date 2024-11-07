package com.bolashak.MovieReservationSystem.controllers;

import com.bolashak.MovieReservationSystem.dto.responses.AuthenticationResponse;
import com.bolashak.MovieReservationSystem.dto.requests.RegisterRequest;
import com.bolashak.MovieReservationSystem.dto.responses.UserResponse;
import com.bolashak.MovieReservationSystem.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        UserResponse registeredUser = authenticationService.register(registerRequest);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        try {
            AuthenticationResponse response = authenticationService.login(username, password);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestParam String refreshToken) {
        try {
            AuthenticationResponse response = authenticationService.refreshAccessToken(refreshToken);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestParam String refreshToken) {
        authenticationService.logout(refreshToken);
        return ResponseEntity.ok("Logout successful");
    }

    @PutMapping("/promote/{userId}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<?> promoteUser(@PathVariable Long userId) {
        log.info("Promoting user with id: {}", userId);
        UserResponse user = authenticationService.promoteUser(userId);
        return ResponseEntity.ok(user);
    }
}
