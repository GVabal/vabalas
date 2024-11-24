package dev.vabalas.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    private final SampleRepository sampleRepository;

    public TestController(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @GetMapping
    public Yeet yeet() {
        if (System.currentTimeMillis() % 2 == 0) {
            log.info("something interesting");
        } else {
            log.error("this is concerning");
        }
        return new Yeet(getSampleValues());
    }

    @GetMapping("api")
    public Yeet yeetApi() {
        if (System.currentTimeMillis() % 2 == 0) {
            log.info("something interesting api");
        } else {
            log.error("this is concerning api");
        }
        return new Yeet("api: " + getSampleValues());
    }

    public record Yeet(String yeet) {
    }

    private String getSampleValues() {
        return sampleRepository.findAll()
                .stream()
                .map(SampleEntity::getSomeValue)
                .reduce("", (a, b) -> a.concat(" ").concat(b))
                .trim();
    }
}
