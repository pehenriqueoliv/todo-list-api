package com.todo.todo_list.service;

import com.todo.todo_list.dto.TaskRequestDTO;
import com.todo.todo_list.dto.TaskResponseDTO;
import com.todo.todo_list.exception.ResourceNotFoundException;
import com.todo.todo_list.model.TaskModel;
import com.todo.todo_list.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskResponseDTO create(TaskRequestDTO dto) {

        TaskModel task = new TaskModel();

        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setCompleted(dto.completed() != null ? dto.completed() : false);

        return toDTO(taskRepository.save(task));
    }

    public List<TaskResponseDTO> findAll() {

        return taskRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public TaskResponseDTO findById(Long id) {

        TaskModel task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Tarefa nao encontrada")
                );

        return toDTO(task);
    }

    public TaskResponseDTO update(Long id, TaskRequestDTO dto) {

        TaskModel task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Tarefa nao encontrada")
                );

        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setCompleted(dto.completed() != null ? dto.completed() : task.getCompleted());

        return toDTO(taskRepository.save(task));
    }

    public void delete(Long id) {

        taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Tarefa nao encontrada")
                );

        taskRepository.deleteById(id);
    }

    private TaskResponseDTO toDTO(TaskModel task) {

        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCompleted(),
                task.getCreatedAt(),
                task.getUpdatedAt()
        );
    }
}