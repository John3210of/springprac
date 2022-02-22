package com.yohan.spring1.dto;

import com.yohan.spring1.model.Board;

import java.time.LocalDateTime;

public class BoardDetailResponseDto {
    private Long id;
    private String imageUrl;
    private String grid;
    private String content;
    private LocalDateTime createdAt;
    private String creater;
    private int likeCount;

    //likeCount 세는 로직 ㄱ

    // 전체 글 조회
    public BoardDetailResponseDto(Board board) {
        this.id = board.getId();
        this.imageUrl = board.getImageUrl();
        this.grid = board.getGrid();
        this.content = board.getContent();
        this.createdAt = board.getCreatedAt();
        this.creater=board.getUsername();
        this.likeCount=3;
    }
}
