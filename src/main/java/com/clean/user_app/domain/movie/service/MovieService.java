package com.clean.user_app.domain.movie.service;

import com.clean.user_app.domain.movie.service.command.MovieCommand;

import java.util.List;

/**
 * description    : 영화 서비스 인터페이스
 * packageName    : com.clean.user_app.domain.movie.service
 * fileName       : MovieService
 * author         : 김현주
 * date           : 25. 6. 21.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 21.        김현주             최초 생성
 */
public interface MovieService {
    List<MovieCommand> getMovieList(MovieCommand movieCommand);
    List<MovieCommand> getOpenApiMovies();
}
