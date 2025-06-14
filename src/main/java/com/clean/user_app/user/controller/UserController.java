package com.clean.user_app.user.controller;

import com.clean.user_app.common.dto.CommonResponse;
import com.clean.user_app.user.controller.request.SignupRequest;
import com.clean.user_app.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/signup")
    public ResponseEntity<CommonResponse<SignupRequest>> regUser(@RequestBody @Valid SignupRequest signupRequest) {
        userService.regUser(signupRequest.toCommand());
        final CommonResponse<SignupRequest> body = new CommonResponse<>("회원가입 성공", signupRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<CommonResponse<String>> login(@RequestBody @Valid SignupRequest signupRequest) {
        final String loginUsername = userService.login(signupRequest.toCommand());
        final CommonResponse<String> body = new CommonResponse<>("로그인 성공", loginUsername);
        return ResponseEntity.ok().body(body);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
