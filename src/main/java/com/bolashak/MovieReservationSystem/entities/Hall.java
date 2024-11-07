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
@Table(name = "hall")
public class Hall extends AbstractEntity<Long>{
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String roomNumber;

    @OneToMany(mappedBy = "hall", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Seat> seats;

    @OneToMany(mappedBy = "hall", fetch = FetchType.LAZY)
    private List<Showtime> showtimes;

}
