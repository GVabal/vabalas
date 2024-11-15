package dev.vabalas.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

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
            log.info("something interesting");
        } else {
            log.error("this is concerning");
        }
        return new Yeet("yeet api");
    }

    public record Yeet(String yeet) {
    }
}
