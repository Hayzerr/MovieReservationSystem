package com.bolashak.MovieReservationSystem.services.impl;

import com.bolashak.MovieReservationSystem.dto.requests.HallRequest;
import com.bolashak.MovieReservationSystem.dto.responses.HallResponse;
import com.bolashak.MovieReservationSystem.entities.Hall;
import com.bolashak.MovieReservationSystem.repository.HallRepository;
import com.bolashak.MovieReservationSystem.services.HallService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HallServiceImpl implements HallService {

    private final HallRepository hallRepository;
    private final ModelMapper modelMapper;

    @Override
    public HallResponse createHall(HallRequest hallRequest) {
        Hall hall = modelMapper.map(hallRequest, Hall.class);
        Hall createdHall = hallRepository.save(hall);
        return modelMapper.map(createdHall, HallResponse.class);
    }

    @Override
    public HallResponse getHallById(Long id) {
        Hall hall = hallRepository.findByIdAndNotDeleted(id)
                .orElseThrow(() -> new RuntimeException("Hall not found"));
        return modelMapper.map(hall, HallResponse.class);
    }

    @Override
    public List<HallResponse> getAllHalls() {
        List<Hall> halls = hallRepository.findAllByIsDeletedFalse();
        return halls.stream()
                .map(hall -> modelMapper.map(hall, HallResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public HallResponse updateHall(Long id, HallRequest hallRequest) {
        Hall hall = hallRepository.findByIdAndNotDeleted(id)
                .orElseThrow(() -> new RuntimeException("Hall not found"));
        hall.setName(hallRequest.getName());
        hall.setRoomNumber(hallRequest.getRoomNumber());
        Hall updatedHall = hallRepository.save(hall);
        return modelMapper.map(updatedHall, HallResponse.class);
    }

    @Override
    public void deleteHall(Long id) {
        Hall hall = hallRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Hall not found"));
        hall.setDeleted(true);
        hallRepository.save(hall);
    }
}
