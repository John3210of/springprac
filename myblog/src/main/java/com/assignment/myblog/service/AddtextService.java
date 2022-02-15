package com.assignment.myblog.service;

import com.assignment.myblog.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor    //생성자 자동으로 넣어줘
@Service
public class AddtextService {

    private final AddtextRepository addtextRepository;


    @Transactional  //db에 반영이 되야한다를 알려주는것
    public Long modify(Long id, AddtextRequestDto requestDto) {
        Addtext addtext = addtextRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        addtext.modify(requestDto);
        return addtext.getId();
    }
}