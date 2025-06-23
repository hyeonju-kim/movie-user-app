package com.clean.user_app.domain.order.entity;

import com.clean.user_app.domain.movie.entity.Movie;
import com.clean.user_app.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * description    : 영화 주문 Entity (Aggregate Root)
 * packageName    : com.clean.user_app.domain.purchase.entity
 * fileName       : Purchase
 * author         : 김현주
 * date           : 25. 6. 22.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 22.        김현주             최초 생성
 */
@Entity
@Table(name = "orders")
@Getter
@Slf4j
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 외부에서 기본 생성 못 하게 막기
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 연관관계 주인 (다대일)
    @ManyToOne(fetch = FetchType.LAZY) // @ManyToOne가 붙으면 얘가 주인이고 user_id라는 외래키를 갖게 된다. 그러므로 이쪽이 주인.
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    private Long scheduleId;

    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // REQUESTED, CANCELED, COMPLETED

    private String orderedAt;


    // 주문 생성
    public static Order create(User user, Movie movie, Long scheduleId, String seatNumber) {
        Order order = new Order();
        order.user = user;
        order.movie = movie;
        order.scheduleId = scheduleId;
        order.seatNumber = seatNumber;
        order.status = OrderStatus.REQUESTED;
        order.orderedAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.info("[create] > [order] === {}", order);
        return order;
    }

    // 결제 완료
    public void completePayment() {
        if (this.status != OrderStatus.REQUESTED) {
            throw new IllegalStateException("결제 가능한 상태가 아닙니다.");
        }
        this.status = OrderStatus.COMPLETED;
    }

    // 주문 취소
    public void cancel() {
        if (this.status == OrderStatus.COMPLETED) {
            throw new IllegalStateException("이미 결제 완료된 주문은 취소할 수 없습니다.");
        }
        this.status = OrderStatus.CANCELED;
    }


    public enum OrderStatus {
        REQUESTED,  // 예매 요청됨
        CANCELED,   // 취소됨
        COMPLETED   // 결제 완료됨
    }
}