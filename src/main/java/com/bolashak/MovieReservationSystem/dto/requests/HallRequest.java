package com.bolashak.MovieReservationSystem.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HallRequest {
    private String name;
    private String roomNumber;
}
