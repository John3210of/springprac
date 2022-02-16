package com.assignment.myblog.exception;

import lombok.Getter;

public enum ErrorCode {

    NOT_EMPTY("댓글 내용을 입력해주세요");

    @Getter
    private String description;

    ErrorCode(String description) {
        this.description = description;
    }
}