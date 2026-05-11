package com.todo.todo_list.dto;

import jakarta.validation.constraints.NotBlank;

public record TaskRequestDTO(
        @NotBlank String title,
        @NotBlank String description,
        Boolean completed
) {}
