package com.assignment.myblog.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id") 양방향 매핑시 재귀막는법
public class Post extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
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
//일대다매핑
//    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
//    private List<Addtext> addtext = new ArrayList<Addtext>();
//
//    public void addAddtext(Addtext addtext) {
//        addtext.setPost(this);
//    }

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
