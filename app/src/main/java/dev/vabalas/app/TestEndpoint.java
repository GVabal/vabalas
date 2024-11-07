package dev.vabalas.app;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEndpoint {

    @GetMapping("test")
    @CrossOrigin(origins = "https://vabalas.my.id")
    public String test() {
        return """
                {"yeet": "yeet"}
                """;
    }
}
