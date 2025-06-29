package com.clean.user_app.domain.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * description    : 유저 Entity
 * packageName    : com.clean.user_app.entity
 * fileName       : User
 * author         : 김현주
 * date           : 25. 6. 14.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 14.        김현주             최초 생성
 */
@Entity
@Getter @Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) // user는 Order 엔티티에 있는 user 필드
//    @JsonIgnore // 단방향 출력으로 제어 (JSON 직렬화에서 제외하여 무한루프 방지)
//    private List<Order> orders = new ArrayList<>();
}
