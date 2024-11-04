package com.bolashak.MovieReservationSystem.services.impl;

import com.bolashak.MovieReservationSystem.entities.User;
import com.bolashak.MovieReservationSystem.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;

public class UserServiceImpl {
    private UserRepository userRepository;

//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        User user = userRepository.findByEmail(username).get();
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
//    }
}
