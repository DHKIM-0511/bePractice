package com.example.cafekiosk.spring.api.service.order;

import static com.example.cafekiosk.spring.domain.order.OrderStatus.PAYMENT_COMPLETED;
import static com.example.cafekiosk.spring.domain.product.ProductSellingStatus.SELLING;
import static com.example.cafekiosk.spring.domain.product.ProductType.HANDMADE;
import static org.junit.jupiter.api.Assertions.*;

import com.example.cafekiosk.spring.domain.order.Order;
import com.example.cafekiosk.spring.domain.order.OrderRepository;
import com.example.cafekiosk.spring.domain.order.OrderStatus;
import com.example.cafekiosk.spring.domain.product.Product;
import com.example.cafekiosk.spring.domain.product.ProductRepository;
import com.example.cafekiosk.spring.domain.product.ProductType;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderStatisticsServiceTest {

    @Autowired
    OrderStatisticsService orderStatisticsService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @AfterEach
    void tearDown() {
        orderRepository.deleteAllInBatch();
        productRepository.deleteAllInBatch();
    }

    @DisplayName("결제완료 주문들을 조회하여 매출 통계 메일을 전송한다.")
    @Test
    void sendOrderStatisticsMail(){
        //given
        LocalDateTime now =LocalDateTime.of(2023, 11, 30, 12,0);
        Product product1 = createProduct(HANDMADE, "001", 1000);
        Product product2 = createProduct(HANDMADE, "002", 2000);
        Product product3 = createProduct(HANDMADE, "003", 5000);
        
        List<Product> products = List.of(product1, product2, product3);
        productRepository.saveAll(products);

        //when
        completedPaymentCompletedOrder(now, products);

        //then
    }

    private void completedPaymentCompletedOrder(LocalDateTime now, List<Product> products) {
        Order order1 = Order.builder()
            .products(products)
            .orderStatus(PAYMENT_COMPLETED)
            .registeredDateTime(now)
            .build();
        orderRepository.save(order1);
    }

    private Product createProduct(ProductType type, String productNumber, int price){
        return Product.builder()
            .type(type)
            .productNumber(productNumber)
            .price(price)
            .sellingStatus(SELLING)
            .name("메뉴 이름")
            .build();
    }
}