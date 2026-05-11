package com.todo.todo_list.controller;

import com.todo.todo_list.dto.TaskRequestDTO;
import com.todo.todo_list.dto.TaskResponseDTO;
import com.todo.todo_list.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponseDTO> create(
            @RequestBody @Valid TaskRequestDTO dto
    ) {

        TaskResponseDTO response = taskService.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> findAll() {

        return ResponseEntity.ok(taskService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> findById(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(taskService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> update(
            @PathVariable Long id,
            @RequestBody @Valid TaskRequestDTO dto
    ) {

        return ResponseEntity.ok(taskService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {

        taskService.delete(id);

        return ResponseEntity.noContent().build();
    }
}