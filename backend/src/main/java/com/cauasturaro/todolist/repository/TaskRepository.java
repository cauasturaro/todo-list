package com.cauasturaro.todolist.repository;

import com.cauasturaro.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    public Optional<Task> findById(Long id);
}
