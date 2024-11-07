package com.bolashak.MovieReservationSystem.services.impl;

import com.bolashak.MovieReservationSystem.dto.requests.SeatCreateMultipleRequest;
import com.bolashak.MovieReservationSystem.dto.requests.SeatRequest;
import com.bolashak.MovieReservationSystem.dto.responses.SeatResponse;
import com.bolashak.MovieReservationSystem.entities.Hall;
import com.bolashak.MovieReservationSystem.entities.Seat;
import com.bolashak.MovieReservationSystem.repository.HallRepository;
import com.bolashak.MovieReservationSystem.repository.SeatRepository;
import com.bolashak.MovieReservationSystem.services.SeatService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.LongToDoubleFunction;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {
    private final SeatRepository seatRepository;
    private final HallRepository hallRepository;
    private final ModelMapper modelMapper;

    @Override
    public SeatResponse createSeat(SeatRequest seatRequest) {
        Hall hall = hallRepository.findByIdAndNotDeleted(seatRequest.getHallId())
                .orElseThrow(() -> new IllegalArgumentException("Hall not found"));

        boolean seatExists = seatRepository.existsByHallAndRowAndNumberAndIsDeletedFalse(hall, seatRequest.getRow(), seatRequest.getNumber());
        if (seatExists) {
            throw new IllegalArgumentException("A seat with the given row and number already exists in this hall");
        }

        Seat seat = new Seat();
        seat.setRow(seatRequest.getRow());
        seat.setNumber(seatRequest.getNumber());
        seat.setHall(hall);

        log.info("Seat createdAt: {}", seat.getCreatedAt());

        Seat createdSeat = seatRepository.save(seat);

        return modelMapper.map(createdSeat, SeatResponse.class);
    }

    @Override
    @Transactional
    public List<SeatResponse> createMultipleSeats(SeatCreateMultipleRequest seatCreateMultipleRequest) {
        Hall hall = hallRepository.findByIdAndNotDeleted(seatCreateMultipleRequest.getHallId())
                .orElseThrow(() -> new IllegalArgumentException("Hall not found"));

        List<Seat> seats = new ArrayList<>();

        for(int number = 1; number <= seatCreateMultipleRequest.getAmount(); number++) {
            Seat seat = new Seat();
            seat.setRow(seatCreateMultipleRequest.getRow());
            seat.setNumber(number);
            seat.setHall(hall);
            boolean seatExists = seatRepository.existsByHallAndRowAndNumberAndIsDeletedFalse(hall, seat.getRow(), seat.getNumber());
            if (seatExists) {
                continue;
            }
            seats.add(seat);
        }

        List<Seat> createdSeats = seatRepository.saveAll(seats);

        return createdSeats.stream().map(seat -> modelMapper.map(seat, SeatResponse.class)).collect(Collectors.toList());
    }

    @Override
    public SeatResponse getSeatById(Long id) {
        Seat seat = seatRepository.findByIdAndNotDeleted(id)
                .orElseThrow(() -> new RuntimeException("Seat not found"));
        return modelMapper.map(seat, SeatResponse.class);
    }

    @Override
    public List<SeatResponse> getAllSeats() {
        List<Seat> seats = seatRepository.findAllByIsDeletedFalse();
        return seats.stream().map(seat -> modelMapper.map(seat, SeatResponse.class)).collect(Collectors.toList());
    }

    @Override
    public SeatResponse updateSeat(Long id, SeatRequest seatRequest) {
        Seat seat = seatRepository.findByIdAndNotDeleted(id)
                .orElseThrow(() -> new RuntimeException("Seat not found"));

        Hall hall = hallRepository.findByIdAndNotDeleted(seatRequest.getHallId())
                .orElseThrow(() -> new RuntimeException("Hall not found"));

        seat.setRow(seatRequest.getRow());
        seat.setNumber(seatRequest.getNumber());
        seat.setHall(hall);
        Seat updatedSeat = seatRepository.save(seat);

        return modelMapper.map(updatedSeat, SeatResponse.class);
    }

    @Override
    public void deleteSeat(Long id) {
        Seat seat = seatRepository.findByIdAndNotDeleted(id)
                .orElseThrow(() -> new RuntimeException("Seat not found"));
        seat.setDeleted(true);
        seatRepository.save(seat);
    }
}
