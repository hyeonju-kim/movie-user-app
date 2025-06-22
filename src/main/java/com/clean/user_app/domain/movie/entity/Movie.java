package com.clean.user_app.domain.movie.entity;

import com.clean.user_app.domain.movie.service.command.MovieCommand;
import com.clean.user_app.domain.order.entity.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * description    : 영화 Entity
 * packageName    : com.clean.user_app.entity
 * fileName       : Movie
 * author         : 김현주
 * date           : 25. 6. 19.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 19.        김현주             최초 생성
 */
@Entity
@Getter
@Setter
@ToString
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String movieCd;           // 영화 코드 (PK)
    private String movieNm;           // 영화명
    private String rank;              // 박스오피스 순위
    private String rankInten;         // 순위 증감
    private String openDt;            // 개봉일
    private String salesAmt;          // 당일 매출
    private String audiCnt;           // 당일 관객수
    private String audiAcc;           // 누적 관객수
    private String scrnCnt;           // 스크린 수
    private String showCnt;           // 상영 횟수
    private String price;             // 가격
    private String manufacturedBy;    // 생산 국가

    // mappedBy는 외래키의 주도권이 상대방에 있음을 나타냄 -> "난 그냥 보여주기용이고, 진짜 저장·수정은 Order 쪽이 해~" 이런 뜻
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL) // movie는 Order 엔티티에 있는 movie 필드
    @JsonIgnore // 단방향 출력으로 제어 (JSON 직렬화에서 제외하여 무한루프 방지)
    private List<Order> orders = new ArrayList<>();


    public static Movie of(MovieCommand movieCommand) {
        Movie movie = new Movie();
        movie.setMovieNm(movieCommand.getMovieNm());
        movie.setMovieCd(movieCommand.getMovieCd());
        movie.setRank(movieCommand.getRank());
        movie.setRankInten(movieCommand.getRankInten());
        movie.setOpenDt(movieCommand.getOpenDt());
        movie.setAudiAcc(movieCommand.getAudiAcc());
        movie.setScrnCnt(movieCommand.getScrnCnt());
        movie.setShowCnt(movieCommand.getShowCnt());
        movie.setSalesAmt(movieCommand.getSalesAmt());
        movie.setAudiCnt(movieCommand.getAudiCnt());
        movie.setManufacturedBy("kor");
        movie.setPrice("12000");
        return movie;
    }
}