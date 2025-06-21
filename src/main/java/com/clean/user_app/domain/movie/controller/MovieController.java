package com.clean.user_app.domain.movie.controller;

import com.clean.user_app.domain.movie.controller.model.MovieRequest;
import com.clean.user_app.domain.movie.controller.model.MovieResponse;
import com.clean.user_app.domain.movie.service.MovieService;
import com.clean.user_app.domain.movie.service.command.MovieCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description    : 영화 컨트롤러
 * packageName    : com.clean.user_app.domain.movie.controller
 * fileName       : MovieController
 * author         : 김현주
 * date           : 25. 6. 21.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 21.        김현주             최초 생성
 */
@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
@Slf4j
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/movies")
    public List<MovieResponse> getMovieList(@ModelAttribute MovieRequest movieRequest) {
        List<MovieCommand> movieCommands = movieService.getMovieList(MovieCommand.of(movieRequest));
        return mapToResponse(movieCommands);
    }

    @GetMapping("/movies/boxoffice")
    public List<MovieResponse> getMovieApi() {
        List<MovieCommand> movieCommands = movieService.getOpenApiMovies();
        return mapToResponse(movieCommands);
    }

    // List<MovieCommand> -> List<MovieResponse>
    private List<MovieResponse> mapToResponse(List<MovieCommand> commands) {
        return commands.stream()
                .map(MovieResponse::of)
                .toList();
    }
}

