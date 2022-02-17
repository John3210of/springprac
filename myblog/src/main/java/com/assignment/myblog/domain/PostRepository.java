package com.assignment.myblog.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAll();

    @Query("SELECT p FROM Post p ORDER BY p.createdAt DESC ")
    List<PostsMapping> findAllabcd();


}