package dev.vabalas.common.model;

import io.micronaut.serde.annotation.Serdeable;

import java.time.Instant;

@Serdeable
public record SampleResponse(String value, Instant timestamp) {
}
