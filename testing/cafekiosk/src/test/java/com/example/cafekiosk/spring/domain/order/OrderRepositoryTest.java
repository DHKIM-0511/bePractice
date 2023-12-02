package com.example.cafekiosk.spring.domain.order;

import static com.example.cafekiosk.spring.domain.order.OrderStatus.INIT;
import static com.example.cafekiosk.spring.domain.product.ProductSellingStatus.SELLING;
import static com.example.cafekiosk.spring.domain.product.ProductType.HANDMADE;
import static org.assertj.core.api.Assertions.*;

import com.example.cafekiosk.spring.domain.product.Product;
import com.example.cafekiosk.spring.domain.product.ProductRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@ActiveProfiles("test")
@SpringBootTest
@Transactional
class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @DisplayName("등록시간을 기준으로 주문 리스트를 조회 할 수 있다.")
    @Test
    void findOrdersBy(){
        //given
        LocalDateTime registeredDateTime = LocalDateTime.now();
        List<Product> products = List.of(
            createProduct("001", 1000),
            createProduct("002", 2000)
        );
        productRepository.saveAll(products);

        Order order1 = Order.create(products,registeredDateTime);
        Order order2 = Order.create(products,registeredDateTime.minusMinutes(3));
        Order order3 = Order.create(products,registeredDateTime.plusMinutes(3));
        orderRepository.saveAll(List.of(order1,order2,order3));

        //when
        List<Order> orders = orderRepository.findOrdersBy(registeredDateTime,
            registeredDateTime.plusMinutes(5), INIT);

        //then
        assertThat(orders).hasSize(2)
            .extracting("orderStatus", "totalPrice", "registeredDateTime", "orderProducts")
            .containsExactlyInAnyOrder(tuple(INIT, 3000, registeredDateTime,
                    new Tuple[]{
                        tuple(1,1),
                        tuple(HANDMADE, "002", 2000, SELLING, "메뉴 이름")
                    }
                ),
                tuple(INIT, 3000, registeredDateTime.plusMinutes(3),
                    new Tuple[]{
                        tuple(HANDMADE, "001", 1000, SELLING, "메뉴 이름"),
                        tuple(HANDMADE, "002", 2000, SELLING, "메뉴 이름")
                    }
                )
            );
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