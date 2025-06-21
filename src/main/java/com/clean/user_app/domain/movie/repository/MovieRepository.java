package com.clean.user_app.domain.movie.repository;

import com.clean.user_app.domain.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * description    : 영화 저장소
 * packageName    : com.clean.user_app.domain.movie.repository
 * fileName       : MovieRepository
 * author         : 김현주
 * date           : 25. 6. 21.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 21.        김현주             최초 생성
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
