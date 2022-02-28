package com.yohan.spring1.controller;

import com.yohan.spring1.dto.BoardEditDto;
import com.yohan.spring1.dto.BoardRequestDto;
import com.yohan.spring1.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/api/board")  // 글 작성하기
    public String createBoard(@RequestBody BoardRequestDto boardRequestDto){
        return boardService.Save1(boardRequestDto);
    }

    @GetMapping("/api/board")   // 글 전체 조회하기
    public String ShowAll(){
        return boardService.showall();
    }

    @GetMapping("/api/board/{id}")  // 글 상세 페이지
    public String Showdetails(@PathVariable Long id){
        return boardService.brdDetail(id);
    }

    @PutMapping("/api/board/{id}")  // 글 수정하기
    public String updateBoard(@PathVariable Long id,@RequestBody BoardEditDto boardEditDto){
        return boardService.update(id,boardEditDto);
    }

    @DeleteMapping("/api/board/{id}")   // 글 삭제하기
    public String deleteBoard(@PathVariable Long id,@RequestBody BoardEditDto boardEditDto){
        return boardService.delete(id,boardEditDto);
    }

}
