package com.todo.todoapi.api.todo.main.contorller;

import com.todo.todoapi.api.todo.main.service.TodoMainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/todo/main")
public class TodoMainController {

    private final TodoMainService todoMainService;

    

}
