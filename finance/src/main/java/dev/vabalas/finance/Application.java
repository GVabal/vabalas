package dev.vabalas.finance;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(title = "finance", version = "0.1"),
        servers = @Server(url = "https://finance.vabalas.my.id"))
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}