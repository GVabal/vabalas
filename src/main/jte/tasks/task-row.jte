@import dev.vabalas.app.task.Task

@param Task task

<ul style="border: 1px solid black">
    <li>${task.description()}</li>
    <li>
        <button hx-delete="tasks/${task.id()}"
                hx-target="closest ul"
                hx-swap="outerHTML swap:0.2s">
            Delete
        </button>
    </li>
</ul>
