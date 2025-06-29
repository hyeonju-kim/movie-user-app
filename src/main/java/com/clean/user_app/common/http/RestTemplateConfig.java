package com.clean.user_app.common.http;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.util.Timeout;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * description    : RestTemplate 설정 클래스
 * packageName    : com.clean.user_app.common
 * fileName       : RestTemplateConfig
 * author         : 김현주
 * date           : 25. 6. 20.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 20.        김현주             최초 생성
 */
@Configuration
public class RestTemplateConfig {

    @Value("${cnf.rest-template.connect-timeout}")
    private int connectTimeout;

    @Value("${cnf.rest-template.connection-request-timeout}")
    private int connectionRequestTimeout;

    @Value("${cnf.rest-template.response-timeout}")
    private int responseTimeout;

    @Bean
    public RestTemplate restTemplate() {
        // RequestConfig 설정값 세팅
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(Timeout.ofMilliseconds(connectTimeout))       // 서버 연결 시간
                .setConnectionRequestTimeout(Timeout.ofMilliseconds(connectionRequestTimeout)) // 커넥션 풀에서 꺼내는 시간
                .setResponseTimeout(Timeout.ofMilliseconds(responseTimeout))      // 응답 대기 시간
                .build();

        // HttpClient에 RequestConfig 세팅
        HttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build();

        // Factory에 httpClient 세팅
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setHttpClient(httpClient);

        // RestTemplate에 factory 세팅
        return new RestTemplate(factory);
    }
}
