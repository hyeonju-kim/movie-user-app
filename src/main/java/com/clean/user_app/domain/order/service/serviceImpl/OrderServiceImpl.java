package com.clean.user_app.domain.order.service.serviceImpl;

import com.clean.user_app.domain.movie.entity.Movie;
import com.clean.user_app.domain.movie.repository.MovieRepository;
import com.clean.user_app.domain.order.entity.Order;
import com.clean.user_app.domain.order.repository.OrderRepository;
import com.clean.user_app.domain.order.service.OrderService;
import com.clean.user_app.domain.user.entity.User;
import com.clean.user_app.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    private final UserRepository userRepository;

    @Override
    public Order createOrder() {
        // 유저
        final User user = new User();
        user.setUsername("khj2");
        user.setPassword("1234");
        userRepository.save(user);

        // 영화
        Optional<Movie> movie = movieRepository.findById(1L);

        // 저장
        final Order order = Order.create(user, movie.get(), 1234L, "b7");
        log.info("[createOrder] > [order] === {}", order);

        orderRepository.save(order);

        return order;
    }
}
