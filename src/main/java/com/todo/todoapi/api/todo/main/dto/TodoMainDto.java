package com.todo.todoapi.api.todo.main.dto;

import com.todo.todoapi.domain.todo.entity.Todo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
public class TodoMainDto {

    @NotNull(message = "Todo ID is a required input value.")
    private Long id;

    @NotBlank(message = "Todo content cannot be blank.")
    @Size(min = 1, max = 100, message = "Content is too long or too short.")
    private String name;

    @NotNull(message = "Todo completed is a required input value.")
    private Boolean completed;

    public static TodoMainDto of (Todo todo) {
        return TodoMainDto.builder()
                .id(todo.getId())
                .name(todo.getName())
                .completed(todo.getCompleted())
                .build();
    }

    public Todo toEntity() {
        return Todo.builder()
                .id(this.id)
                .name(this.name)
                .completed(this.completed)
                .build();
    }

}
