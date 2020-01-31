package com.ssafy.model.service;


public interface LikesService {
	public String searchLikes(int user_no, int post_no);
	public void insertLikes(int user_no, int post_no);
	public void deleteLikes(int user_no, int post_no);
}
