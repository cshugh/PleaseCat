package com.ssafy.model.dao;

import java.util.HashMap; 

import org.apache.ibatis.annotations.Mapper; 
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.report;

@Repository
@Mapper
public interface ReportDao {
	public report searchReport(HashMap<String, Object> map);
	public void insertReport(HashMap<String, Object> map);
	public void deleteReport(HashMap<String, Object> map);
}
