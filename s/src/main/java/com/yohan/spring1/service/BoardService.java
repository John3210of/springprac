package com.yohan.spring1.service;

import com.yohan.spring1.dto.BoardEditDto;
import com.yohan.spring1.dto.BoardRequestDto;
import com.yohan.spring1.model.Board;
import com.yohan.spring1.model.User;
import com.yohan.spring1.repository.BoardRepository;
import com.yohan.spring1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

//    @Transactional
//    public String Create(BoardRequestDto boardRequestDto){
//        Board board = new Board(boardRequestDto);
//        boardRepository.save(board);
//        //요기부터 새로작성
//        return "글작성 완료";
//    }

    //연관관계 매핑 관련
    @Transactional
    public String Save1(BoardRequestDto boardRequestDto){
        User user = userRepository.findUserByUsername(boardRequestDto.getUsername());
        Board board = new Board(boardRequestDto);
        board.setUser(user);
        boardRepository.save(board);
        return "글작 성 완 1 료";
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
