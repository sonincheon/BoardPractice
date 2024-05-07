package com.example.demo.controller;


import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/register")
    public String register(MemberDTO memberDTO) {
        memberService.register(memberDTO);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(@RequestParam(name = "error", required = false) String error, Model model) {
        if (error != null && error.equals("invalidCredentials")) {
            model.addAttribute("errorMessage", "Invalid username or password.");
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password) {
        boolean loginResult = memberService.login(username, password);
        if (loginResult) {
            return "redirect:/"; // 로그인 성공 시 메인 페이지 이동
        } else {
            return "redirect:/login?error=invalidCredentials";
        }
    }
}
