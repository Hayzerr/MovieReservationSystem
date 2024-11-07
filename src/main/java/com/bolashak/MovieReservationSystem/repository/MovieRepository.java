package com.bolashak.MovieReservationSystem.repository;

import com.bolashak.MovieReservationSystem.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m FROM Movie m WHERE m.id = :id AND m.isDeleted = false")
    Optional<Movie> findByIdAndNotDeleted(Long id);

    @Query("SELECT m FROM Movie m WHERE m.isDeleted = false")
    List<Movie> findAllByIsDeletedFalse();
}
