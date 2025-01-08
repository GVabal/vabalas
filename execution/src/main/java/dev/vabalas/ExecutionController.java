package dev.vabalas;

import dev.vabalas.common.model.SampleRequest;
import dev.vabalas.common.model.SampleResponse;
import io.micronaut.http.annotation.*;

import java.time.Instant;

@Controller("/execution")
public class ExecutionController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }

    @Post
    public SampleResponse post(@Body SampleRequest request) {
        return new SampleResponse(request.name(), Instant.now());
    }
}