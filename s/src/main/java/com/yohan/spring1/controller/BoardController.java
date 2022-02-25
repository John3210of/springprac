package com.yohan.spring1.controller;

import com.yohan.spring1.dto.BoardEditDto;
import com.yohan.spring1.dto.BoardRequestDto;
import com.yohan.spring1.dto.BoardResponseDto;
import com.yohan.spring1.model.Board;
import com.yohan.spring1.repository.BoardRepository;
import com.yohan.spring1.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @PostMapping("/api/board")  //글 작성하기
    public String createBoard(@RequestBody BoardRequestDto boardRequestDto){
        return boardService.Save1(boardRequestDto);
    }

    @GetMapping("/api/board")   //글 전체 조회하기
    public List<BoardResponseDto> ShowAll(){
        List<Board> boardList = boardRepository.findAll(Sort.by(Sort.Direction.DESC,"createdAt"));

        List<BoardResponseDto> boardResponseDtoList = new ArrayList<>();
        for (Board board:boardList) {
            BoardResponseDto boardResponseDto = new BoardResponseDto(board);
            boardResponseDtoList.add(boardResponseDto);
        }
        return boardResponseDtoList;
    }

    @GetMapping("/api/board/{id}") ////글 상세 페이지
    public String Showdetails(@PathVariable Long id){
        return boardService.brdDetail(id);
    }

    @PutMapping("/api/board/{id}")  //글 수정하기
    public String updateBoard(@PathVariable Long id,@RequestBody BoardEditDto boardEditDto){
        return boardService.update(id,boardEditDto);
    }

    @DeleteMapping("/api/board/{id}")   //글 삭제하기
    public String deleteBoard(@PathVariable Long id,@RequestBody BoardEditDto boardEditDto){
        return boardService.delete(id,boardEditDto);
    }
}
