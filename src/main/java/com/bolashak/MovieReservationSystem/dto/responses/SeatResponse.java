package com.bolashak.MovieReservationSystem.dto.responses;

import com.bolashak.MovieReservationSystem.entities.Hall;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SeatResponse {
    private Long id;
    private Integer row;
    private Integer number;
    private HallResponse hall;
}
