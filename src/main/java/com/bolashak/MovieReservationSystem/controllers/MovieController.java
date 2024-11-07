package com.bolashak.MovieReservationSystem.controllers;

import com.bolashak.MovieReservationSystem.dto.requests.MovieRequest;
import com.bolashak.MovieReservationSystem.dto.responses.MovieResponse;
import com.bolashak.MovieReservationSystem.entities.Movie;
import com.bolashak.MovieReservationSystem.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController{
    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieResponse>> getAllMovies(){
        List<MovieResponse> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }


    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable Long id){
        MovieResponse movieResponse = movieService.getMovieById(id);
        return ResponseEntity.ok(movieResponse);
    }


    @PostMapping
    public ResponseEntity<MovieResponse> createMovie(@RequestBody MovieRequest movieRequest){
        MovieResponse movieResponse = movieService.createMovie(movieRequest);
        return ResponseEntity.ok(movieResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> updateMovie(@PathVariable Long id, @RequestBody MovieRequest movieRequest){
        MovieResponse movieResponse = movieService.updateMovie(id, movieRequest);
        return ResponseEntity.ok(movieResponse);
    }

    @PutMapping("/in-active/{id}")
    public ResponseEntity<MovieResponse> makeMovieInactive(@PathVariable Long id){
        MovieResponse movieResponse = movieService.makeMovieInactive    (id);
        return ResponseEntity.ok(movieResponse);
    }

    @PutMapping("/active/{id}")
    public ResponseEntity<MovieResponse> makeMovieActive(@PathVariable Long id){
        MovieResponse movieResponse = movieService.makeMovieActive(id);
        return ResponseEntity.ok(movieResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Movie deleted successfully");
    }
}
