package com.example.week01_homework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/myinfo") //응애 json으로 해줘
    public Person getMyinfo() {
        Person person = new Person();
        person.setName("전데용");
        person.setAges(19);
        person.setJob("백엔드개발자");
        return person;
    }
}