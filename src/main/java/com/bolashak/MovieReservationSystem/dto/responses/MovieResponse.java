package com.bolashak.MovieReservationSystem.dto.responses;

import com.bolashak.MovieReservationSystem.entities.Genre;
import com.bolashak.MovieReservationSystem.entities.Showtime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieResponse {
    private Long id;

    private String title;

    private String description;

    private String duration;

    private String posterUrl;

    private String trailerUrl;

    private String ageRating;

    private String rating;

    private Genre genre;

    private boolean isActive;
}
