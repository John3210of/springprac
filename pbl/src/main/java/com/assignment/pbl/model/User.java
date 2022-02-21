package com.assignment.pbl.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User extends Timestamped{
    //id , email , nickname , 시간들
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id //pk값으로 쓰겠다
    @Column(name = "userid")
    private Long id;

    @Column(nullable = false,unique = true)   //이메일
    private String email;

    @Column(nullable = false,unique = true)   //유저이름
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String passwordCheck;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    private List<Board> BoardList = new ArrayList<>();

    public User(String username, String password,String passwordCheck, String email) {
        this.username = username;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.email = email;

    }
}
