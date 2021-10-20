package com.example.world;

import java.util.Random;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldController {

    @GetMapping("")
    public String world() {
        randomRunLong();
        return "World! #1";
    }

    private void randomRunLong() {
        Random rand = new Random();
        if (rand.nextInt(2) == 0) { // 50% 확률
            sleep();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(3000); // 3초 지연
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
