package com.bolashak.MovieReservationSystem.dto.responses;

import com.bolashak.MovieReservationSystem.entities.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private String email;
    private String username;
    private Role role;
}