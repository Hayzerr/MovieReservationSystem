package com.bolashak.MovieReservationSystem.entities;

import com.bolashak.MovieReservationSystem.config.LocalDateTimeAttributeConverter;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.time.LocalDateTime;

import static com.bolashak.MovieReservationSystem.constants.ValueConstants.ZONE_ID;

@EqualsAndHashCode
@Getter
@MappedSuperclass
public abstract class AbstractEntity<T extends Serializable> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    T id;

    @Column(name = "is_active")
    @ColumnDefault("true")
    private boolean isActive;

    @Column(name = "created_at", nullable = false)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.updatedAt = this.createdAt = LocalDateTime.now(ZONE_ID);
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now(ZONE_ID);
    }
}
