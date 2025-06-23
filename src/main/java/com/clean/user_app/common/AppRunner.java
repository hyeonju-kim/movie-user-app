package com.clean.user_app.common;

import com.clean.user_app.domain.user.entity.User;
import com.clean.user_app.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * description    : ApplicationRunner
 * packageName    : com.clean.user_app.common
 * fileName       : AppRunner
 * author         : 김현주
 * date           : 25. 6. 19.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 19.        김현주             최초 생성
 */
@Component
@RequiredArgsConstructor
public class AppRunner implements ApplicationRunner {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    // 기본 유저 생성
    @Override
    public void run(ApplicationArguments args) {
        User user = new User();
        user.setUsername("khj");
        String encodedPassword = bCryptPasswordEncoder.encode("1234");
        user.setPassword(encodedPassword);

        userRepository.save(user);
    }
}
