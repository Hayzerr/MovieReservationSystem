package com.bolashak.MovieReservationSystem.services;

import com.bolashak.MovieReservationSystem.dto.responses.AuthenticationResponse;
import com.bolashak.MovieReservationSystem.dto.requests.RegisterRequest;
import com.bolashak.MovieReservationSystem.dto.responses.UserResponse;

public interface AuthenticationService {
    void logout(String refreshToken);
    AuthenticationResponse refreshAccessToken(String refreshToken);
    AuthenticationResponse login(String username, String password);
    UserResponse register(RegisterRequest registerRequest);
    UserResponse promoteUser(Long userId);
}
