package com.bolashak.MovieReservationSystem.services;

import com.bolashak.MovieReservationSystem.dto.requests.SeatCreateMultipleRequest;
import com.bolashak.MovieReservationSystem.dto.requests.SeatRequest;
import com.bolashak.MovieReservationSystem.dto.responses.SeatResponse;

import java.util.List;

public interface SeatService {
    SeatResponse createSeat(SeatRequest seatRequest);
    SeatResponse getSeatById(Long id);
    List<SeatResponse> getAllSeats();
    SeatResponse updateSeat(Long id, SeatRequest seatRequest);
    List<SeatResponse> createMultipleSeats(SeatCreateMultipleRequest seatCreateMultipleRequest);
    void deleteSeat(Long id);
}
