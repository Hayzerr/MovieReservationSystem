package com.bolashak.MovieReservationSystem.services;

import com.bolashak.MovieReservationSystem.dto.requests.HallRequest;
import com.bolashak.MovieReservationSystem.dto.responses.HallResponse;

import java.util.List;

public interface HallService {
    HallResponse createHall(HallRequest hallRequest);
    HallResponse getHallById(Long id);
    List<HallResponse> getAllHalls();
    HallResponse updateHall(Long id, HallRequest hallRequest);
    void deleteHall(Long id);
}
