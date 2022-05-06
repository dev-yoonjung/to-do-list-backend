package com.todo.todoapi.api.todo.main.contorller;

import com.todo.todoapi.api.todo.main.dto.TodoMainDto;
import com.todo.todoapi.api.todo.main.service.TodoMainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

}
