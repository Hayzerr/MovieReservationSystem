package com.bolashak.MovieReservationSystem.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "showtime")
public class Showtime extends AbstractEntity<Long>{
    @Column(nullable = false)
    private Long price;
    @Column(nullable = false, name = "start_time")
    private LocalDateTime startTime;
    @Column(nullable = false, name = "end_time")
    private LocalDateTime endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hall_id", referencedColumnName = "id", nullable = false)
    private Hall hall;

    @OneToMany(mappedBy = "showtime", fetch = FetchType.LAZY)
    private List<Reservation> reservations;

    @OneToOne(mappedBy = "showtime", cascade = CascadeType.ALL, orphanRemoval = true)
    private Revenue revenue;
}
