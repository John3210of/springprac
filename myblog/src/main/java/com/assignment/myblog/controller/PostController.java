package com.assignment.myblog.controller;

import com.assignment.myblog.domain.AddtextRepository;
import com.assignment.myblog.domain.Post;
import com.assignment.myblog.domain.PostRepository;
import com.assignment.myblog.domain.PostRequestDto;
import com.assignment.myblog.service.PostService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;
    private final AddtextRepository addtextRepository;


    @PostMapping("/api/posts")  //2.게시글 작성
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    @GetMapping("/api/posts")   //1.전체 게시글 목록 조회
    public List<Post> getPosts() {

        return postRepository.findAllByOrderByModifiedAtDesc();
    }


    @GetMapping("/api/posts/{id}")   //3. 원하는 게시물 보기 여기서 댓글도 볼 수 있어야함
    public Optional<Post> getPost(@PathVariable Long id) {

        return postRepository.findById(id);
    }

    @DeleteMapping("/api/posts/{id}")   //5.게시글 삭제
    public Long deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
//        addtextRepository.deleteByPostid(id);
        return id;
    }

    @PutMapping("/api/posts/{id}")  //4.게시글 수정
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        postService.update(id, requestDto);
        return id;
    }
}