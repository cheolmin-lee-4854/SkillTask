package com.auth.domain.user.controller;

import com.auth.domain.user.dto.SignupRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.auth.domain.user.service.SignupService;

@RestController
@RequestMapping("/api")
public class SignupController {

    private final SignupService signupService;

    @Autowired
    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping("/signup") // POST 메소드로 변경
    public String signup(@RequestBody SignupRequestDto requestDto) { //제이슨으로 출력하는 방법 찾기
        signupService.signup(requestDto);
        return "회원가입 성공";
    }
}

