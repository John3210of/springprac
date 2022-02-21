package com.yohan.spring1.dto;

import lombok.Data;

@Data
public class BoardRequestDto {

    private String username;
    private String imageUrl;
    private String grid;
    private String content;

}