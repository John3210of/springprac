package com.yohan.spring1.controller;

import com.yohan.spring1.dto.LikesRequestDto;
import com.yohan.spring1.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class LikesController {
    private final LikesService likesService;

    @PostMapping("/api/board/{boardid}/like")
    public String addLikes(@PathVariable Long boardid, @RequestBody LikesRequestDto likesrequestDto, HttpServletRequest request){
        return likesService.upLikes(boardid, likesrequestDto, request);
    }

    @DeleteMapping("/api/board/{boardid}/like")
    public String minusLikes(@PathVariable Long boardid,HttpServletRequest request){
        return likesService.downLikes(boardid,request);
    }
}
