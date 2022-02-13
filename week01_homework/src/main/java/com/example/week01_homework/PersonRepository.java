package com.example.week01_homework;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    //Spring Data JPA는 "JpaRepository"라는 기능을 사용하면 매우 간단히 데이터를 검색 할 수 있도록 된다. 그 기본적인 사용법을 설명한다.
}
