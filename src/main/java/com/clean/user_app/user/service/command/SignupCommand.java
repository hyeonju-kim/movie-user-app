package com.clean.user_app.user.service.command;

import com.clean.user_app.user.repository.dto.SignupDto;
import lombok.Getter;
import lombok.Setter;

/**
 * description    : 로그인/회원가입 서비스용 커맨드 DTO
 * packageName    : com.clean.user_app.user.service.command
 * fileName       : SignupRequest
 * author         : 김현주
 * date           : 25. 6. 14.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 14.        김현주             최초 생성
 */
@Getter @Setter
public class SignupCommand {
    private String username;
    private String password;

    // SignupCommand -> SignupDto
    public SignupDto toDto(SignupCommand signupCommand) {
        final SignupDto signupDto = new SignupDto();
        signupDto.setUsername(signupCommand.getUsername());
        signupDto.setPassword(signupCommand.getPassword());
        return signupDto;
    }

}
