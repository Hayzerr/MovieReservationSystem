package com.bolashak.MovieReservationSystem.services;

import com.bolashak.MovieReservationSystem.dto.requests.MovieRequest;
import com.bolashak.MovieReservationSystem.dto.responses.MovieResponse;

import java.util.List;

public interface MovieService {
    MovieResponse createMovie(MovieRequest movieRequest);
    List<MovieResponse> getAllMovies();
    MovieResponse getMovieById(Long id);
    MovieResponse updateMovie(Long id, MovieRequest movieRequest);
    void deleteMovie(Long id);
    MovieResponse makeMovieInactive(Long id);
    MovieResponse makeMovieActive(Long id);
}
