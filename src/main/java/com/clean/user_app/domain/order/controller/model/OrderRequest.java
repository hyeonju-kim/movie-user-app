package com.clean.user_app.domain.order.controller.model;

import com.clean.user_app.domain.movie.entity.Movie;
import com.clean.user_app.domain.user.repository.dto.UserDto;
import lombok.Data;

/**
 * description    : 영화 주문 요청 DTO
 * packageName    : com.clean.user_app.domain.order.controller.model
 * fileName       : OrderRequest
 * author         : 김현주
 * date           : 25. 6. 22.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 22.        김현주             최초 생성
 */
@Data
public class OrderRequest {
    private UserDto userDto;
    private Movie movie;
    private Long scheduleId;
    private String seatNumber;
}
