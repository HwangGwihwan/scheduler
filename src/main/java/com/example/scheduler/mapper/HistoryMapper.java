package com.example.scheduler.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HistoryMapper {
	int insertHistory(String id);
	//List<LoginHistory> selectHistory();
}
