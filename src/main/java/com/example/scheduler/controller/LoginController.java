package com.example.scheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.scheduler.dto.Member;
import com.example.scheduler.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired MemberService memberService;
	
	@GetMapping({"/", "/login"})
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, Member member) {
		Member loginMember = memberService.login(member);
		
		// 로그인 성공
		if (loginMember != null) {
			session.setAttribute("loginMember", loginMember);
			return "/member/memberHome";
		}
		
		// 로그인 실패
		return "redirect:/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
