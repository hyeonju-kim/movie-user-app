//package com.clean.user_app.domain.user.repository.dto;
//
//import com.clean.user_app.domain.user.entity.User;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
///**
// * description    : 회원가입 DTO
// * packageName    : com.clean.user_app.user.repository.dto
// * fileName       : SignupDto
// * author         : 김현주
// * date           : 25. 6. 14.
// * ===========================================================
// * DATE              AUTHOR             NOTE
// * -----------------------------------------------------------
// * 25. 6. 14.        김현주             최초 생성
// */
//@Getter @Setter @ToString
//public class SignupDto {
//    private String username;
//    private String password;
//
//    // SignupDto -> User
//    public User toEntity() {
//        final User user = new User();
//        user.setUsername(this.getUsername());
//        user.setPassword(this.getPassword());
//        return user;
//    }
//}
