package com.example.demo.repository;


import com.example.demo.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final SqlSessionTemplate sql;

    //회원가입
    public MemberDTO save(MemberDTO memberDTO) {
        sql.insert("Member.join", memberDTO);
        return memberDTO;
    }

    // 로그인
    public boolean login(String username, String password) {
        MemberDTO member = new MemberDTO();
        member.setUsername(username);
        member.setPassword(password);
        MemberDTO result = sql.selectOne("Member.login", member);
        return result != null;
    }
}
