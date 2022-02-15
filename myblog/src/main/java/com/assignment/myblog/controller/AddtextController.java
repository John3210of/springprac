package com.assignment.myblog.controller;

import com.assignment.myblog.domain.Addtext;
import com.assignment.myblog.domain.AddtextRepository;
import com.assignment.myblog.domain.AddtextRequestDto;
import com.assignment.myblog.service.AddtextService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AddtextController {

    private final AddtextRepository addtextRepository;
    private final AddtextService addtextService;

    @PostMapping("/api/addtexts")   //7. 댓글작성 , 비웠을때 예외처리 해야함
    public Addtext createAddtext(@RequestBody AddtextRequestDto requestDto) {
        Addtext addtext = new Addtext(requestDto);
        return addtextRepository.save(addtext);
    }

    @GetMapping("/api/addtexts") //6.댓글 목록 조회. postid로 넣어주기 해야함
    public List<Addtext> getAddtexts() {
        return addtextRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/api/addtexts/{id}")    //9.댓글삭제
    public Long deleteAddtext(@PathVariable Long id) {
        addtextRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/addtexts/{id}")   //8.댓글수정 , 비웠을때 예외처리 해야함
    public Long updateAddtext(@PathVariable Long id, @RequestBody AddtextRequestDto requestDto) {
        addtextService.modify(id, requestDto);
        return id;
    }
}