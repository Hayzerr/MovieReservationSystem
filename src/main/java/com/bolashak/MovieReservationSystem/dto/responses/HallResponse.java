package com.bolashak.MovieReservationSystem.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HallResponse {
    private Long id;
    private String name;
    private String roomNumber;
}
