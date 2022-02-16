package com.assignment.myblog.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PostRequestDto {

    private String username;
    private String postname;
    private String contents;

}
