package com.bolashak.MovieReservationSystem.repository;

import com.bolashak.MovieReservationSystem.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    @Query("SELECT g FROM Genre g WHERE g.name = :name AND g.isDeleted = false")
    Genre findByNameAndNotDeleted(String name);
}
