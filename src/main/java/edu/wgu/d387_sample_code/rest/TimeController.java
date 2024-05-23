package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.TimeConversion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/time")
@CrossOrigin
public class TimeController {
    private final TimeConversion timeConversion = new TimeConversion();

    @GetMapping("conversion")
    public ResponseEntity<List<String>> conversion() {
        List<String> times = new ArrayList<>();
        times.add(timeConversion.getTimeET());
        times.add(timeConversion.getTimeMT());
        times.add(timeConversion.getTimeUTC());

        return ResponseEntity.ok(times);
    }
}
