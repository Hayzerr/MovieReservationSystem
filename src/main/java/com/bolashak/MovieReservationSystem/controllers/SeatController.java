package com.bolashak.MovieReservationSystem.controllers;

import com.bolashak.MovieReservationSystem.dto.requests.SeatCreateMultipleRequest;
import com.bolashak.MovieReservationSystem.dto.requests.SeatRequest;
import com.bolashak.MovieReservationSystem.dto.responses.SeatResponse;
import com.bolashak.MovieReservationSystem.services.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
@RequiredArgsConstructor
public class SeatController {
    private final SeatService seatService;

    @PostMapping
    public ResponseEntity<SeatResponse> createSeat(@RequestBody SeatRequest seatRequest) {
        SeatResponse seatResponse = seatService.createSeat(seatRequest);
        return ResponseEntity.ok(seatResponse);
    }

    @PostMapping("/multiple")
    public ResponseEntity<List<SeatResponse>> createMultipleSeats(@RequestBody SeatCreateMultipleRequest seatCreateMultipleRequest) {
        List<SeatResponse> seatResponses = seatService.createMultipleSeats(seatCreateMultipleRequest);
        return ResponseEntity.ok(seatResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeatResponse> getSeatById(@PathVariable Long id) {
        SeatResponse seatResponse = seatService.getSeatById(id);
        return ResponseEntity.ok(seatResponse);
    }

    @GetMapping
    public ResponseEntity<List<SeatResponse>> getAllSeats() {
        List<SeatResponse> seatResponses = seatService.getAllSeats();
        return ResponseEntity.ok(seatResponses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeatResponse> updateSeat(@PathVariable Long id, @RequestBody SeatRequest seatRequest) {
        SeatResponse seatResponse = seatService.updateSeat(id, seatRequest);
        return ResponseEntity.ok(seatResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeat(@PathVariable Long id) {
        seatService.deleteSeat(id);
        return ResponseEntity.noContent().build();
    }
}
