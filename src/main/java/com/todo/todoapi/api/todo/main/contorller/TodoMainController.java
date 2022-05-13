package com.todo.todoapi.api.todo.main.contorller;

import com.todo.todoapi.api.todo.main.dto.RegisterTodoDto;
import com.todo.todoapi.api.todo.main.dto.TodoDto;
import com.todo.todoapi.api.todo.main.service.TodoMainService;
import com.todo.todoapi.global.error.exception.BusinessException;
import com.todo.todoapi.global.error.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/todo/main")
public class TodoMainController {

    private final TodoMainService todoMainService;

    @PostMapping
    public ResponseEntity<TodoDto> register(@RequestBody @Valid RegisterTodoDto dto) {
        TodoDto registered = todoMainService.register(dto);

        return ResponseEntity.ok(registered);
    }

    @GetMapping
    public ResponseEntity<List<TodoDto>> findAll() {
        List<TodoDto> list = todoMainService.findAll();

        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> update(@RequestBody @Valid TodoDto dto, @PathVariable Long id) {
        if (!Objects.equals(dto.getId(), id)) {
            throw new BusinessException(ErrorCode.NOT_VALID_TODO_ID);
        }
        TodoDto updated = todoMainService.update(dto);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TodoDto> delete(@PathVariable Long id) {
        TodoDto deleted = todoMainService.delete(id);

        return ResponseEntity.ok(deleted);
    }

}
