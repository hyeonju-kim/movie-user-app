package com.clean.user_app.common.http;

/**
 * description    : HTTP 통신을 추상화한 인터페이스
 * packageName    : com.clean.user_app.common.http
 * fileName       : HttpClientWrapper
 * author         : 김현주
 * date           : 25. 6. 21.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 21.        김현주             최초 생성
 */
public interface HttpClientWrapper {
    <T> T get(String url, Class<T> responseType);
    <T, R> R post(String url, T requestBody, Class<R> responseType);
}
