package com.bolashak.MovieReservationSystem.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieRequest {
    private String title;

    private String description;

    private String duration;

    private String posterUrl;

    private String trailerUrl;

    private String ageRating;

    private String rating;

    private String genre;
}
