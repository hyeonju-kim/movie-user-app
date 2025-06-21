package com.clean.user_app.domain.user.repository.userDaoImpl;

import com.clean.user_app.domain.user.repository.UserDao;
import com.clean.user_app.domain.user.repository.UserRepository;
import com.clean.user_app.domain.user.repository.dto.LoginDto;
import com.clean.user_app.domain.user.entity.User;
import com.clean.user_app.domain.user.repository.dto.SignupDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
 * description    : 유저 JPA 저장소 서비스
 * packageName    : com.clean.user_app.user.repository.userDaoImpl
 * fileName       : UserJpaTemplate
 * author         : 김현주
 * date           : 25. 6. 14.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 14.        김현주             최초 생성
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class UserJpaTemplate implements UserDao {
    private final UserRepository userRepository;

    @Override
    public void regUser(SignupDto signupDto) {
        userRepository.save(signupDto.toEntity());
    }

    @Override
    public Optional<User> getUser(LoginDto loginDto) {
        return userRepository.findByUsername(loginDto.getUsername());
    }

    @Override
    public Optional<User> getUser(SignupDto signupDto) {
        return userRepository.findByUsername(signupDto.getUsername());
    }
}
