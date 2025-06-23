package com.clean.user_app.domain.order.service;

import com.clean.user_app.domain.order.controller.model.OrderRequest;
import com.clean.user_app.domain.order.service.command.OrderCommand;
import jakarta.servlet.http.HttpSession;

/**
 * description    : 영화 주문 서비스 인터페이스
 * packageName    : com.clean.user_app.domain.order.service
 * fileName       : OrderService
 * author         : 김현주
 * date           : 25. 6. 22.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 22.        김현주             최초 생성
 */
public interface OrderService {
    OrderCommand regOrder(OrderRequest orderRequest, HttpSession session);
}
