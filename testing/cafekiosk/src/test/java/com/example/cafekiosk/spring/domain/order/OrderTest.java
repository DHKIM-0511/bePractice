package com.example.cafekiosk.spring.domain.order;

import static com.example.cafekiosk.spring.domain.product.ProductSellingStatus.SELLING;
import static com.example.cafekiosk.spring.domain.product.ProductType.*;

import com.example.cafekiosk.spring.domain.order.Order;
import com.example.cafekiosk.spring.domain.order.OrderStatus;
import com.example.cafekiosk.spring.domain.product.Product;
import com.example.cafekiosk.spring.domain.product.ProductType;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class OrderTest {

    @DisplayName("주문 생성 시 상품 리스트에서의 총 금액을 계산한다.")
    @Test
    void calculateTotalPrice(){
        //given
        LocalDateTime registeredDateTime = LocalDateTime.now();
        List<Product> products = List.of(
            createProduct("001", 1000),
            createProduct("002", 2000)
        );

        //when
        Order order = Order.create(products,registeredDateTime);

        //then
        assertThat(order.getTotalPrice()).isEqualTo(3000);
    }

    @DisplayName("주문 생성 시 주문 상태는 INIT 이다.")
    @Test
    void init(){
        //given
        LocalDateTime registeredDateTime = LocalDateTime.now();
        List<Product> products = List.of(
            createProduct("001", 1000),
            createProduct("002", 2000)
        );

        //when
        Order order = Order.create(products,registeredDateTime);

        //then
        assertThat(order.getOrderStatus()).isEqualByComparingTo(OrderStatus.INIT);
    }

    @DisplayName("주문 생성 시 주문 등록 시간을 기록한다.")
    @Test
    void registeredDateTime(){
        //given
        LocalDateTime registeredDateTime = LocalDateTime.now();
        List<Product> products = List.of(
            createProduct("001", 1000),
            createProduct("002", 2000)
        );

        //when
        Order order = Order.create(products,registeredDateTime);

        //then
        assertThat(order.getRegisteredDateTime()).isEqualTo(registeredDateTime);
    }
    private Product createProduct( String productNumber, int price){
        return Product.builder()
            .type(HANDMADE)
            .productNumber(productNumber)
            .price(price)
            .sellingStatus(SELLING)
            .name("메뉴 이름")
            .build();
    }
}