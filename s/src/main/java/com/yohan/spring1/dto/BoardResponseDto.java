package com.yohan.spring1.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class BoardResponseDto {
    private Long boardId;
    private String imageUrl;
    private String grid;
    private String content;
    private LocalDateTime createdAt;
    private String creater;
    private int likeCount;
    private List<LikesResponseDto> likes;


    @Builder
    public BoardResponseDto(Long boardId, String creater, String content,String imageUrl, String grid, int likeCount
            ,LocalDateTime createdAt, List<LikesResponseDto> likes){
        this.boardId = boardId;
        this.creater = creater;
        this.content = content;
        this.imageUrl = imageUrl;
        this.grid = grid;
        this.likeCount = likeCount;
        this.createdAt = createdAt;
        this.likes = likes;
    }
}