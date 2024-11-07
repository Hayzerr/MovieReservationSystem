package com.bolashak.MovieReservationSystem.repository;

import com.bolashak.MovieReservationSystem.entities.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HallRepository extends JpaRepository<Hall, Long> {
    @Query("SELECT h FROM Hall h WHERE h.roomNumber = :roomNumber AND h.isDeleted = false")
    Optional<Hall> findByRoomNumberAndNotDeleted(String roomNumber);

    @Query("SELECT h FROM Hall h WHERE h.id = :id AND h.isDeleted = false")
    Optional<Hall> findByIdAndNotDeleted(Long id);

    @Query("SELECT h FROM Hall h WHERE h.isDeleted = false")
    List<Hall> findAllByIsDeletedFalse();
}
