package com.clean.user_app.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description    : 테스트 컨트롤러
 * packageName    : com.clean.user_app.user.controller
 * fileName       : TestController
 * author         : 김현주
 * date           : 25. 6. 14.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 14.        김현주             최초 생성
 */
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    @GetMapping
    public ResponseEntity<?> test() {
        return ResponseEntity
                .ok().body("테스트");
    }
}
