package com.clean.user_app.domain.movie.controller.model;

import com.clean.user_app.domain.movie.service.command.MovieCommand;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * description    : 영화 응답 클래스
 * packageName    : com.clean.user_app.domain.movie.controller.response
 * fileName       : MovieResponse
 * author         : 김현주
 * date           : 25. 6. 21.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 21.        김현주             최초 생성
 */

@Getter @Setter @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieResponse {
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

    public static MovieResponse of(MovieCommand movieCommand) {
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setId(movieCommand.getId());
        movieResponse.setMovieNm(movieCommand.getMovieNm());
        movieResponse.setMovieCd(movieCommand.getMovieCd());
        movieResponse.setRank(movieCommand.getRank());
        movieResponse.setRankInten(movieCommand.getRankInten());
        movieResponse.setOpenDt(movieCommand.getOpenDt());
        movieResponse.setAudiAcc(movieCommand.getAudiAcc());
        movieResponse.setScrnCnt(movieCommand.getScrnCnt());
        movieResponse.setShowCnt(movieCommand.getShowCnt());
        movieResponse.setSalesAmt(movieCommand.getSalesAmt());
        movieResponse.setAudiCnt(movieCommand.getAudiCnt());
        movieResponse.setManufacturedBy("kor");
        movieResponse.setPrice("12000");
        return movieResponse;
    }
}
