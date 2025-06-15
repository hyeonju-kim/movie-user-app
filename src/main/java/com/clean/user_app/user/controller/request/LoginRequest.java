package com.clean.user_app.user.controller.request;

import com.clean.user_app.user.service.command.LoginCommand;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * description    : 로그인 요청 DTO
 * packageName    : com.clean.user_app.user.controller.request
 * fileName       : LoginRequest
 * author         : 김현주
 * date           : 25. 6. 15.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 15.        김현주             최초 생성
 */
@Getter @Setter @ToString
public class LoginRequest {
    @NotBlank(message = "username은 반드시 입력해야 합니다.")
    private String username;
    @NotBlank(message = "password는 반드시 입력해야 합니다.")
    private String password;

    // LoginRequest -> LoginCommand
    public LoginCommand toCommand() {
        final LoginCommand loginCommand = new LoginCommand();
        loginCommand.setUsername(this.getUsername());
        loginCommand.setPassword(this.getPassword());
        return loginCommand;
    }
}
