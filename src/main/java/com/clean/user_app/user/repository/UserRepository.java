package com.clean.user_app.user.repository;

import com.clean.user_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * description    : JPA 유저 저장소
 * packageName    : com.clean.user_app.user.repository
 * fileName       : UserRepository
 * author         : 김현주
 * date           : 25. 6. 14.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 14.        김현주             최초 생성
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
