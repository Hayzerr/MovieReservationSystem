package com.bolashak.MovieReservationSystem.dto.requests;

import com.bolashak.MovieReservationSystem.entities.Hall;
import com.bolashak.MovieReservationSystem.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowtimeRequest {
    private Long price;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long movieId;
    private Long hallId;
}
