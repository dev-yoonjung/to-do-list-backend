package com.todo.todoapi.api.todo.main.contorller;

import com.todo.todoapi.api.todo.main.dto.TodoMainDto;
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
    public ResponseEntity<TodoMainDto> register(@RequestBody @Valid TodoMainDto dto) {
        TodoMainDto registered = todoMainService.register(dto);
        return ResponseEntity.ok(registered);
    }

    @GetMapping
    public ResponseEntity<List<TodoMainDto>> findAll() {
        List<TodoMainDto> list = todoMainService.findAll();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoMainDto> update(@RequestBody @Valid TodoMainDto dto, @PathVariable Long id) {
        if (!Objects.equals(dto.getId(), id)) {
            throw new BusinessException(ErrorCode.NOT_VALID_TODO_ID);
        }
        TodoMainDto updated = todoMainService.update(dto);
        return ResponseEntity.ok(updated);
    }

}
