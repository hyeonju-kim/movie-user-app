package com.clean.user_app.domain.movie.service.command;

import com.clean.user_app.common.dto.BaseDto;
import com.clean.user_app.domain.movie.controller.model.MovieRequest;
import com.clean.user_app.domain.movie.controller.model.MovieResponse;
import com.clean.user_app.domain.movie.entity.Movie;
import lombok.Getter;
import lombok.Setter;

/**
 * description    : 영화 Command
 * packageName    : com.clean.user_app.domain.movie.service.command
 * fileName       : MovieCommand
 * author         : 김현주
 * date           : 25. 6. 21.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 21.        김현주             최초 생성
 */
@Setter
@Getter
public class MovieCommand extends BaseDto {
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


    public static MovieCommand of(MovieRequest movieRequest) {
        MovieCommand movieCommand = new MovieCommand();
        movieCommand.setPNum(movieRequest.getPNum());
        movieCommand.setPSize(movieRequest.getPSize());
        return movieCommand;
    }

    public static MovieCommand of(Movie movie) {
        MovieCommand movieCommand = new MovieCommand();
        movieCommand.setId(movie.getId());
        movieCommand.setMovieNm(movie.getMovieNm());
        movieCommand.setMovieCd(movie.getMovieCd());
        movieCommand.setRank(movie.getRank());
        movieCommand.setRankInten(movie.getRankInten());
        movieCommand.setOpenDt(movie.getOpenDt());
        movieCommand.setAudiAcc(movie.getAudiAcc());
        movieCommand.setScrnCnt(movie.getScrnCnt());
        movieCommand.setShowCnt(movie.getShowCnt());
        movieCommand.setSalesAmt(movie.getSalesAmt());
        movieCommand.setAudiCnt(movie.getAudiCnt());
        movieCommand.setManufacturedBy("kor");
        movieCommand.setPrice("12000");
        return movieCommand;
    }

    public static MovieCommand of(MovieResponse movieResponse) {
        MovieCommand movieCommand = new MovieCommand();
        movieCommand.setMovieNm(movieResponse.getMovieNm());
        movieCommand.setMovieCd(movieResponse.getMovieCd());
        movieCommand.setRank(movieResponse.getRank());
        movieCommand.setRankInten(movieResponse.getRankInten());
        movieCommand.setOpenDt(movieResponse.getOpenDt());
        movieCommand.setAudiAcc(movieResponse.getAudiAcc());
        movieCommand.setScrnCnt(movieResponse.getScrnCnt());
        movieCommand.setShowCnt(movieResponse.getShowCnt());
        movieCommand.setSalesAmt(movieResponse.getSalesAmt());
        movieCommand.setAudiCnt(movieResponse.getAudiCnt());
        movieCommand.setManufacturedBy("kor");
        movieCommand.setPrice("12000");
        return movieCommand;
    }

}
