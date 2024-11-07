package com.bolashak.MovieReservationSystem.services.impl;

import com.bolashak.MovieReservationSystem.dto.requests.ShowtimeRequest;
import com.bolashak.MovieReservationSystem.dto.responses.ShowtimeResponse;
import com.bolashak.MovieReservationSystem.entities.Hall;
import com.bolashak.MovieReservationSystem.entities.Movie;
import com.bolashak.MovieReservationSystem.entities.Showtime;
import com.bolashak.MovieReservationSystem.repository.HallRepository;
import com.bolashak.MovieReservationSystem.repository.MovieRepository;
import com.bolashak.MovieReservationSystem.repository.ShowtimeRepository;
import com.bolashak.MovieReservationSystem.services.ShowtimeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShowtimeServiceImpl implements ShowtimeService {

    private final ShowtimeRepository showtimeRepository;
    private final HallRepository hallRepository;
    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;

    @Override
    public ShowtimeResponse createShowtime(ShowtimeRequest showtimeRequest) {
        Hall hall = hallRepository.findByIdAndNotDeleted(showtimeRequest.getHallId())
                .orElseThrow(() -> new RuntimeException("Hall not found"));

        Movie movie = movieRepository.findByIdAndNotDeleted(showtimeRequest.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        Showtime showtime = new Showtime();
        showtime.setPrice(showtimeRequest.getPrice());
        showtime.setStartTime(showtimeRequest.getStartTime());
        showtime.setEndTime(showtimeRequest.getEndTime());
        showtime.setHall(hall);
        showtime.setMovie(movie);

        Showtime createdShowtime = showtimeRepository.save(showtime);
        return modelMapper.map(createdShowtime, ShowtimeResponse.class);
    }

    @Override
    public ShowtimeResponse getShowtimeById(Long id) {
        Showtime showtime = showtimeRepository.findByIdAndNotDeleted(id)
                .orElseThrow(() -> new RuntimeException("Showtime not found or inactive"));
        return modelMapper.map(showtime, ShowtimeResponse.class);
    }

    @Override
    public List<ShowtimeResponse> getAllShowtimes() {
        List<Showtime> showtimes = showtimeRepository.findAllByDeletedFalse();
        return showtimes.stream()
                .map(showtime -> modelMapper.map(showtime, ShowtimeResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public ShowtimeResponse updateShowtime(Long id, ShowtimeRequest showtimeRequest) {
        Showtime showtime = showtimeRepository.findByIdAndNotDeleted(id)
                .orElseThrow(() -> new RuntimeException("Showtime not found or inactive"));

        Hall hall = hallRepository.findByIdAndNotDeleted(showtimeRequest.getHallId())
                .orElseThrow(() -> new RuntimeException("Hall not found"));

        Movie movie = movieRepository.findByIdAndNotDeleted(showtimeRequest.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        showtime.setPrice(showtimeRequest.getPrice());
        showtime.setStartTime(showtimeRequest.getStartTime());
        showtime.setEndTime(showtimeRequest.getEndTime());
        showtime.setHall(hall);
        showtime.setMovie(movie);

        Showtime updatedShowtime = showtimeRepository.save(showtime);
        return modelMapper.map(updatedShowtime, ShowtimeResponse.class);
    }

    @Override
    public void deleteShowtime(Long id) {
        Showtime showtime = showtimeRepository.findByIdAndNotDeleted(id)
                .orElseThrow(() -> new RuntimeException("Showtime not found"));
        showtime.setDeleted(true);
        showtimeRepository.save(showtime);
    }
}
