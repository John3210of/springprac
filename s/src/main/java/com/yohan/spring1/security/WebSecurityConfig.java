package com.yohan.spring1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin().disable()
                .headers().frameOptions().disable();
    }
}




//package com.yohan.spring1.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration  // 서버가 기동되는 순간 설정을 해주겠다.
//@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
////WebSecurityConfigurerAdapter를 상속받아서 클래스를 생성해준다
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Bean
//    public BCryptPasswordEncoder encodePassword() {
//        return new BCryptPasswordEncoder();
//    }
//
//    //인증 및 인가에 대한 기본 설정이 있고 우리는 override를 통해서 필요한 부분만 커스텀 할것이다.
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // 회원 관리 처리 API (POST /user/**) 에 대해 CSRF 무시
//        //모르면 외워라
//        http.csrf()
//                .ignoringAntMatchers("/api/**");
//
//        http.authorizeRequests()
//                // image 폴더를 login 없이 허용
//                .antMatchers("/images/**").permitAll()
//                // css 폴더를 login 없이 허용
//                .antMatchers("/css/**").permitAll()
//                // 회원 관리 처리 API 전부를 login 없이 허용
//                .antMatchers("/api/**").permitAll()
//                // 어떤 요청이든 '인증' login에도 인증을 해달라고 할수는 없으니 허용 요청을 해야함
//                .anyRequest().authenticated()    // 인증필요할때 여기열어줘
//                .and()
//                // 로그인 기능
//                .formLogin()
//                // 로그인 View 제공 (GET /user/login)
//                .loginPage("/api/login")
////                .successHandler()
//                // 로그인 처리 (POST /user/login)
//                .loginProcessingUrl("/api/login")
//                // 로그인 처리 후 성공 시 URL
//                .defaultSuccessUrl("/")
////                .failureHandler()
//                // 로그인 처리 후 실패 시 URL
//                .failureUrl("/api/login?error")
//                .permitAll()
//                .and()
//                // 로그아웃 기능
//                .logout()
//                .logoutUrl("/api/logout")
//                .permitAll();
//    }
//}