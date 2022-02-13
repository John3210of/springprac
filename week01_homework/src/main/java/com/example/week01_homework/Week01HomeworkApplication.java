package com.example.week01_homework;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Week01HomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week01HomeworkApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonRepository personRepository) {
        return (args) -> {
            personRepository.save(new Person("연습이에용", "백수",19));

            System.out.println("데이터 인쇄");
            List<Person> personList = personRepository.findAll();
            for (int i=0; i<personList.size(); i++) {
                Person person = personList.get(i);
                System.out.println(person.getId());
                System.out.println(person.getName());
            }

        };
    }
}
