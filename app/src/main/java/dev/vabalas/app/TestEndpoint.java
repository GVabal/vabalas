package dev.vabalas.app;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost/", maxAge = 3600)
public class TestEndpoint {

    @GetMapping("test")
    public String test() {
        return """
                {"yeet": "yeet"}
                """;
    }
}
