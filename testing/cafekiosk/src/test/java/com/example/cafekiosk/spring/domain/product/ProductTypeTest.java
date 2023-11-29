package com.example.cafekiosk.spring.domain.product;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.cafekiosk.spring.domain.product.ProductType.BAKERY;
import static com.example.cafekiosk.spring.domain.product.ProductType.HANDMADE;
import static org.assertj.core.api.Assertions.*;

class ProductTypeTest {

    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다")
    @Test
    void containsStockType1(){
        //given
        ProductType givenType = BAKERY;

        //when
        boolean result = ProductType.containsStockType(givenType);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다")
    @Test
    void containsStockType2(){
        //given
        ProductType givenType = HANDMADE;

        //when
        boolean result = ProductType.containsStockType(givenType);

        //then
        assertThat(result).isFalse();
    }
}