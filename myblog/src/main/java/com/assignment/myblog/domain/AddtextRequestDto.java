package com.assignment.myblog.domain;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class AddtextRequestDto {
    private Long postid;
    private String username;

    @NotEmpty(message = "공백은 불가능 합니다")
    private String contents;
}