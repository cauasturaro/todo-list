package com.cauasturaro.todolist.controller;

import com.cauasturaro.todolist.Service.TaskService;
import com.cauasturaro.todolist.dto.CreateTaskDTO;
import com.cauasturaro.todolist.dto.TaskResponseDTO;
import com.cauasturaro.todolist.model.Task;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService tarefaService){
        this.taskService = tarefaService;
    }

    @PostMapping
    public Task create(@Valid @RequestBody CreateTaskDTO dto) {
        return taskService.create(dto);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> list() {
        return taskService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> searchById(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<TaskResponseDTO> update(@PathVariable Long id, @Valid @RequestBody CreateTaskDTO dto) {
        return taskService.update(id, dto);
    }

    @PatchMapping("{id}")
    public ResponseEntity<TaskResponseDTO> check(@PathVariable Long id) {
        return taskService.check(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return taskService.delete(id);
    }

}
