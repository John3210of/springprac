package com.assignment.myblog.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse {


    private String description;

    private String detail;

    public ErrorResponse(String description) {

        this.description = description;
    }

    public ErrorResponse(String description, String detail) {

        this.description = description;
        this.detail = detail;
    }
}