package com.todo.todoapi.api.todo.main.service;

import com.todo.todoapi.domain.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TodoMainService {

    private final TodoService todoService;

}
