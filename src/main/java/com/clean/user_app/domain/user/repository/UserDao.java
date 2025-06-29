package com.clean.user_app.domain.user.repository;

import com.clean.user_app.domain.user.entity.User;
import com.nicole.user_app_common.domain.user.repository.dto.LoginDto;
import com.nicole.user_app_common.domain.user.repository.dto.SignupDto;

import java.util.Optional;

/**
 * description    : 유저 DAO
 * packageName    : com.clean.user_app.user.repository
 * fileName       : UserDao
 * author         : 김현주
 * date           : 25. 6. 14.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 14.        김현주             최초 생성
 */

public interface UserDao {
    void regUser(SignupDto signupDto);

    Optional<User> getUser(LoginDto loginDto);
    Optional<User> getUser(SignupDto signupDto);
}
