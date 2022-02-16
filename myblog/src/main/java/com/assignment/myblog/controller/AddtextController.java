package com.assignment.myblog.controller;

import com.assignment.myblog.domain.*;
import com.assignment.myblog.service.AddtextService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class AddtextController {

    private final AddtextRepository addtextRepository;
    private final AddtextService addtextService;


    @PostMapping("/api/addtext")   //7. 댓글작성 , 비웠을때 예외처리 해야함
    public Addtext createAddtext( @RequestBody @Valid AddtextRequestDto requestDto) {
        Addtext addtext = new Addtext(requestDto);
        return addtextRepository.save(addtext);
    }

//    @PostMapping("/api/addtext/{postId}") 일대다매핑
//    public Addtext createAddtext(@PathVariable Long postId, @RequestBody AddtextRequestDto requestDto) {
//        Addtext addtext = addtextService.getAddtext(postId, requestDto);
//        return addtextRepository.save(addtext);
//    }

    @GetMapping("/api/addtext/postNum/{postid}") //6.원하는 게시글 댓글 목록 조회.
    public List<Addtext> getAddtext(@PathVariable Long postid) {
        return addtextRepository.findAllByPostid(postid);
    }

    @DeleteMapping("/api/addtext/{id}")    //9.댓글삭제
    public Long deleteAddtext(@PathVariable Long id) {
        addtextRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/addtext/{id}")   //8.댓글수정 , 비웠을때 예외처리 해야함
    public Long updateAddtext(@PathVariable Long id, @RequestBody @Valid AddtextRequestDto requestDto) {
        addtextService.modify(id, requestDto);
        return id;
    }
}