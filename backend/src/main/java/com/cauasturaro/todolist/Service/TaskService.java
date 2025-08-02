package com.cauasturaro.todolist.Service;

import com.cauasturaro.todolist.dto.CreateTaskDTO;
import com.cauasturaro.todolist.dto.TaskResponseDTO;
import com.cauasturaro.todolist.model.Task;
import com.cauasturaro.todolist.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(CreateTaskDTO dto) {
        Task task = new Task();
        task.setDescription(dto.description());
        task.setFinished(false);

        return taskRepository.save(task);
    }

    public ResponseEntity<List<TaskResponseDTO>> list() {
        List<Task> tasks = this.taskRepository.findAll();
        List<TaskResponseDTO> taskListDTO = tasks.stream().map(TaskResponseDTO::new).toList();

        return ResponseEntity.ok(taskListDTO);
    }

    public ResponseEntity<TaskResponseDTO> findById(Long id) {
        Optional<Task> task = taskRepository.findById(id);

        return task.map(taskResponse -> {
            TaskResponseDTO taskResponseDTO = new TaskResponseDTO(taskResponse.getId(), taskResponse.getDescription(), taskResponse.isFinished());
            return ResponseEntity.ok(taskResponseDTO);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<TaskResponseDTO> update(Long id, CreateTaskDTO dto) {
        Optional<Task> task = taskRepository.findById(id);

        return task.map(taskUpdate -> {
            taskUpdate.setDescription(dto.description());
            Task updatedTask = taskRepository.save(taskUpdate);
            TaskResponseDTO taskResponseDTO = new TaskResponseDTO(updatedTask.getId(), updatedTask.getDescription(), updatedTask.isFinished());
            return ResponseEntity.ok(taskResponseDTO);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<TaskResponseDTO> check(Long id) {
        Optional<Task> task = taskRepository.findById(id);

        return task.map(checkTask -> {
            checkTask.setFinished(!checkTask.isFinished());
            Task updatedTask = taskRepository.save(checkTask);
            TaskResponseDTO taskResponseDTO = new TaskResponseDTO(updatedTask.getId(), updatedTask.getDescription(), updatedTask.isFinished());
            return ResponseEntity.ok(taskResponseDTO);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity delete(Long id) {
        Optional<Task> task = taskRepository.findById(id);

        return task.map(taskDelete -> {
            taskRepository.delete(taskDelete);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
