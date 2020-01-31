package com.ssafy.model.service;


public interface UnlikesService {
	public String searchUnlikes(int user_no, int post_no);
	public void insertUnlikes(int user_no, int post_no);
	public void deleteUnlikes(int user_no, int post_no);
}
