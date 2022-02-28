package com.yohan.spring1.model;

import com.yohan.spring1.repository.BoardRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class BoardTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    public void boardTest(){
        //given
        String username= "username4";
        String imageUrl="링크";
        String grid="그리드";
        String content="내용";
        Long id = 10L;

        //when
        Board board = Board.builder()
                .username(username)
                .imageUrl(imageUrl)
                .grid(grid)
                .content(content)
                .build();

        //then
        assertThat(board.getId()).isNotEqualTo(username);
        assertEquals(username,board.getUsername());
        assertEquals(imageUrl,board.getImageUrl());

    }

}


//    @BeforeEach
//    void sample(){
//
//    }
