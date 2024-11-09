@import dev.vabalas.app.task.Task
@import java.util.List

@param List<Task> tasks

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Tasks</title>
    <script src="https://unpkg.com/htmx.org@2.0.3"></script>
</head>
<body style="background-color: darkslateblue">
<div style="border: 1px solid darkred">
    <form hx-post="tasks/add" hx-target="#taskListBody" hx-swap="beforeend" hx-on::after-request="this.reset()">
        <input id="newTaskDescriptionInput" type="text" placeholder="Enter new task" name="description">
        <button type="submit">Add</button>
    </form>
</div>
<div id="taskListBody" style="border: 1px solid red">
    @for(var task : tasks)
        @template.tasks.task-row(task = task)
    @endfor
</div>
</body>
</html>
