package com.example.week01_homework;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter         // lombok
@Setter
@RequiredArgsConstructor
public class PersonRequestDto {
    //DTO(Data Transfer Object)
    private final String name;
    private final String job;
    private final int age;
}

