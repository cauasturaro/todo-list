package com.cauasturaro.todolist.dto;

import com.cauasturaro.todolist.model.Task;

public record TaskResponseDTO(
        Long id,
        String description,
        boolean finished
) {
    public TaskResponseDTO(Task task) {
        this(task.getId(), task.getDescription(), task.isFinished());
    }
}
