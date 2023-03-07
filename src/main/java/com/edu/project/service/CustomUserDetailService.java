package com.edu.project.service;

import com.edu.project.entity.Member;
import com.edu.project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        return memberRepository.findByMemberId(memberId)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(memberId + "데이터 없음"));
    }

    private UserDetails createUserDetails(Member member) {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(member.getRoleGroup().toString());
        return new org.springframework.security.core.userdetails.User(
                String.valueOf(member.getMemberId()),
                member.getPwd(),
                Collections.singleton(grantedAuthority)
        );
    }
}
