package com.example.cafekiosk.spring.api.service.order;

import com.example.cafekiosk.spring.api.service.mail.MailService;
import com.example.cafekiosk.spring.domain.order.Order;
import com.example.cafekiosk.spring.domain.order.OrderRepository;
import com.example.cafekiosk.spring.domain.order.OrderStatus;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderStatisticsService {

    private final OrderRepository orderRepository;
    private final MailService mailService;

    public void  sendOrderStatisticsMail(LocalDate orderDate, String email){
        // 해당 일자에 완료된 주문을 가져옴
        List<Order> orders = orderRepository.findOrdersBy(
            orderDate.atStartOfDay(),
            orderDate.plusDays(1).atStartOfDay(),
            OrderStatus.PAYMENT_COMPLETED
        );
        //총 매출 계산
        int totalAmount = orders.stream()
            .mapToInt(Order::getTotalPrice)
            .sum();

        //메일 전송
        boolean result = mailService.sendMail(
            "no-reply@cafekiosk,com",
            email,
            String.format("[매출통계] %s", orderDate),
            String.format("총 매출 합계는 %s원 입니다.", totalAmount)
        );

        if(!result){
            throw new IllegalArgumentException("매출 통계 메일 전송에 실패했습니다.");
        }
    }

}
