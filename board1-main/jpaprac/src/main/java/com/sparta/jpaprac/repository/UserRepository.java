package com.sparta.jpaprac.repository;

import com.sparta.jpaprac.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}