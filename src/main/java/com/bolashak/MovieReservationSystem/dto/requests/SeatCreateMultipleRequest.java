package com.bolashak.MovieReservationSystem.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SeatCreateMultipleRequest {
    private Integer row;
    private Integer amount;
    private Long hallId;
}
