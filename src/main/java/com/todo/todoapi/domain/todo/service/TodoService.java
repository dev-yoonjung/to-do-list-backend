package com.todo.todoapi.domain.todo.service;

import com.todo.todoapi.domain.todo.entity.Todo;
import com.todo.todoapi.domain.todo.repository.TodoRepository;
import com.todo.todoapi.global.error.exception.BusinessException;
import com.todo.todoapi.global.error.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Todo findById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.TODO_NOT_EXISTS));
    }
}
