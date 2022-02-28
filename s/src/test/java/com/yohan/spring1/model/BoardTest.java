package com.yohan.spring1.model;

import com.yohan.spring1.repository.BoardRepository;
import org.junit.After;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardTest {
    BoardRepository boardRepository;

    @After      //테스트 후 초기화 하기.
    public void clear(){
        boardRepository.deleteAll();
    }

    @Test
    public void 게시글_저장하기(){

    }

}