package com.example.week01_homework;

public class Person {
    private String name;
    private String job;
    private int ages;

    public Person() {

    }

    public Person(String name, String job, int ages) {
        this.name = name;
        this.job = job;
        this.ages = ages;
    }

    public String getName() {
        return this.name;
    }
    public String getJob() {
        return this.job;
    }
    public int getAges() {
        return this.ages;
    }       //얘네가 없으면 못불러오넹 신기하다

    public void setName(String name) {
        this.name = name;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public void setAges(int ages) {
        this.ages = ages;
    }
}
