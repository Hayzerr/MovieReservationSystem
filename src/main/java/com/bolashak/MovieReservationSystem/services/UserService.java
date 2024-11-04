package com.bolashak.MovieReservationSystem.services;

import com.bolashak.MovieReservationSystem.dto.AuthenticationResponse;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    UserDetails loadUserByUsername(String username);
}