//package com.clean.user_app.domain.user.service.command;
//
//import com.clean.user_app.domain.user.repository.dto.SignupDto;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
///**
// * description    : 회원가입 서비스용 커맨드 DTO
// * packageName    : com.clean.user_app.user.service.command
// * fileName       : SignupCommand
// * author         : 김현주
// * date           : 25. 6. 14.
// * ===========================================================
// * DATE              AUTHOR             NOTE
// * -----------------------------------------------------------
// * 25. 6. 14.        김현주             최초 생성
// */
//@Getter @Setter @ToString
//public class SignupCommand {
//    private String username;
//    private String password;
//
//    // SignupCommand -> SignupDto
//    public SignupDto toDto() {
//        final SignupDto signupDto = new SignupDto();
//        signupDto.setUsername(this.getUsername());
//        signupDto.setPassword(this.getPassword());
//        return signupDto;
//    }
//
//}
