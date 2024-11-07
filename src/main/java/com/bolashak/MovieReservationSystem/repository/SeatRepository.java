package com.bolashak.MovieReservationSystem.repository;

import com.bolashak.MovieReservationSystem.entities.Hall;
import com.bolashak.MovieReservationSystem.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    @Query("SELECT s FROM Seat s WHERE s.isDeleted = false")
    List<Seat> findAllActiveSeats();

    @Query("SELECT s FROM Seat s WHERE s.id = :id AND s.isDeleted = false")
    Optional<Seat> findByIdAndNotDeleted(@Param("id") Long id);

    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM Seat s WHERE s.hall = :hall AND s.row = :row AND s.number = :number AND s.isDeleted = false")
    boolean existsByHallAndRowAndNumberAndIsDeletedFalse(Hall hall, Integer row, Integer number);

    @Query("SELECT s FROM Seat s WHERE s.isDeleted = false")
    List<Seat> findAllByIsDeletedFalse();
}