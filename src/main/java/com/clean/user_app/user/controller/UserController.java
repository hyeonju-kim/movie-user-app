package com.clean.user_app.user.controller;

import com.clean.user_app.user.controller.request.SignupRequest;
import com.clean.user_app.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * description    : 로그인/회원가입 컨트롤러
 * packageName    : com.clean.user_app.user.controller
 * fileName       : UserController
 * author         : 김현주
 * date           : 25. 6. 14.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 14.        김현주             최초 생성
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    // 회원 가입
    @PostMapping
    public ResponseEntity<?> regUser(@RequestBody @Valid SignupRequest signupRequest) {
        userService.regUser(signupRequest.toCommand(signupRequest));
        return ResponseEntity.ok().build();
    }

    // 로그인
    @GetMapping
    public ResponseEntity<?> login(@RequestBody @Valid SignupRequest signupRequest) {
        final String loginUsername = userService.login(signupRequest.toCommand(signupRequest));
        return ResponseEntity.ok(Map.of(
                "message", "로그인에 성공했습니다.",
                "username", loginUsername
        ));
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
