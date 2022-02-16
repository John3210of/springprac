package com.assignment.myblog.domain;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class AddtextRequestDto {
    private Long postid;
    private String username;

    @NotEmpty(message = "내용을 입력해 주세요")
    private String contents;
}