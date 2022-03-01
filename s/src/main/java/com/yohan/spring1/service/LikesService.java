package com.yohan.spring1.service;

import com.yohan.spring1.dto.LikesRequestDto;
import com.yohan.spring1.model.Board;
import com.yohan.spring1.model.Likes;
import com.yohan.spring1.model.User;
import com.yohan.spring1.repository.BoardRepository;
import com.yohan.spring1.repository.LikesRepository;
import com.yohan.spring1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;


@Service
@RequiredArgsConstructor
public class LikesService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final LikesRepository likesRepository;

    @Transactional  //좋아요 누르기
    public String upLikes(Long boardid, @RequestBody LikesRequestDto likesrequestDto) {
        JSONObject obj = new JSONObject();
        Long useridChk = likesrequestDto.getUserId();
        boolean exists = likesRepository.existsByBoard_IdAndAndUser_Id(boardid, useridChk);

        if (!exists) {
            User user = userRepository.findUserById(likesrequestDto.getUserId());
            Board board = boardRepository.findBoardById(boardid);
            Likes likes = new Likes();
            likes.setBoard(board);
            likes.setUser(user);
            likesRepository.save(likes);
            board.plusLikeCount(); //카운트증가
            obj.put("result", "success");
            obj.put("msg", "좋아용");
            return (obj.toString());
        }

        obj.put("result", "False");     //여기서 바로 취소 해도 되는데 처음 api설계에서 따로 delete요청 해달라고 했음
        obj.put("msg", "이미 좋아요를 눌렀어용.");
        return (obj.toString());
    }

    @Transactional  //좋아요 취소 하기
    public String downLikes(Long boardid, @RequestBody LikesRequestDto likesrequestDto) {
        JSONObject obj = new JSONObject();
        Long useridChk = likesrequestDto.getUserId();
        boolean exists = likesRepository.existsByBoard_IdAndAndUser_Id(boardid, useridChk);

        if (exists) {

            Likes likes = likesRepository.findByBoard_IdAndAndUser_Id(boardid, useridChk);
            likesRepository.deleteById(likes.getId());
            Board board = boardRepository.findBoardById(boardid);
            board.minusLikeCount();
            obj.put("result", "success");
            obj.put("msg", "좋아요 취소했어용");
            return (obj.toString());

        }
        obj.put("result", "False");
        obj.put("msg", "좋아요 한적이 없음");
        return (obj.toString());
    }
}

