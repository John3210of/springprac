package com.assignment.myblog.service;

import com.assignment.myblog.domain.Post;
import com.assignment.myblog.domain.PostRepository;
import com.assignment.myblog.domain.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor    //생성자 자동으로 넣어줘
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional  //db에 반영이 되야한다를 알려주는것
    public Long update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        post.update(requestDto);
        return post.getId();
    }

}