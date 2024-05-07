package com.example.demo.service;


import com.example.demo.dto.MemberDTO;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원가입
    public MemberDTO register(MemberDTO memberDTO) {
        return memberRepository.save(memberDTO);
    }

    // 로그인
    public boolean login(String username, String password) {
        return memberRepository.login(username, password);
    }
}
