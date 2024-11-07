package com.bolashak.MovieReservationSystem.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    UserDetails loadUserByUsername(String username);
}