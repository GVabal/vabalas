package dev.vabalas.app.task;

import java.util.UUID;

public record Task(String id, String description) {

    public static Task createNew(String description) {
        return new Task(UUID.randomUUID().toString(), description);
    }
}
