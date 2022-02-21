package com.assignment.pbl.model;

import com.assignment.pbl.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //get 함수를 일괄적으로 만들어줌
@NoArgsConstructor // 기본 생성자를 만들어줌
@Entity // DB 테이블 역할
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userid", nullable = false)
    private User user;

    public void setUser(User user){
        if(this.user != null){
            this.user.getBoardList().remove(this);
        }

        this.user = user;       //연관관계 편의 메소드
        user.getBoardList().add(this);
    }

    public Board(BoardRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.grid = requestDto.getGrid();
        this.imageUrl = requestDto.getImageUrl();
        this.content = requestDto.getContent();
    }

    public void update(BoardRequestDto requestDto) {
        this.grid = requestDto.getGrid();
        this.imageUrl = requestDto.getImageUrl();
        this.content = requestDto.getContent();
    }


}
