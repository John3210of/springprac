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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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

    @GetMapping("/api/board/{id}")  //글 상세 페이지
    public Optional<Board> Showdetail(@PathVariable Long id){
        Optional<Board> board = boardRepository.findById(id);
        return board;
    }

    @GetMapping("/api/board/detail/{id}")
    public BoardResponseDto Showdetails(@PathVariable Long id){
        return boardService.brdDetail(id);
    }

    @PutMapping("/api/board/{id}")  //글 수정하기
    public String updateBoard(@PathVariable Long id,@RequestBody BoardEditDto boardEditDto){
        boardService.update(id,boardEditDto);
        return "수정 완료";
    }

    @DeleteMapping("/api/board/{id}")   //글 삭제하기
    public String deleteBoard(@PathVariable Long id){
        boardService.delete(id);
        return "삭제 완료";
    }
}
