package com.assignment.pbl.service;


import com.assignment.pbl.dto.BoardRequestDto;
import com.assignment.pbl.model.Board;
import com.assignment.pbl.model.User;
import com.assignment.pbl.repository.BoardRepository;
import com.assignment.pbl.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor    //생성자 자동으로 넣어줘
@Service    //서비스임을 선언
public class BoardService {

    private BoardRepository boardRepository;
    private UserRepository userRepository;

    public Board save(String username,Board board){
        User user = userRepository.findUserByUsername(username);
        board.setUser(user);
        return boardRepository.save(board);
    }

    @Transactional  //db에 반영이 되야한다를 알려주는것
    public Long update(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        board.update(requestDto);
        return board.getId();
    }

}
