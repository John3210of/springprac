package com.sparta.week02.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

//  jpa는 인터페이스에서만 사용할 수 있다.
//  클래스에서 멤버가 빠진, 메소드 모음집이다.