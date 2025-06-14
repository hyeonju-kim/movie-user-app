package com.clean.user_app.user.service;

import com.clean.user_app.user.service.command.SignupCommand;

/**
 * description    : 유저 서비스 인터페이스
 * packageName    : com.clean.user_app.user.service
 * fileName       : UserService
 * author         : 김현주
 * date           : 25. 6. 14.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 14.        김현주             최초 생성
 */

public interface UserService {
    void regUser(SignupCommand signupCommand);
    void login(SignupCommand signupCommand);
}
