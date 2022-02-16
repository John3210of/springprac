package com.assignment.myblog.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddtextRepository extends JpaRepository<Addtext, Long> {

//    List<Addtext> findAllByOrderByModifiedAtDesc();

    List<Addtext> findAllByPostid(Long postid); //이렇게만 해도 알아서 시간내림차순으로 되는듯?
}