package com.bolashak.MovieReservationSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservation")
public class Reservation extends AbstractEntity<Long>{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "showtime_id", referencedColumnName = "id", nullable = false)
    private Showtime showtime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id", referencedColumnName = "id", nullable = false)
    private Seat seat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL, orphanRemoval = true, optional = false)
    private Payment payment;
}
