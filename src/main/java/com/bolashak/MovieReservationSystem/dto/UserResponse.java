package com.bolashak.MovieReservationSystem.dto;

import com.bolashak.MovieReservationSystem.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private String email;
    private String username;
    private Role role;
}