package com.yohan.spring1.repository;

import com.yohan.spring1.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LikesRepository extends JpaRepository<Likes,Long> {

    boolean existsByBoard_IdAndAndUser_Id(Long boardid, Long userid);
    Likes findByBoard_IdAndAndUser_Id(Long boardid, Long userid);
    List<Likes> findLikesByBoard_Id(Long boardid);

}
