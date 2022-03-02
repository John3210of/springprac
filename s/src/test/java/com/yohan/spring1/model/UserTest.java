package com.yohan.spring1.model;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class UserTest {
    @Test
    public void usercreate(){
        //given
        String email="asd@asd.com";
        String username="username";
        String password="password";
        String passwordCheck="password";
    }

    //when


    //then

}