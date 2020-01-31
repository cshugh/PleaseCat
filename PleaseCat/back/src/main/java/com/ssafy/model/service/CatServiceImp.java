package com.ssafy.model.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.CatDao;
import com.ssafy.model.dto.PleaseCatException;
import com.ssafy.model.dto.cat;


@Service
public class CatServiceImp implements CatService {
	
	@Autowired
	private CatDao dao;

	//고양이 찾기
	public cat searchCat(int no) {
		try { 
			cat find = dao.searchCat(no);
			if(find == null) {
				throw new PleaseCatException("찾으려는 정보가 없습니다");
		
			} else {
				return find;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PleaseCatException();
		}
	}


	//고양이 등록
	public void insertCat(cat Cat) {
		try {
			cat find = dao.searchCat(Cat.getCat_no());
			if(find != null) {
				throw new PleaseCatException();
			}else {
				dao.insertCat(Cat);
				System.out.println("cat 입력 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PleaseCatException();
		}
	}

	
	//고양이 정보수정
	public void updateCat(cat Cat) {
		try {
				searchCat(Cat.getCat_no());
				dao.updateCat(Cat);
				System.out.println("고양이 업데이트 성공");
		} catch (Exception e) {
			e.printStackTrace();
			throw new PleaseCatException();
		}
	}


	//고양이 정보 삭제
	public void deleteCat(int no) {
		try {
			searchCat(no); //없으면 오류나는 내용이 작성되어있음
			dao.deleteCat(no);
			System.out.println(no+"번 Cat 삭제를 완료했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new PleaseCatException();
		}

	}


	//고양이 전체목록
	public List<cat> searchAllCat() {
		try { 
			return dao.searchAllCat();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PleaseCatException("고양이 전체 목록을 불러오는데 실패했습니다.");
		}
	}

}
