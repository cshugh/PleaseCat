package com.ssafy.model.service;

import java.util.HashMap; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.RankingDao;
import com.ssafy.model.dto.PleaseCatException;
import com.ssafy.model.dto.ranking;


@Service
public class RankingServiceImp implements RankingService {

	@Autowired
	private RankingDao dao;
	
	HashMap<String, Object> map;
	
	public ranking searchRanking(int cat_no, int user_no) {
		try {
			map = new HashMap<String, Object>();
			map.put("cat_no", cat_no);
			map.put("user_no", user_no);
			
			ranking find = dao.searchRanking(map);
			
			if(find==null) {
				throw new PleaseCatException("랭크시스템에 없음");
			}else {
				return find;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PleaseCatException("rank 탐색중 오류");
		}
	}
	
	//cat_no 로 회원목록 출력
	@Override
	public List<ranking> searchRankingCat(int cat_no) {
		try {
			List<ranking> list = dao.searchRankingCat(cat_no);
			if(list==null) {
				throw new PleaseCatException("고양이 점수를 가진 회원들이 없음");
			}else {
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PleaseCatException("rank 탐색중 오류");
		}
	}

	//new rank 추가
	@Override
	public void insertRanking(int cat_no, int user_no) {
		try {
			ranking find = searchRanking(cat_no, user_no);
			if(find==null) {
				map = new HashMap<String, Object>();
				map.put("cat_no", cat_no);
				map.put("user_no", user_no);
				dao.insertRanking(map);
				System.out.println("new Rank 등록");
			}else {
				throw new PleaseCatException("이미 존재합니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PleaseCatException("rank 실행중 오류");
		}

	}

	//랭크 삭제
	@Override
	public void deleteRanking(int cat_no, int user_no) {
		try {
		ranking find = searchRanking(cat_no, user_no);
		if(find!=null) {
			map = new HashMap<String, Object>();
			map.put("cat_no", cat_no);
			map.put("user_no", user_no);
			dao.deleteRanking(map);
			System.out.println("rank 삭제합니다.");
		}else {
			throw new PleaseCatException("삭제할 rank가 존재하지 않습니다.");
			}
		} catch (Exception e) {
		e.printStackTrace();
		throw new PleaseCatException("rank 실행중 오류");
		}
	}
	
	// rank점수 수정
	public void updateRanking(int cat_no, int user_no, int rank_point) {
		try {
			ranking find = searchRanking(cat_no, user_no);
			if(find==null) {
				throw new PleaseCatException("수정할 rank가 존재하지 않습니다.");
			}else {
				map = new HashMap<String, Object>();
				map.put("cat_no", cat_no);
				map.put("user_no", user_no);
				map.put("rank_point", rank_point);
				
				dao.updateRanking(map);
				System.out.println("ranking 점수를 수정했습니다.");
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new PleaseCatException("rank 실행중 오류");
			}
	}
}
