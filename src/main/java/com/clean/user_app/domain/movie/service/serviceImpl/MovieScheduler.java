package com.clean.user_app.domain.movie.service.serviceImpl;

import com.clean.user_app.domain.movie.entity.Movie;
import com.clean.user_app.domain.movie.repository.MovieRepository;
import com.clean.user_app.domain.movie.service.MovieService;
import com.clean.user_app.domain.movie.service.command.MovieCommand;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * description    : 영화 스케줄러
 * packageName    : com.clean.user_app.domain.movie.service.serviceImpl
 * fileName       : MovieScheduler
 * author         : 김현주
 * date           : 25. 6. 21.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 21.        김현주             최초 생성
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class MovieScheduler {
    private final MovieService movieService;
    private final MovieRepository movieRepository;

//    @Scheduled(cron = "0 0 0 * * *")
    @Scheduled(fixedRate = 6000) // 테스트용
    public void getOpenApiMovies() throws JsonProcessingException {
        List<MovieCommand> movieCommands = movieService.getOpenApiMovies();

        for (MovieCommand movieCommand : movieCommands) {
            movieRepository.save(Movie.of(movieCommand));
        }
    }
}
