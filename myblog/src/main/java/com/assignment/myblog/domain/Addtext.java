package com.assignment.myblog.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Addtext extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Long id;

    @Column(nullable = false)
    private Long postid;

    @Column(nullable = false)
    private String username;

    @Column
    private String contents;


//일대다매핑
//    @ManyToOne
//    @JoinColumn(name="post_id")
//    private Post post;
//
//    public void setPost(Post post){
//        this.post = post;
//    }


    public Addtext(AddtextRequestDto requestDto) {
        this.postid = requestDto.getPostid();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void modify(AddtextRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

}
