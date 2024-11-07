package com.bolashak.MovieReservationSystem.repository;

import com.bolashak.MovieReservationSystem.entities.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    @Query("SELECT s FROM Showtime s WHERE s.id = :id AND s.isDeleted = false")
    Optional<Showtime> findByIdAndNotDeleted(Long id);
    @Query("SELECT s FROM Showtime s WHERE s.isDeleted = false")
    List<Showtime> findAllByDeletedFalse();
}
