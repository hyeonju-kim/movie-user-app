package com.clean.user_app.domain.movie.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * description    : 영화 open API 응답 클래스 - 내부 1 depth 객체
 * packageName    : com.clean.user_app.domain.movie.controller.model
 * fileName       : BoxOfficeResult
 * author         : 김현주
 * date           : 25. 6. 21.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 21.        김현주             최초 생성
 */
@Data
@NoArgsConstructor
public class BoxOfficeResult {
    private List<MovieResponse> dailyBoxOfficeList;
    private String boxofficeType;
    private String showRange;
}
