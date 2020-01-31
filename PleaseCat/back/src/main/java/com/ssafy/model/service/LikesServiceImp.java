package com.ssafy.model.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.LikesDao;
import com.ssafy.model.dto.PleaseCatException;
import com.ssafy.model.dto.likes;

@Service
public class LikesServiceImp implements LikesService {

	@Autowired
	private LikesDao dao;
	
	HashMap<String, Object> map;
	//회원번호와 게시글번호로 좋아요 존재 여부를 확인하고 없으면 execute 문장을 반환하고 있으면 cancel을 반환한다.
	@Override
	public String searchLikes(int user_no, int post_no) {
		try {
			map = new HashMap<String, Object>();
			map.put("user_no", user_no);
			map.put("post_no", post_no);
			likes find = dao.searchLikes(map);
			if(find==null) {
				return "execute";
			}else {
				return "cancel";
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PleaseCatException("좋아요 탐색중 오류");
		}
	}

	//좋아요 삽입
	@Override
	public void insertLikes(int user_no, int post_no) {
		try {
			String answer = searchLikes(user_no, post_no);
			if(answer=="execute") {
				map = new HashMap<String, Object>();
				map.put("user_no", user_no);
				map.put("post_no", post_no);
				dao.insertLikes(map);
				System.out.println("좋아요 누를게요~");
			}else {
				throw new PleaseCatException("이미 좋아요 눌렀습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PleaseCatException("좋아요 실행중 오류");
		}

	}

	//좋아요 취소
	@Override
	public void deleteLikes(int user_no, int post_no) {
		try {
		String answer = searchLikes(user_no, post_no);
		if(answer=="cancel") {
			map = new HashMap<String, Object>();
			map.put("user_no", user_no);
			map.put("post_no", post_no);
			dao.deleteLikes(map);
			System.out.println("좋아요 취소합니다.");
		}else {
			throw new PleaseCatException("이미 없어요");
			}
		} catch (Exception e) {
		e.printStackTrace();
		throw new PleaseCatException("좋아요 실행중 오류");
		}
	}
}
