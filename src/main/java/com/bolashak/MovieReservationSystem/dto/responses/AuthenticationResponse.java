package com.bolashak.MovieReservationSystem.dto.responses;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String accessToken;
    private String refreshToken;
}
