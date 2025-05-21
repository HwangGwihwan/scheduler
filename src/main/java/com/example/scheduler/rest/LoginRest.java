package com.example.scheduler.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.scheduler.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LoginRest {
	@Autowired MemberService memberService;
	
	@GetMapping("/pwCheck/{id}/{pw}")
	public boolean pwCheck(@PathVariable String id
			, @PathVariable String pw) {
		//log.info(pw);
		//log.info(memberService.selectIdAndPw(id, pw));
		
		if (memberService.selectIdAndPw(id, pw) != null) {
			return true;
		}
		return false;
	}
}
