package dev.vabalas;

import dev.vabalas.common.model.SampleRequest;
import dev.vabalas.common.model.SampleResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.serde.annotation.Serdeable;

import java.time.Instant;

@Serdeable
@Controller("/preparation")
public class PreparationController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }

    @Post
    public SampleResponse post(@Body SampleRequest request) {
        return new SampleResponse(request.name(), Instant.now());
    }
}