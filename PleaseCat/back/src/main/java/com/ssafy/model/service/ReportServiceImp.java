package com.ssafy.model.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.ReportDao;
import com.ssafy.model.dto.PleaseCatException;
import com.ssafy.model.dto.report;

@Service
public class ReportServiceImp implements ReportService {

	@Autowired
	private ReportDao dao;
	
	HashMap<String, Object> map;
	//신고 여부
	@Override
	public String searchReport(int user_no, int post_no) {
		try {
			map = new HashMap<String, Object>();
			map.put("user_no", user_no);
			map.put("post_no", post_no);
			report find = dao.searchReport(map);
			if(find==null) {
				return "execute";
			}else {
				return "cancel";
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PleaseCatException("신고 탐색중 오류");
		}
	}

	//신고
	@Override
	public void insertReport(int user_no, int post_no) {
		try {
			String answer = searchReport(user_no, post_no);
			if(answer=="execute") {
				map = new HashMap<String, Object>();
				map.put("user_no", user_no);
				map.put("post_no", post_no);
				dao.insertReport(map);
				System.out.println("신고 누를게요~");
			}else {
				throw new PleaseCatException("이미 신고 눌렀습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PleaseCatException("신고 실행중 오류");
		}

	}

	//신고 취소
	@Override
	public void deleteReport(int user_no, int post_no) {
		try {
		String answer = searchReport(user_no, post_no);
		if(answer=="cancel") {
			map = new HashMap<String, Object>();
			map.put("user_no", user_no);
			map.put("post_no", post_no);
			dao.deleteReport(map);
			System.out.println("신고 취소합니다.");
		}else {
			throw new PleaseCatException("신고 우째 삭제해요");
			}
		} catch (Exception e) {
		e.printStackTrace();
		throw new PleaseCatException("신고 실행중 오류");
		}
	}
}
