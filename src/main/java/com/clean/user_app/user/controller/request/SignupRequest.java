package com.clean.user_app.user.controller.request;

import com.clean.user_app.user.service.command.SignupCommand;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * description    : 로그인/회원가입 요청 DTO
 * packageName    : com.clean.user_app.user.controller.request
 * fileName       : SignupRequest
 * author         : 김현주
 * date           : 25. 6. 14.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 14.        김현주             최초 생성
 */
@Getter @Setter
public class SignupRequest {
    @NotBlank(message = "username은 반드시 입력해야 합니다.")
    private String username;
    private String password;

    // SignupRequest -> SignupCommand
    public SignupCommand toCommand(SignupRequest signupRequest) {
        final SignupCommand signupCommand = new SignupCommand();
        signupCommand.setUsername(signupRequest.getUsername());
        signupCommand.setPassword(signupRequest.getPassword());
        return signupCommand;
    }
}
