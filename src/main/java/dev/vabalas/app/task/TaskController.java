package dev.vabalas.app.task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("tasks")
    public String home(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());

        return "tasks/home";
    }

    @PostMapping("tasks/add")
    public String addTask(@RequestParam String description, Model model) {
        var newTask = Task.createNew(description);
        taskRepository.add(newTask);

        model.addAttribute("task", newTask);

        return "tasks/task-row";
    }

    @DeleteMapping("tasks/delete/{id}")
    @ResponseBody
    public void deleteTask(@PathVariable String id) {
        boolean removed = taskRepository.remove(id);
        if (removed) {
            System.out.println("%s has been deleted".formatted(id));
        }
    }
}
