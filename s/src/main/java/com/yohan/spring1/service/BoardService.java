package com.yohan.spring1.service;

import com.yohan.spring1.dto.BoardEditDto;
import com.yohan.spring1.dto.BoardRequestDto;
import com.yohan.spring1.dto.BoardResponseDto;
import com.yohan.spring1.model.Board;
import com.yohan.spring1.model.User;
import com.yohan.spring1.repository.BoardRepository;
import com.yohan.spring1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;


    //연관관계 매핑 관련
    @Transactional  //글작성
    public String Save1(BoardRequestDto boardRequestDto){
        User user = userRepository.findUserByUsername(boardRequestDto.getUsername());
        Board board = new Board(boardRequestDto);
        board.setUser(user);
        boardRepository.save(board);
        Long boardid=board.getId();
        JSONObject obj = new JSONObject();
        obj.put("result", "success");
        obj.put("boardid",boardid);
        return obj.toString();
    }

    @Transactional  //상세페이지
    public String brdDetail(Long id){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        BoardResponseDto boardResponseDto = new BoardResponseDto(board);
        JSONObject obj = new JSONObject();
        obj.put("result", "success");
        obj.put("msg","글 작성 완료");
        JSONObject dto= new JSONObject(boardResponseDto);   //무야호 ㅋㅋㅋ 해냈다
        obj.append("data",dto);
        return obj.toString();
    }

    @Transactional  //글 수정
    public String update(Long id, BoardEditDto boardEditDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        board.update(boardEditDto);
        JSONObject obj = new JSONObject();
        obj.put("result", "success");
        obj.put("msg","글 수정 완료");
        return obj.toString();
    }

    @Transactional  //글 삭제
    public String delete(Long id){
        boardRepository.deleteById(id);
        JSONObject obj = new JSONObject();
        obj.put("result", "success");
        obj.put("msg","글 삭제 완료");
        return obj.toString();
    }

}
