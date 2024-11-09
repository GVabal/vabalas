package dev.vabalas.app.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("tasks")
public class TaskController {

    private static final Logger log = LoggerFactory.getLogger(TaskController.class);

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());

        return "tasks/home";
    }

    @PostMapping
    public String addTask(@RequestParam String description, Model model) {
        var newTask = Task.createNew(description);
        taskRepository.add(newTask);

        log.info("{} has been added", newTask.id());
        model.addAttribute("task", newTask);

        return "tasks/task-row";
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public void deleteTask(@PathVariable String id) {
        boolean removed = taskRepository.remove(id);
        if (removed) {
            log.info("{} has been deleted", id);
        }
    }
}
