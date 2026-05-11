package com.todo.todo_list.dto;

import java.time.LocalDateTime;

public record TaskResponseDTO(
        Long id,
        String title,
        String description,
        Boolean completed,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
