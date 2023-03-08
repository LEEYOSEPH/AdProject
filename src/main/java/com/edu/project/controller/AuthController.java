package com.edu.project.controller;

import com.edu.project.dto.TokenDto;
import com.edu.project.dto.TokenRequestDto;
import com.edu.project.request.MemberLoginRequestDto;
import com.edu.project.response.MemberResponseDto;
import com.edu.project.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/api/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberLoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(authService.sigup(loginRequestDto));
    }
    /*
    *  로그인 후 jwt 토큰 발급 API
    * */
    @PostMapping("/api/common/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberLoginRequestDto loginRequestDto) {

        return ResponseEntity.ok(authService.login(loginRequestDto));
    }

    /*
    *  refresh token 발급 API
    * */
    @PostMapping("/api/common/refreshToken")
    public ResponseEntity<TokenDto> reIssue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reIssue(tokenRequestDto));
    }


}
