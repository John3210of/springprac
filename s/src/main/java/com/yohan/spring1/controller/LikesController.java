package com.yohan.spring1.controller;

import com.yohan.spring1.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LikesController {
    private final LikesService likesService;

    @PostMapping("/api/board/{boardid}/like")
    public String addLikes(@PathVariable Long boardid){
        return likesService.upLikes(boardid);
    }

    @DeleteMapping("/api/board/{boardid}/like")
    public String minusLikes(@PathVariable Long boardid){
        return likesService.downLikes(boardid);
    }
}
