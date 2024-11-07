package com.bolashak.MovieReservationSystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "genre")
public class Genre extends AbstractEntity<Long>{
    @Column(nullable = false, unique = true)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
    private List<Movie> movies;
}
