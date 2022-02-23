package com.yohan.spring1.dto;

import com.yohan.spring1.model.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardResponseDto {
    private Long id;
    private String imageUrl;
    private String grid;
    private String content;
    private LocalDateTime createdAt;
    private String creater;
    private int likeCount;

    // 전체 글 조회
    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.imageUrl = board.getImageUrl();
        this.grid = board.getGrid();
        this.content = board.getContent();
        this.createdAt = board.getCreatedAt();
        this.creater=board.getUsername();
        this.likeCount=board.getLikeCount();
    }
}