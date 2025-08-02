package com.cauasturaro.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateTaskDTO(

        @NotBlank(message = "Description must not be empty")
        @Size(min = 1, max = 255, message = "Description can't exceed 255 and must have at least 1 character")
        String description
){
}
