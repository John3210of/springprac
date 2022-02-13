package com.example.week01_homework;

import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Person extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String job;
    @Column(nullable = false)
    private int age;

    public Person(PersonRequestDto requestDto){
        this.name=requestDto.getName();
        this.job=requestDto.getJob();
        this.age=requestDto.getAge();
    }

    public Person(String name, String job,int age){
        this.name=name;
        this.job=job;
        this.age=age;
    }

    public void update(PersonRequestDto requestDto){
        this.name=requestDto.getName();
        this.job=requestDto.getJob();
        this.age=requestDto.getAge();
    }

}
