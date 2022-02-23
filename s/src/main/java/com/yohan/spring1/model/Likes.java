package com.yohan.spring1.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yohan.spring1.dto.LikesRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Likes extends Timestamped{
    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="likesid")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userid",nullable = false)
    @JsonManagedReference       //순환참조방지. 부모클래스
    private User user;

    @ManyToOne
    @JoinColumn(name = "boardid",nullable = false)
    @JsonManagedReference       //순환참조방지. 부모클래스
    private Board board;

    public void setUser(User user){
        if (this.user != null) { // 기존에 이미 팀이 존재한다면
            this.user.getLikeList().remove(this); // 관계를 끊는다.
        }
        this.user = user;
        user.getLikeList().add(this);
    }

    public void setBoard(Board board){
        if (this.board != null) { // 기존에 이미 팀이 존재한다면
            this.board.getLikeList().remove(this); // 관계를 끊는다.
        }
        this.board = board;
        board.getLikeList().add(this);
    }
}
