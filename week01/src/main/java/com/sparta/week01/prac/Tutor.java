package com.sparta.week01.prac;

public class Tutor {
    // 멤버 변수. 보통 private으로 선언을 한다.
    private String name;
    private String bio;


    // 생성자
    public Tutor(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

    // Getter
    public String getName() {
        return this.name;
    }
    public String getBio() {
        return this.bio;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }

    public static void main(String[] args) {
        System.out.println("hello 에용");
        Tutor test = new Tutor("hey","you");

        test.setBio("spring");
        System.out.println((test.getName()));
        System.out.println((test.getBio()));


    }
}
