package com.yohan.spring1.dto;

import lombok.Getter;

@Getter
public class LikesResponseDto {

    private final Long userId;

    public LikesResponseDto(Long userid){
        this.userId=userid;
    }

}
