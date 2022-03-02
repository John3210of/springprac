package com.assignment.myblog.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface AddtextRepository extends JpaRepository<Addtext, Long> {

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)

    @Query("DELETE FROM Addtext c WHERE c.postid = ?1")
    void deleteAddtextByPostId(Long query);

    List<Addtext> findAllByPostid(Long postid);

}