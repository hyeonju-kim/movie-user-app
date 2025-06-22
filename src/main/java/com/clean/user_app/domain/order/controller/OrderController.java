package com.clean.user_app.domain.order.controller;

import com.clean.user_app.domain.order.entity.Order;
import com.clean.user_app.domain.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description    : 영화 주문 컨트롤러
 * packageName    : com.clean.user_app.domain.order.controller
 * fileName       : OrderController
 * author         : 김현주
 * date           : 25. 6. 22.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 22.        김현주             최초 생성
 */
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public Order createOrder() {
        final Order order = orderService.createOrder();
        return order;
    }
}
