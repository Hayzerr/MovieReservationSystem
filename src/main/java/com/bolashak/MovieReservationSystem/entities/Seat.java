package com.bolashak.MovieReservationSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "seat")
public class Seat extends AbstractEntity<Long>{

    @Column(nullable = false, name = "row")
    private Integer row;

    @Column(nullable = false, name = "number")
    private Integer number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hall_id", nullable = false)
    private Hall hall;

    @OneToMany(mappedBy = "seat", fetch = FetchType.LAZY)
    private List<Reservation> reservation;
}
