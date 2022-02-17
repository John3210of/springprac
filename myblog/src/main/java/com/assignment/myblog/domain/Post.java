package com.assignment.myblog.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Post extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "post_id")
    private Long id;

    @Column(nullable = false)   //유저이름
    private String username;

    @Column(nullable = false)   //글제목
    private String postname;

    @Column(nullable = false)   //글내용
    private String contents;


    public Post(PostRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.postname = requestDto.getPostname();
        this.contents = requestDto.getContents();
    }

    public void update(PostRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.postname = requestDto.getPostname();
        this.contents = requestDto.getContents();
    }


}


//일대다매핑
//    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
//    private List<Addtext> addtext = new ArrayList<Addtext>();
//
//    public void addAddtext(Addtext addtext) {
//        addtext.setPost(this);
//    }