package com.yohan.spring1.model;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;




class UserTest {
    //given
    @Test
    @DisplayName("정상")
    void Signup() {
        String email = "asd@asdf";
        String username = "asdfg";
        String password = "12341234";
        String passwordCheck = "12341234";


        //when

        User user = new User();

        //then

    }
}