package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.WelcomeRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/translation")
@CrossOrigin
public class TranslationController {
    private Executor executor = Executors.newFixedThreadPool(2);
    private final WelcomeRequest welcomeRequest = new WelcomeRequest();

    @GetMapping("welcome")
    public ResponseEntity<List<String>> welcome() {
        List<String> messages = new ArrayList<>();
        executor.execute(() -> {
            try {
                messages.add(welcomeRequest.getEnglishWelcome());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        executor.execute(() -> {
            try {
                messages.add(welcomeRequest.getFrenchWelcome());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return ResponseEntity.ok(messages);
    }
}
