package com.bolashak.MovieReservationSystem.services;

import com.bolashak.MovieReservationSystem.dto.requests.ShowtimeRequest;
import com.bolashak.MovieReservationSystem.dto.responses.ShowtimeResponse;

import java.util.List;

public interface ShowtimeService {
    ShowtimeResponse createShowtime(ShowtimeRequest showtimeRequest);
    ShowtimeResponse getShowtimeById(Long id);
    List<ShowtimeResponse> getAllShowtimes();
    ShowtimeResponse updateShowtime(Long id, ShowtimeRequest showtimeRequest);
    void deleteShowtime(Long id);
}

