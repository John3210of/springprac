//package com.sparta.week04.models.hide;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ProductTest {
//    @Test
//    @DisplayName("정상 케이스")
//    void createProduct_Normal() {
//// given
//        String title = "오리온 꼬북칩 초코츄러스맛 160g";
//        String image = "https://shopping-phinf.pstatic.net/main_2416122/24161228524.20200915151118.jpg";
//        String link = "https://search.shopping.naver.com/gate.nhn?id=24161228524";
//        int lprice = 2350;
//
//        ProductRequestDto requestDto = new ProductRequestDto(
//                title,
//                image,
//                link,
//                lprice
//        );
//
//// when 테스트는 이 부분을 하기 위한것이다.
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            new Product(requestDto);
//        });
//
//// then
//        assertEquals("상품 최저가가 0 이하입니다.", exception.getMessage());
//    }
//}