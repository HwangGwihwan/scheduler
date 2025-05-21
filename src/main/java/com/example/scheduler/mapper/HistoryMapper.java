package com.example.scheduler.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.scheduler.dto.PwHistory;

@Mapper
public interface HistoryMapper {
	int insertHistory(String id);
	//List<LoginHistory> selectHistory();
	int insertPwHistroy(PwHistory pwHistory);
	String selectIdAndPw(String id, String pw);
	int deletePwHistory();
}
