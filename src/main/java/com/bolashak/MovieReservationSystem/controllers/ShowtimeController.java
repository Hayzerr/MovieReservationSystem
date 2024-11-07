package com.bolashak.MovieReservationSystem.controllers;

import com.bolashak.MovieReservationSystem.dto.requests.ShowtimeRequest;
import com.bolashak.MovieReservationSystem.dto.responses.ShowtimeResponse;
import com.bolashak.MovieReservationSystem.services.ShowtimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/showtimes")
@RequiredArgsConstructor
public class ShowtimeController {

    private final ShowtimeService showtimeService;

    @PostMapping
    public ResponseEntity<ShowtimeResponse> createShowtime(@RequestBody ShowtimeRequest showtimeRequest) {
        ShowtimeResponse showtimeResponse = showtimeService.createShowtime(showtimeRequest);
        return ResponseEntity.ok(showtimeResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowtimeResponse> getShowtimeById(@PathVariable Long id) {
        ShowtimeResponse showtimeResponse = showtimeService.getShowtimeById(id);
        return ResponseEntity.ok(showtimeResponse);
    }

    @GetMapping
    public ResponseEntity<List<ShowtimeResponse>> getAllShowtimes() {
        List<ShowtimeResponse> showtimeResponses = showtimeService.getAllShowtimes();
        return ResponseEntity.ok(showtimeResponses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShowtimeResponse> updateShowtime(@PathVariable Long id, @RequestBody ShowtimeRequest showtimeRequest) {
        ShowtimeResponse showtimeResponse = showtimeService.updateShowtime(id, showtimeRequest);
        return ResponseEntity.ok(showtimeResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShowtime(@PathVariable Long id) {
        showtimeService.deleteShowtime(id);
        return ResponseEntity.noContent().build();
    }
}

