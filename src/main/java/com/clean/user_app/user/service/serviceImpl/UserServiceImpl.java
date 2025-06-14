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

    // 회원 가입
    @Override
    public void regUser(SignupCommand signupCommand) {
        log.info("[regUser] > [signupCommand.getUsername()] === {}", signupCommand.getUsername());

        SignupDto signupDto = signupCommand.toDto(signupCommand);


        // 비밀번호 암호화
        final String password = signupDto.getPassword();
        final String encodedPassword = bCryptPasswordEncoder.encode(password);
        signupDto.setPassword(encodedPassword);

        // DB에 해당 유저가 없으면 등록
        Optional<User> foundUser = userDao.getUser(signupDto);
        if (foundUser.isEmpty()) {
            userDao.regUser(signupDto);
        } else {
            log.info("이미 가입한 회원입니다.");
            throw new IllegalArgumentException("이미 가입한 회원입니다.");
        }
    }

    // 로그인
    @Override
    public String login(SignupCommand signupCommand) {
        Optional<User> foundUser = userDao.getUser(signupCommand.toDto(signupCommand));


        if (foundUser.isPresent()) {
            // 암호 검증
            final String foundPassword = foundUser.get().getPassword();
            final boolean matches = bCryptPasswordEncoder.matches(signupCommand.getPassword(), foundPassword);

            // 검증 후 세션 저장
            if (matches) {
                final HttpSession session = request.getSession(true);
                session.setAttribute("loginUser", foundUser.get());
                log.info("[login] > [foundUser.get()] === {} 세션에 저장 완료!", foundUser.get());
            }
        } else {
            log.info("존재하지 않는 회원입니다.");
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }
        return foundUser.get().getUsername();
    }
}
