package com.assignment.pbl.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    //메인페이지
    @GetMapping("/")
    public String home(){
        return "index";
    }
}
