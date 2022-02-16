package com.assignment.myblog.controller;

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

    @GetMapping("/api/posts")   //1.전체 게시글 목록 조회 여기선 contents 안보이게 해야됨
    public List<Post> getPosts() {

        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    @PostMapping("/api/posts")  //2.게시글 작성
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    @GetMapping("/api/posts/{id}")   //3. 원하는 게시물 보기 여기선 contents 보여야됨
    public Optional<Post> getPost(@PathVariable Long id) {

        return postRepository.findById(id);
    }

    @PutMapping("/api/posts/{id}")  //4.게시글 수정
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        postService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/posts/{id}")   //5.게시글 삭제 댓글도 같이 날려야하는데
    public Long deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
//        addtextRepository.deleteByPostid(id);
        return id;
    }


}