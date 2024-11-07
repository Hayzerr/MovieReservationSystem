package com.bolashak.MovieReservationSystem.dto.responses;

import com.bolashak.MovieReservationSystem.entities.Hall;
import com.bolashak.MovieReservationSystem.entities.Movie;
import com.bolashak.MovieReservationSystem.entities.Reservation;
import com.bolashak.MovieReservationSystem.entities.Revenue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShowtimeResponse {

    private Long price;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private MovieResponse movie;
    private HallResponse hall;
    //private List<Reservation> reservations;
    //private Revenue revenue;
}
