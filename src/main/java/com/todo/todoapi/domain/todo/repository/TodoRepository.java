package com.todo.todoapi.domain.todo.repository;

import com.todo.todoapi.domain.todo.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
