package com.yohan.spring1.repository;

import com.yohan.spring1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUsername(String username);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByEmailAndPassword(String email, String password);
    User findUserById(Long userid);

}
