package com.yohan.spring1.controller;

import com.yohan.spring1.dto.LikesRequestDto;
import com.yohan.spring1.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class LikesController {

    private final LikesService likesService;

    @PostMapping("/api/board/{boardid}/like")       //좋아요 추가
    public String addLikes(@PathVariable Long boardid, @RequestBody LikesRequestDto likesrequestDto){
        return likesService.upLikes(boardid, likesrequestDto);
    }

    @DeleteMapping("/api/board/{boardid}/like")     //좋아요 삭제
    public String minusLikes(@PathVariable Long boardid,@RequestBody LikesRequestDto likesrequestDto){
        return likesService.downLikes(boardid,likesrequestDto);
    }
}
