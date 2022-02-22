package com.yohan.spring1.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yohan.spring1.dto.BoardEditDto;
import com.yohan.spring1.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Board extends Timestamped {
    //id title content username time1,2 이 요구된다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id //pk값으로 쓰겠다
    @Column(name = "boardid")
    private Long id;

    @Column(nullable = false)
    private String grid;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)   //글내용
    private String content;

    @Column(nullable = false)
    private String username;

    @ManyToOne
    @JoinColumn(name = "userid",nullable = false)
    @JsonManagedReference       //순환참조방지. 부모클래스
    private User user;

    public void setUser(User user){
        this.user = user;
        user.getBoardList().add(this);
    }

    public Board(BoardRequestDto boardrequestDto){
        this.username = boardrequestDto.getUsername();
        this.grid = boardrequestDto.getGrid();
        this.imageUrl = boardrequestDto.getImageUrl();
        this.content = boardrequestDto.getContent();
    }

    public void update(BoardEditDto boardEditDto){
        this.imageUrl=boardEditDto.getImageUrl();
        this.grid=boardEditDto.getGrid();
        this.content=boardEditDto.getContent();
    }
}
