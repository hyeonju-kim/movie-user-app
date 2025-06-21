package com.clean.user_app.common;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/**
 * description    : ApplicationRunner
 * packageName    : com.clean.user_app.common
 * fileName       : AppRunner
 * author         : 김현주
 * date           : 25. 6. 19.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 19.        김현주             최초 생성
 */
//@Component
@RequiredArgsConstructor
public class AppRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
    }
}
