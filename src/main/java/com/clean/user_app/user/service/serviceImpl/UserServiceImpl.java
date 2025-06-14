package com.clean.user_app.user.service.serviceImpl;

import com.clean.user_app.entity.User;
import com.clean.user_app.user.repository.UserDao;
import com.clean.user_app.user.repository.dto.SignupDto;
import com.clean.user_app.user.service.UserService;
import com.clean.user_app.user.service.command.SignupCommand;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final HttpServletRequest request;
    public static final String LOGIN_USER_KEY = "loginUser"; // 로그인 세션 키 상수


    // 회원 가입
    @Override
    public void regUser(SignupCommand signupCommand) {
        log.info("[regUser] > [signupCommand] === {}", signupCommand);

        SignupDto signupDto = signupCommand.toDto();

        // 비밀번호 암호화
        final String password = signupDto.getPassword();
        final String encodedPassword = bCryptPasswordEncoder.encode(password);
        signupDto.setPassword(encodedPassword);

        // DB에 해당 유저가 없으면 등록
        Optional<User> foundUser = userDao.getUser(signupDto);

        if (foundUser.isPresent()) {
            throw new IllegalArgumentException("이미 가입한 회원입니다.");
        }
        userDao.regUser(signupDto);
    }

    // 로그인
    @Override
    public String login(SignupCommand signupCommand) {
        Optional<User> foundUser = userDao.getUser(signupCommand.toDto());
        // 가입한 회원인지 확인
        final User user = foundUser.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        // 암호 검증 후 세션에 회원 정보 저장
        final boolean matches = bCryptPasswordEncoder.matches(signupCommand.getPassword(), user.getPassword());
        if (matches) {
            // 1. 기존 세션 있으면 삭제
            HttpSession old = request.getSession(false);
            if (old != null) old.invalidate();

            // 2. 새 세션 생성 및 저장
            final HttpSession session = request.getSession(true); // 기존 세션이 없으면 새로 만들기
            session.setAttribute(LOGIN_USER_KEY, user);
            log.info("[login] > [session] === {} 세션에 저장 완료 !", session);
        } else {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return user.getUsername();
    }
}
