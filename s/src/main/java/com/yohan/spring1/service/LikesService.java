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

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class LikesService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final LikesRepository likesRepository;

    @Transactional
    public String upLikes(Long boardid,LikesRequestDto likesrequestDto, HttpServletRequest request){
        User user = userRepository.findUserById(likesrequestDto.getUserid());
        Board board = boardRepository.findBoardById(boardid);
        Likes likes = new Likes();
        likes.setBoard(board);
        likes.setUser(user);
        likesRepository.save(likes);

//        JSONObject obj = new JSONObject();
        return "좋아용";
    }

    @Transactional
    public String downLikes(Long boardid,HttpServletRequest request){

        return "asdf";
    }
}
