package com.clean.user_app.user.service.command;

import com.clean.user_app.user.repository.dto.LoginDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * description    : 로그인 서비스용 커맨드 DTO
 * packageName    : com.clean.user_app.user.service.command
 * fileName       : LoginCommand
 * author         : 김현주
 * date           : 25. 6. 15.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 15.        김현주             최초 생성
 */
@Getter @Setter @ToString
public class LoginCommand {
    private String username;
    private String password;

    // LoginCommand -> LoginDto
    public LoginDto toDto() {
        final LoginDto loginDto = new LoginDto();
        loginDto.setUsername(this.getUsername());
        loginDto.setPassword(this.getPassword());
        return loginDto;
    }

}
