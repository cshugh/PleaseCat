package com.ssafy.model.service;

import java.util.HashMap; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.Following_catDao;
import com.ssafy.model.dto.PleaseCatException;
import com.ssafy.model.dto.following_cat;


@Service
public class Following_catServiceImp implements Following_catService {

	@Autowired
	private Following_catDao dao;
	
	HashMap<String, Object> map;
	
	public String searchFollowingCat(int follower_no, int cat_no) {
		try {
			map = new HashMap<String, Object>();
			map.put("follower_no", follower_no);
			map.put("cat_no", cat_no);
			
			following_cat find = dao.searchFollowingCat(map);
			
			if(find==null) {
				return "execute";
			}else {
				return "cancel";
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PleaseCatException("고양이 팔로잉 탐색중 오류");
		}
	}
	
	//한 고양이를 팔로우하고있는 회원 목록 출력
	@Override
	public List<Integer> searchFollowerCat(int cat_no) {
		try {
			List<Integer> list = dao.searchFollowerCat(cat_no);
			if(list==null) {
				throw new PleaseCatException("고양이를 팔로잉하는 회원이 없습니다.");
			}else {
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PleaseCatException("cat팔로잉 탐색중 오류");
		}
	}
	
	//자신을 팔로잉하는 고양이들 출력
	@Override
	public List<Integer> searchFollowedCat(int follower_no) {
		try {
			List<Integer> list = dao.searchFollowedCat(follower_no);
			if(list==null) {
				throw new PleaseCatException("당신이 팔로잉하는 고양이가 없습니다.");
			}else {
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PleaseCatException("cat팔로잉 탐색중 오류");
		}
	}

	//cat 팔로우 하기
	@Override
	public void insertFollowingCat(int follower_no, int cat_no) {
		try {
			String answer = searchFollowingCat(follower_no, cat_no);
			if(answer=="execute") {
				map = new HashMap<String, Object>();
				map.put("follower_no", follower_no);
				map.put("cat_no", cat_no);
				dao.insertFollowingCat(map);
				System.out.println("cat 팔로우 누를게요~");
			}else {
				throw new PleaseCatException("이미 팔로우 눌렀습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PleaseCatException("cat 팔로우 실행중 오류");
		}

	}

	//cat 팔로우 취소
	@Override
	public void deleteFollowingCat(int follower_no, int cat_no) {
		try {
		String answer = searchFollowingCat(follower_no,cat_no);
		if(answer=="cancel") {
			map = new HashMap<String, Object>();
			map.put("follower_no", follower_no);
			map.put("cat_no", cat_no);
			dao.deleteFollowingCat(map);
			System.out.println("cat팔로잉 취소합니다.");
		}else {
			throw new PleaseCatException("cat 팔로잉을 먼저 하세요");
			}
		} catch (Exception e) {
		e.printStackTrace();
		throw new PleaseCatException("cat 팔로우 실행중 오류");
		}
	}
}
