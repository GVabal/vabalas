package dev.vabalas.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @GetMapping
    public Yeet yeet() {
        if (System.currentTimeMillis() % 2 == 0) {
            log.info("something interesting");
        } else {
            log.error("this is concerning");
        }
        return new Yeet("yeet");
    }

    @GetMapping("api")
    public Yeet yeetApi() {
        if (System.currentTimeMillis() % 2 == 0) {
            log.info("something interesting api");
        } else {
            log.error("this is concerning api");
        }
        return new Yeet("yeet api");
    }

    public record Yeet(String yeet) {
    }
}
