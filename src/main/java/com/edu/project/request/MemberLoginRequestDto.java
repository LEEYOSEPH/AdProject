package com.edu.project.request;

import com.edu.project.entity.Member;
import com.edu.project.enums.Authority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberLoginRequestDto {

    private String memberId;
    private String pwd;

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .memberId(memberId)
                .pwd(passwordEncoder.encode(pwd))
                .roleGroup(Authority.ROLE_ADV)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(memberId, pwd);
    }
}
