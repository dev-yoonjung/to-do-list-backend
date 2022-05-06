package com.todo.todoapi.domain.todo.service;

import com.todo.todoapi.domain.todo.entity.Todo;
import com.todo.todoapi.domain.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {

    private final TodoRepository todoRepository;

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public Iterable<Todo> findAll() {
        return todoRepository.findAll();
    }

}
