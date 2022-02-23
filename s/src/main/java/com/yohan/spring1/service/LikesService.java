package com.yohan.spring1.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikesService {

    @Transactional
    public String upLikes(Long boardid){

        return "asdf";
    }

    @Transactional
    public String downLikes(Long boardid){

        return "asdf";
    }
}
