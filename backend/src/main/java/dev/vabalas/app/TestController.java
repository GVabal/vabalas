package dev.vabalas.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping
    public Yeet yeet() {
        return new Yeet("yeet");
    }

    public record Yeet(String yeet) {
    }
}
