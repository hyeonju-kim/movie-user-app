package com.clean.user_app.user.service.serviceImpl;

import com.clean.user_app.user.repository.UserDao;
import com.clean.user_app.user.service.UserService;
import com.clean.user_app.user.service.command.SignupCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * description    : 유저 서비스 Impl
 * packageName    : com.clean.user_app.user.service.serviceImpl
 * fileName       : UserServiceImpl
 * author         : 김현주
 * date           : 25. 6. 14.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 14.        김현주             최초 생성
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    // 회원 가입
    @Override
    public void regUser(SignupCommand signupCommand) {
        userDao.regUser(signupCommand.toDto(signupCommand));
    }

    // 로그인
    @Override
    public void login(SignupCommand signupCommand) {

    }


}
