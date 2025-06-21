package com.clean.user_app.common.http;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.util.Timeout;
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

    @Bean
    public RestTemplate restTemplate() {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(Timeout.ofMilliseconds(4000))       // 서버 연결 시간
                .setConnectionRequestTimeout(Timeout.ofMilliseconds(4000)) // 커넥션 풀에서 꺼내는 시간
                .setResponseTimeout(Timeout.ofMilliseconds(5000))      // 응답 대기 시간
                .build();

        HttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setHttpClient(httpClient);

        return new RestTemplate(factory);
    }
}
