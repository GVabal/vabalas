package dev.vabalas.app;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = {"https://vabalas.my.id/", "http://127.0.0.1"}, maxAge = 3600)
public class TestEndpoint {

    @GetMapping("test")
    public String test() {
        return """
                {"yeet": "yeet"}
                """;
    }
}
