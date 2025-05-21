package com.example.scheduler.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.scheduler.dto.Member;

@Mapper
public interface LoginMapper {
	Member login(Member member);
	List<Member> selectInactive();
	int updateMemberActiveById(String id);
	int updateMemberPw(Member member);
}
