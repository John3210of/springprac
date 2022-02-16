package com.assignment.myblog.domain;

import lombok.Getter;

@Getter
public class AddtextRequestDto {
    private Long postid;
    private String username;
    private String contents;
}