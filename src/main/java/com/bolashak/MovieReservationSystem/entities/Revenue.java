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
@Table(name = "revenue")
public class Revenue extends AbstractEntity<Long>{
    private Integer totalRevenue;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "showtime_id", referencedColumnName = "id", nullable = false)
    private Showtime showtime;
}
