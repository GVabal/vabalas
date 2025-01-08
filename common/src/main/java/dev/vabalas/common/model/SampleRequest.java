package dev.vabalas.common.model;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record SampleRequest(String name) {
}
