package com.ssafy.model.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.PostDao;
import com.ssafy.model.dto.PleaseCatException;
import com.ssafy.model.dto.post;

@Service
public class PostServiceImp implements PostService {
	
	@Autowired
	private PostDao dao;

	//게시물 번호로 게시물 1개 검색
	@Override
	public post searchPost(int no) {
		try { 
			post find = dao.searchPost(no);
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

	//회원번호로 회원의 여러게시물 검색
	@Override
	public List<post> searchPostUser(int no) {
		System.out.println(no);
		try { 
			System.out.println("try들어옴");
			List<post> finds = dao.searchPostUser(no);
			System.out.println(finds+"finds결과");
			if(finds == null) {
				throw new PleaseCatException("찾으려는 정보가 없습니다");
		
			} else {
				return finds;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PleaseCatException();
		}
	}

	//고양이번호로 고양이의 여러게시물 검색
	@Override
	public List<post> searchPostCat(int no) {
		try { 
			List<post> finds = dao.searchPostUser(no);
			if(finds == null) {
				throw new PleaseCatException("찾으려는 정보가 없습니다");
		
			} else {
				return finds;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PleaseCatException();
		}
	}

	//모든 게시물 출력
	@Override
	public List<post> searchAllPost() {
		try { 
			return dao.searchAllPost();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PleaseCatException("게시글 전체 목록을 불러오는데 실패했습니다.");
		}
	}
	

	//게시글 등록
	@Override
	public void insertPost(post Post) {
		try {
			post find = dao.searchPost(Post.getPost_no());
			if(find==null) {
			dao.insertPost(Post);
			System.out.println("게시글 입력 성공");
			}else{
				throw new PleaseCatException("게시글이 존재합니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PleaseCatException();
		}
		
	}

	//게시글 수정
	@Override
	public void updatePost(post Post) {
		try {
			searchPost(Post.getCat_no());
			dao.updatePost(Post);
			System.out.println("게시글 업데이트 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PleaseCatException();
		}
		
	}

	//게시글 삭제
	@Override
	public void deletePost(int no) {
		try {
			searchPost(no);
			dao.deletePost(no);
			System.out.println(no+"번 게시글 삭제를 완료했습니다.");
		} catch(Exception e) {
			e.printStackTrace();
			throw new PleaseCatException();
		}	
	}



}
