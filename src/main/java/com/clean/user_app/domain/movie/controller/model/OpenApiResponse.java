package com.clean.user_app.domain.movie.controller.model;

import lombok.Data;

/**
 * description    : 영화 open API 응답 클래스
 * packageName    : com.clean.user_app.domain.movie.controller.model
 * fileName       : OpenApiResponse
 * author         : 김현주
 * date           : 25. 6. 21.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 21.        김현주             최초 생성
 */
@Data
public class OpenApiResponse {
    private BoxOfficeResult boxOfficeResult;
}
