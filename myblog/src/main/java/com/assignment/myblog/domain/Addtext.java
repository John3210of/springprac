package com.assignment.myblog.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Addtext extends Timestamped {
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

//일대다매핑
//    @ManyToOne
//    @JoinColumn(name="post_id")
//    private Post post;
//
//    public void setPost(Post post){
//        this.post = post;
//    }
