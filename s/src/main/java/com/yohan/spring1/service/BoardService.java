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
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Objects;


@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    //연관관계 매핑 관련
    @Transactional  //글작성
    public String Save1(BoardRequestDto boardRequestDto) {
        JSONObject obj = new JSONObject();
        if (false) {
            //여기서 조건에 헤즈롤 갈겨
            obj.put("result", "False");
            obj.put("msg", "로그인이 필요합니다.");
            return (obj.toString());
        } else {
            User user = userRepository.findUserByUsername(boardRequestDto.getUsername());
            Board board = new Board(boardRequestDto);
            board.setUser(user);
            boardRepository.save(board);
            Long boardid = board.getId();
            obj.put("result", "success");
            obj.put("msg","응애 만들어줘");
            obj.put("boardId", boardid);
            return obj.toString();
        }
    }

    @Transactional  //상세페이지
    public String brdDetail(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        BoardResponseDto boardResponseDto = new BoardResponseDto(board);
        JSONObject obj = new JSONObject();
        obj.put("result", "success");
        obj.put("msg", "게시글 조회 성공");
        JSONObject dto = new JSONObject(boardResponseDto);   //무야호 ㅋㅋㅋ 해냈다
        System.out.println(dto);
        obj.append("boardResponseDto", dto);     //얘는 어팬드 해야됨
        return obj.toString();
    }

    @Transactional  //글 수정
    public String update(Long id, BoardEditDto boardEditDto) {
        JSONObject obj = new JSONObject();
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        if (boardEditDto.getUsername() != board.getUsername()) {
            obj.put("result", "fail");
            obj.put("msg", "글 작성자가 아니에용 ");
            return obj.toString();
        }
        board.update(boardEditDto);
        obj.put("result", "success");
        obj.put("msg", "글 수정 완료");
        return obj.toString();
    }

    @Transactional  //글 삭제
    public String delete(Long id,@RequestBody BoardEditDto boardEditDto) {
        JSONObject objt = new JSONObject();
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );

        if (!Objects.equals(boardEditDto.getUsername(), board.getUsername())) {
            objt.put("result", "fail");
            objt.put("msg", "글 작성자가 아니용 ");
            return objt.toString();
        }

        boardRepository.deleteById(id);
        objt.put("result", "success");
        objt.put("msg", "글 삭제 완료");
        objt.put("boardId",id);
        return objt.toString();
    }

}
