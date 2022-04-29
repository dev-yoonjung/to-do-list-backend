package com.todo.todoapi.global.error.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    TODO_NOT_EXISTS(400, "할 일 정보가 존재하지 않습니다."),
    NOT_VALID_TODO_ID(401, "잘못된 요청입니다.");

    private int status;
    private String message;

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
