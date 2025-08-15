package com.lts.util.helpers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateFomatter {
    public static long getFiledDuration(String startDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDateLocal = LocalDate.parse(startDate, formatter);
        LocalDate currenDateLocal = LocalDate.now();

        Instant startUtc = startDateLocal.atStartOfDay().toInstant(ZoneOffset.UTC);
        Instant currentUtc = currenDateLocal.atStartOfDay().toInstant(ZoneOffset.UTC);

        return ChronoUnit.DAYS.between(startUtc, currentUtc);
    }

    public static long getDuration(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDateLocal = LocalDate.parse(startDate, formatter);
        LocalDate endDateLocal = LocalDate.parse(endDate, formatter);

        Instant startUtc = startDateLocal.atStartOfDay().toInstant(ZoneOffset.UTC);
        Instant endUtc = endDateLocal.atStartOfDay().toInstant(ZoneOffset.UTC);

        return ChronoUnit.DAYS.between(startUtc, endUtc);
    }

    public static String getCurrentDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return today.format(formatter);
    }
}
