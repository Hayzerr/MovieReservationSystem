package com.bolashak.MovieReservationSystem.dto;

import com.bolashak.MovieReservationSystem.entities.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
    private RoleEnum role;
}
