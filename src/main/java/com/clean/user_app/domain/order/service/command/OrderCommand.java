package com.clean.user_app.domain.order.service.command;

import com.clean.user_app.domain.movie.entity.Movie;
import com.clean.user_app.domain.order.controller.model.OrderRequest;
import com.clean.user_app.domain.order.entity.Order;
import com.clean.user_app.domain.user.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * description    : 영화 주문 Command
 * packageName    : com.clean.user_app.domain.order.service.command
 * fileName       : OrderCommand
 * author         : 김현주
 * date           : 25. 6. 23.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 23.        김현주             최초 생성
 */
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderCommand {
    private User user;
    private Movie movie;
    private Long movieId;
    private Long scheduleId;
    private String seatNumber;

    public static OrderCommand of(OrderRequest orderRequest) {
        final OrderCommand orderCommand = new OrderCommand();
        orderCommand.setMovieId(orderRequest.getMovieId());
        orderCommand.setScheduleId(orderRequest.getScheduleId());
        orderCommand.setSeatNumber(orderRequest.getSeatNumber());
        return orderCommand;
    }

    public static OrderCommand of(Order order) {
        final OrderCommand orderCommand = new OrderCommand();
        orderCommand.setMovie(order.getMovie());
        orderCommand.setUser(order.getUser());
        orderCommand.setScheduleId(order.getScheduleId());
        orderCommand.setSeatNumber(order.getSeatNumber());
        return orderCommand;
    }
}
