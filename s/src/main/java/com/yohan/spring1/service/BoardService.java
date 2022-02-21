package com.yohan.spring1.service;

import com.yohan.spring1.dto.BoardEditDto;
import com.yohan.spring1.dto.BoardRequestDto;
import com.yohan.spring1.model.Board;
import com.yohan.spring1.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public String Create(BoardRequestDto boardRequestDto){
        Board board = new Board(boardRequestDto);
        boardRepository.save(board);
        return "글작성 완료";
    }

    @Transactional
    public Long update(Long id, BoardEditDto boardEditDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        board.update(boardEditDto);
        return board.getId();
    }
    @Transactional
    public Long delete(Long id){
        boardRepository.deleteById(id);
        return id;
    }

}
