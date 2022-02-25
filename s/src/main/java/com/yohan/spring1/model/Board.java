package com.yohan.spring1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yohan.spring1.dto.BoardEditDto;
import com.yohan.spring1.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String username;

    @Column
    private int likeCount;

    @JsonBackReference  //순환참조 방지. 자식 클래스   //mappedby => 관계의 주인은 이쪽이 아니다.
    @OneToMany(mappedBy = "board",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Likes> LikeList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "userid",nullable = false)
    @JsonManagedReference       //순환참조방지. 부모클래스
    private User user;

    public void plusLikeCount(){ this.likeCount += 1; }
    public void minusLikeCount(){
        this.likeCount -= 1;
    }

    public void setUser(User user){ //연관관계 정의 메소드
        if (this.user != null) { // 기존에 이미 존재한다면
            this.user.getBoardList().remove(this); // 관계를 끊는다.
        }
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
