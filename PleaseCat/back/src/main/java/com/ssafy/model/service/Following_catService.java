package com.ssafy.model.service;

import java.util.List;

public interface Following_catService {
	
	public String searchFollowingCat(int follower_no, int cat_no);
	public List<Integer> searchFollowerCat(int cat_no);
	public List<Integer> searchFollowedCat(int follower_no);
	public void insertFollowingCat(int follower_no, int cat_no);
	public void deleteFollowingCat(int follower_no, int cat_no);

}
