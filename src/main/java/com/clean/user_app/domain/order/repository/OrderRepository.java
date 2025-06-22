package com.clean.user_app.domain.order.repository;

import com.clean.user_app.domain.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * description    : 주문 저장소
 * packageName    : com.clean.user_app.domain.order.repository
 * fileName       : OrderRepository
 * author         : 김현주
 * date           : 25. 6. 22.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 22.        김현주             최초 생성
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
