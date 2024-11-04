package com.bolashak.MovieReservationSystem.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.ZoneId;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValueConstants {
    public static final ZoneId ZONE_ID = ZoneId.of("UTC+00:00");
    public static final String schema_name = "movie_reservation_system";
}
