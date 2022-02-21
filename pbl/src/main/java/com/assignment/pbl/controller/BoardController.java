package com.assignment.pbl.controller;

import com.assignment.pbl.dto.BoardRequestDto;
import com.assignment.pbl.model.Board;
import com.assignment.pbl.repository.BoardRepository;
import com.assignment.pbl.repository.UserRepository;
import com.assignment.pbl.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;


//    private final UserRepository userRepository;

    @GetMapping("/api/board")   //1.전체 게시글 목록 조회
    public List<Board> getBoards() {
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }


    @PostMapping("/api/board")  //2.게시글 작성
    public Board createBoard(@RequestBody BoardRequestDto requestDto, Authentication authentication) { //
        Board board = new Board(requestDto);
        String username = authentication.getName();
        return boardService.save(username, board);
    }

//        String username = authentication.getName();
//        return boardRepository.save(board);
//        String msg = "msg : success \n + boardid: ";
//        Long bodnum = board.getId();
//        return msg+bodnum;



    @GetMapping("/api/board/{id}")   //3. 원하는 게시물 보기
    public Optional<Board> getBoard(@PathVariable Long id) {

        return boardRepository.findById(id);
    }

    @PutMapping("/api/board/{id}")  //4.게시글 수정
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        boardService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/board/{id}")   //5.게시글 삭제
    public Long deleteBoard(@PathVariable Long id) {
        boardRepository.deleteById(id);
        return id;
    }

}