package com.yohan.spring1.repository;

import com.yohan.spring1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
