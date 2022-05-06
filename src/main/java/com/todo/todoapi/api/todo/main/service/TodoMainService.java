package com.todo.todoapi.api.todo.main.service;

import com.todo.todoapi.api.todo.main.dto.TodoMainDto;
import com.todo.todoapi.domain.todo.entity.Todo;
import com.todo.todoapi.domain.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TodoMainService {

    private final TodoService todoService;

    @Transactional
    public TodoMainDto register(TodoMainDto dto) {
        Todo todo = Todo.create(dto.toEntity());
        Todo saved = todoService.save(todo);

        return TodoMainDto.of(saved);
    }

    public List<TodoMainDto> findAll() {
        List<TodoMainDto> list = new ArrayList<>();
        todoService.findAll()
                .forEach(todo -> list.add(TodoMainDto.of(todo)));

        return list;
    }
}
