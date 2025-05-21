package com.example.scheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.scheduler.dto.Member;
import com.example.scheduler.dto.PwHistory;
import com.example.scheduler.mapper.HistoryMapper;
import com.example.scheduler.mapper.LoginMapper;

@Transactional
@Service
public class MemberService {
	@Autowired LoginMapper loginMapper;
	@Autowired HistoryMapper historyMapper;
	@Autowired JavaMailSender javaMailSender;
	
	public Member login(Member member) {
		Member loginMember = loginMapper.login(member);
		if (loginMember == null) {
			return null;
		}
		
		historyMapper.insertHistory(loginMember.getId());
		return loginMember;
	}
	
	public List<Member> selectInactive() {
		return loginMapper.selectInactive();
	}
	
	public void updateMemberActive(Member member) {
		if (member.getActive().equals("ON")) {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setFrom("admin@localhost.com");
			msg.setTo(member.getEmail());
			msg.setSubject("당신의 계정이 휴먼상태로 변경되었습니다");
			msg.setText(member.getId() + "계정이 휴먼상태로 변경되었습니다");
			
			javaMailSender.send(msg);
		}
		
		loginMapper.updateMemberActiveById(member.getId());
	}
	
	public void updateMemberPw(Member member) {
		loginMapper.updateMemberPw(member);
		
		PwHistory pwHistory = new PwHistory();
		pwHistory.setId(member.getId());
		pwHistory.setPw(member.getPw());
		historyMapper.insertPwHistroy(pwHistory);
	}
	
	public String selectIdAndPw(String id, String pw) {
		return historyMapper.selectIdAndPw(id, pw);
	}
	
	public void deletePwHistory() {
		historyMapper.deletePwHistory();
	}
}
