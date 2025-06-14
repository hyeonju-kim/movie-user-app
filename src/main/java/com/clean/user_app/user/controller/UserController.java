package com.clean.user_app.user.controller;

import com.clean.user_app.user.controller.request.SignupRequest;
import com.clean.user_app.user.service.UserService;
import lombok.RequiredArgsConstructor;
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


    @PostMapping
    public ResponseEntity<?> regUser(@RequestBody SignupRequest signupRequest) {
        userService.regUser(signupRequest.toCommand(signupRequest));
        return ResponseEntity.ok().build();
    }


}
