package com.todo.todoapi.api.todo.main.service;

import com.todo.todoapi.api.todo.main.dto.RegisterTodoDto;
import com.todo.todoapi.api.todo.main.dto.TodoDto;
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
    public TodoDto register(RegisterTodoDto dto) {
        Todo todo = Todo.create(dto.toEntity());
        Todo saved = todoService.save(todo);

        return TodoDto.of(saved);
    }

    public List<TodoDto> findAll() {
        List<TodoDto> list = new ArrayList<>();
        todoService.findAll()
                .forEach(todo -> list.add(TodoDto.of(todo)));

        return list;
    }

    @Transactional
    public TodoDto update(TodoDto dto) {
        Todo target = todoService.findById(dto.getId());
        target.update(dto.toEntity());

        return TodoDto.of(target);
    }

    @Transactional
    public TodoDto delete(Long id) {
        Todo target = todoService.findById(id);
        todoService.delete(target);

        return TodoDto.of(target);
    }
}
