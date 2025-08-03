const form = document.getElementById("add-task-form");
const descriptionInput = document.getElementById("description");
const taskList = document.getElementById("task-list");

let tasks = [];

form.addEventListener("submit", function (e) {
    e.preventDefault();

    const description = descriptionInput.value.trim();
    if (!description) return;

    fetch("/api/tasks", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ description })
    })
        .then(() => {
            descriptionInput.value = "";
            loadTasks();
        })
        .catch(error => console.error("Failed: ", error));
});

function loadTasks() {
    fetch("/api/tasks")
        .then(response => response.json())
        .then(data => {
            tasks = data;
            renderTasks();
        })
        .catch(error => console.error("Failed: ", error));
}

function renderTasks() {
    taskList.innerHTML = "";

    tasks.forEach(task => {
        const taskDiv = document.createElement("div");
        taskDiv.className = "task-item";
        if (task.finished) {
            taskDiv.classList.add("completed");
        }

        const deleteBtn = document.createElement("button");
        deleteBtn.textContent = "❌";
        deleteBtn.addEventListener("click", () => deleteTask(task.id));

        const span = document.createElement("span");
        span.textContent = task.description;

        const checkbox = document.createElement("input");
        checkbox.type = "checkbox";
        checkbox.checked = task.finished;
        checkbox.addEventListener("change", () => toggleTask(task.id, checkbox.checked));

        taskDiv.appendChild(deleteBtn);
        taskDiv.appendChild(span);
        taskDiv.appendChild(checkbox);
        taskList.appendChild(taskDiv);
    });
}

function toggleTask(id, ) {
    fetch(`/api/tasks/${id}`, {
        method: "PATCH"
    })
        .then(() => loadTasks())
        .catch(error => console.error("Failed: ", error));
}

function deleteTask(id) {
    fetch(`/api/tasks/${id}`, {
        method: "DELETE"
    })
        .then(() => loadTasks())
        .catch(error => console.error("Failed: ", error));
}

loadTasks();
