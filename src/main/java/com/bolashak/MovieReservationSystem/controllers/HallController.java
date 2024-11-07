package com.bolashak.MovieReservationSystem.controllers;

import com.bolashak.MovieReservationSystem.dto.requests.HallRequest;
import com.bolashak.MovieReservationSystem.dto.responses.HallResponse;
import com.bolashak.MovieReservationSystem.services.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/halls")
@RequiredArgsConstructor
public class HallController {

    private final HallService hallService;

    @PostMapping
    public ResponseEntity<HallResponse> createHall(@RequestBody HallRequest hallRequest) {
        HallResponse hallResponse = hallService.createHall(hallRequest);
        return ResponseEntity.ok(hallResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HallResponse> getHallById(@PathVariable Long id) {
        HallResponse hallResponse = hallService.getHallById(id);
        return ResponseEntity.ok(hallResponse);
    }

    @GetMapping
    public ResponseEntity<List<HallResponse>> getAllHalls() {
        List<HallResponse> hallResponses = hallService.getAllHalls();
        return ResponseEntity.ok(hallResponses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HallResponse> updateHall(@PathVariable Long id, @RequestBody HallRequest hallRequest) {
        HallResponse hallResponse = hallService.updateHall(id, hallRequest);
        return ResponseEntity.ok(hallResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHall(@PathVariable Long id) {
        hallService.deleteHall(id);
        return ResponseEntity.ok("Hall deleted successfully");
    }
}
