package edu.wgu.d387_sample_code;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;;

public class TimeConversion {
    public String getTimeET() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        ZonedDateTime time = ZonedDateTime.now(ZoneId.of("US/Eastern"));
        return time.format(formatter) + " ET";
    }

    public String getTimeMT() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        ZonedDateTime time = ZonedDateTime.now(ZoneId.of("America/Denver"));
        return time.format(formatter) + " MT";
    }

    public String getTimeUTC() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        ZonedDateTime time = ZonedDateTime.now(ZoneId.of("UTC"));
        return time.format(formatter) + " UTC";
    }
}
