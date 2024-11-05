package com.bolashak.MovieReservationSystem.services;

import com.bolashak.MovieReservationSystem.dto.AuthenticationResponse;
import com.bolashak.MovieReservationSystem.dto.RegisterRequest;
import com.bolashak.MovieReservationSystem.dto.UserResponse;
import com.bolashak.MovieReservationSystem.entities.User;

public interface AuthenticationService {
    void logout(String refreshToken);
    AuthenticationResponse refreshAccessToken(String refreshToken);
    AuthenticationResponse login(String username, String password);
    UserResponse register(RegisterRequest registerRequest);
    UserResponse promoteUser(Long userId);
}
