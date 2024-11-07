package com.bolashak.MovieReservationSystem.services.impl;

import com.bolashak.MovieReservationSystem.dto.requests.MovieRequest;
import com.bolashak.MovieReservationSystem.dto.responses.MovieResponse;
import com.bolashak.MovieReservationSystem.entities.Genre;
import com.bolashak.MovieReservationSystem.entities.Movie;
import com.bolashak.MovieReservationSystem.repository.GenreRepository;
import com.bolashak.MovieReservationSystem.repository.MovieRepository;
import com.bolashak.MovieReservationSystem.services.MovieService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final ModelMapper modelMapper;
    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;

    @Transactional
    public MovieResponse createMovie(MovieRequest movieRequest) {
        Movie movie = modelMapper.map(movieRequest, Movie.class);
        Genre genre = genreRepository.findByNameAndNotDeleted(movieRequest.getGenre());
        if(genre == null){
            genre = new Genre();
            genre.setName(movieRequest.getGenre());
            genre = genreRepository.save(genre);
        }

        movie.setGenre(genre);

        Movie createdMovie = movieRepository.save(movie);
        MovieResponse movieResponse = modelMapper.map(createdMovie, MovieResponse.class);
        return movieResponse;
    }

    public List<MovieResponse> getAllMovies() {
        List<Movie> movies = movieRepository.findAllByIsDeletedFalse();
        List<MovieResponse> movieResponses = movies.stream()
                .map(movie -> modelMapper.map(movie, MovieResponse.class))
                .collect(Collectors.toList());
        return movieResponses;
    }

    public MovieResponse getMovieById(Long id) {
        Movie movie = movieRepository.findByIdAndNotDeleted(id)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found"));
        MovieResponse movieResponse = modelMapper.map(movie, MovieResponse.class);
        return movieResponse;
    }

    @Transactional
    public MovieResponse updateMovie(Long id, MovieRequest movieRequest) {
        Movie movie = movieRepository.findByIdAndNotDeleted(id)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found"));

        movie = modelMapper.map(movieRequest, Movie.class);

        Genre genre = genreRepository.findByNameAndNotDeleted(movieRequest.getGenre());
        if(genre == null){
            genre = new Genre();
            genre.setName(movieRequest.getGenre());
            genre = genreRepository.save(genre);
        }

        movie.setGenre(genre);

        Movie updatedMovie = movieRepository.save(movie);
        MovieResponse movieResponse = modelMapper.map(updatedMovie, MovieResponse.class);
        return movieResponse;
    }

    @Transactional
    public void deleteMovie(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found"));
        movie.setDeleted(true);
        movieRepository.save(movie);
    }

    @Transactional
    public MovieResponse makeMovieInactive(Long id) {
        Movie movie = movieRepository.findByIdAndNotDeleted(id)
                .orElseThrow(()  -> new IllegalArgumentException("Movie not found"));
        movie.setActive(false);
        Movie updatedMovie = movieRepository.save(movie);
        MovieResponse movieResponse = modelMapper.map(updatedMovie, MovieResponse.class);
        return movieResponse;
    }

    @Transactional
    public MovieResponse makeMovieActive(Long id) {
        Movie movie = movieRepository.findByIdAndNotDeleted(id)
                .orElseThrow(()  -> new IllegalArgumentException("Movie not found"));
        movie.setActive(true);
        Movie updatedMovie = movieRepository.save(movie);
        MovieResponse movieResponse = modelMapper.map(updatedMovie, MovieResponse.class);
        return movieResponse;
    }

}
