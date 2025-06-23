package com.clean.user_app.domain.order.controller.model;

import lombok.Getter;
import lombok.Setter;

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
@Getter
@Setter
public class OrderRequest {
    private Long movieId;
    private Long scheduleId;
    private String seatNumber;
}
