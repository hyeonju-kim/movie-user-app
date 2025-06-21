package com.clean.user_app.common.http;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * description    : RestTemplate 구현 클래스
 * packageName    : com.clean.user_app.common.http
 * fileName       : RestTemplateHttpClient
 * author         : 김현주
 * date           : 25. 6. 21.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 21.        김현주             최초 생성
 */
@RequiredArgsConstructor
@Component
public class RestTemplateHttpClient implements HttpClientWrapper{
    private final RestTemplate restTemplate;

    @Override
    public <T> T get(String url, Class<T> responseType) {
        return restTemplate.getForObject(url, responseType);
    }

    @Override
    public <T, R> R post(String url, T requestBody, Class<R> responseType) {
        return restTemplate.postForObject(url, requestBody, responseType);
    }
}
