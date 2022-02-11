package com.sparta.week01.prac;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.ArrayList;
import java.util.List;

//    public 반환타입 메소드명(요소){
//        명령 작성
//        return 결과값 (필요할 경우)
//    }
//
public class Prac { //클래스
    // public, static void 에 대해서는 곧 배웁니다! 우선은 넘어갈게요.
//    public static int minus(int num1,int num2) {    //메소드 (항상 클래스 안에 들어 있다.)
//        return num1-num2;
//    }


    public static void main(String[] args) {
        String title = "스프링이에욤";
        String tutor = "병관이형";
        int days = 35;
        Course course = new Course();
        course.setTitle(title);
        course.setTutor(tutor);
        course.setDays(days);
        System.out.println(course.getTitle());
        System.out.println(course.getTutor());
        System.out.println(course.getDays());
    }


}

