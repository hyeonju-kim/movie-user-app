package com.clean.user_app.domain.movie.service.serviceImpl;

import com.clean.user_app.common.http.HttpClientWrapper;
import com.clean.user_app.domain.movie.controller.model.MovieResponse;
import com.clean.user_app.domain.movie.controller.model.OpenApiResponse;
import com.clean.user_app.domain.movie.repository.MovieRepository;
import com.clean.user_app.domain.movie.service.MovieService;
import com.clean.user_app.domain.movie.service.command.MovieCommand;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description    : 영화 서비스 구현체
 * packageName    : com.clean.user_app.domain.movie.service.serviceImpl
 * fileName       : MovieServiceImpl
 * author         : 김현주
 * date           : 25. 6. 21.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 21.        김현주             최초 생성
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final HttpClientWrapper httpClientWrapper;
    private final ObjectMapper objectMapper;
    public static String MOVIE_API_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
    public static String MOVIE_API_KEY = "ee170ae6b2dcb42e2c1499dae98b645e";
    public static String REQUEST_URL = MOVIE_API_URL + "?" + "key=" + MOVIE_API_KEY;

    @Override
    public List<MovieCommand> getMovieList(MovieCommand movieCommand) {
        Pageable pageable = PageRequest.of(movieCommand.getPNum() - 1, movieCommand.getPSize());

        return movieRepository.findAll(pageable).getContent().stream()
                .map(MovieCommand::of)
                .toList();
    }

    @Override
    public List<MovieCommand> getOpenApiMovies() {
        String requestUrlFinal = REQUEST_URL + "&" + "targetDt=" + "20250620";

        String apiMovies = httpClientWrapper.get(requestUrlFinal, String.class);
        OpenApiResponse openApiResponse;
        try {
            openApiResponse = objectMapper.readValue(apiMovies, OpenApiResponse.class);
        } catch (JsonProcessingException e) {
            log.error("OpenAPI 응답 파싱 실패", e);
            throw new RuntimeException(e);
        }

        List<MovieResponse> movieResponses = openApiResponse.getBoxOfficeResult().getDailyBoxOfficeList();

        return movieResponses.stream()
                .map(MovieCommand::of)
                .toList();

    }


}
