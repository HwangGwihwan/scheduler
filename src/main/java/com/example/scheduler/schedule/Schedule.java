package com.example.scheduler.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.scheduler.dto.Member;
import com.example.scheduler.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Schedule {
	@Autowired MemberService memberService;
	
	@Scheduled(cron = "0 * * * * *")
	//@Scheduled(cron = "0 59 23 25 * *")
	public void inactive() {
		List<Member> list = memberService.selectInactive();
		
		for (Member m : list) {
			log.info(m.toString());
			memberService.updateMemberActive(m);
		}
	}
}
