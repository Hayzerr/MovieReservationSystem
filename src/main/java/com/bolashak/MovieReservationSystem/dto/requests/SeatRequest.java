package com.bolashak.MovieReservationSystem.dto.requests;

import com.bolashak.MovieReservationSystem.entities.Hall;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SeatRequest {
    private Integer row;
    private Integer number;
    private Long hallId;
}