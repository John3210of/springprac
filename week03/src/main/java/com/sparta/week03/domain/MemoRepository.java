package com.sparta.week03.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

//public interface MemoRepository extends JpaRepository<Memo, Long> {
//    List<Memo> findAllByOrderByModifiedAtDesc();
//}
public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start, LocalDateTime end);
}
//interface파일은 클래스에서 멤버 변수가 없는 메소드만 있는것
//test3