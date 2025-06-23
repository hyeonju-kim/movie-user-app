package com.clean.user_app.domain.order.service.serviceImpl;

import com.clean.user_app.domain.movie.entity.Movie;
import com.clean.user_app.domain.movie.repository.MovieRepository;
import com.clean.user_app.domain.order.controller.model.OrderRequest;
import com.clean.user_app.domain.order.entity.Order;
import com.clean.user_app.domain.order.repository.OrderRepository;
import com.clean.user_app.domain.order.service.OrderService;
import com.clean.user_app.domain.order.service.command.OrderCommand;
import com.clean.user_app.domain.user.entity.User;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * description    : 영화 주문 서비스 구현체
 * packageName    : com.clean.user_app.domain.order.service.serviceImpl
 * fileName       : OrderServiceImpl
 * author         : 김현주
 * date           : 25. 6. 22.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 22.        김현주             최초 생성
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final MovieRepository movieRepository;

    @Override
    public OrderCommand regOrder(OrderRequest orderRequest, HttpSession session) {
        OrderCommand orderCommand = OrderCommand.of(orderRequest);

        User user = (User) session.getAttribute("loginUser"); // 세션에서 유저 꺼내기
        Movie movie = movieRepository.findById(orderCommand.getMovieId())
                .orElseThrow(() -> new IllegalArgumentException("영화 정보가 존재하지 않습니다.")); // 영화 조회

        // 주문 생성
        Order order = Order.create(user, movie, orderCommand.getScheduleId(), orderCommand.getSeatNumber());
        orderRepository.save(order);

        return OrderCommand.of(order);
    }
}
