package com.todo.todoapi.global.error;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Builder
public class ErrorResponse {

    private int status;

    private List<String> messages;

    public static ErrorResponse of(HttpStatus status, List<String> messages) {
        return ErrorResponse.builder()
                .status(status.value())
                .messages(messages)
                .build();
    }

}
