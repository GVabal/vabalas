package dev.vabalas.finance;

import io.micronaut.http.annotation.*;

@Controller("/finance")
public class FinanceController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}