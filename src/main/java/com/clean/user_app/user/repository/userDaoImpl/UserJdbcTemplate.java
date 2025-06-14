package com.clean.user_app.user.repository.userDaoImpl;

import com.clean.user_app.user.repository.UserDao;
import com.clean.user_app.user.repository.dto.SignupDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * description    : 유저 JDBC Template 서비스
 * packageName    : com.clean.user_app.user.repository.userDaoImpl
 * fileName       : UserJdbcTemplate
 * author         : 김현주
 * date           : 25. 6. 14.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 14.        김현주             최초 생성
 */
//@Component
@RequiredArgsConstructor
@Slf4j
public class UserJdbcTemplate implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void regUser(SignupDto signupDto) {
        String sql = "INSERT INTO USERS(username, password) VALUES(?, ?)";
        log.info("[regUser] > [sql] === {}", sql);

        final int cnt = jdbcTemplate.update(sql, signupDto.getUsername(), signupDto.getPassword());
        log.info("[regUser] > [cnt] === {}", cnt);
    }
}
