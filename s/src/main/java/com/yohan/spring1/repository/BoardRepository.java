package com.yohan.spring1.repository;

import com.yohan.spring1.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<Board> findByUsername(String username);
}
