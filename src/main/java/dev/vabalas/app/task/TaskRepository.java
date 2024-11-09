package dev.vabalas.app.task;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {

    private static final List<Task> TASKS = new ArrayList<>();

    public List<Task> findAll() {
        return TASKS;
    }

    public void add(Task task) {
        TASKS.add(task);
    }

    public boolean remove(String id) {
        return TASKS.removeIf(task -> task.id().equals(id));
    }

    @PostConstruct
    private void init() {
        TASKS.addAll(List.of(
                Task.createNew("buy eggs"),
                Task.createNew("clean house"),
                Task.createNew("fix table"),
                Task.createNew("burn files"),
                Task.createNew("make coffee"),
                Task.createNew("exercise"),
                Task.createNew("print documents"),
                Task.createNew("visit parents"),
                Task.createNew("cut nails"),
                Task.createNew("visit church"),
                Task.createNew("drink problems away"),
                Task.createNew("find trouble"),
                Task.createNew("watch tv"),
                Task.createNew("buy tickets"),
                Task.createNew("borrow money"),
                Task.createNew("reply to a message")
        ));
    }
}
