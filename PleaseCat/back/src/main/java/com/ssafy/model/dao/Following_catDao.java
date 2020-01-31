package com.ssafy.model.dao;

import java.util.HashMap; 
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.following_cat;


@Repository
@Mapper
public interface Following_catDao {
	public following_cat searchFollowingCat(HashMap<String, Object> map);
	public List<Integer> searchFollowerCat(int cat_no);
	public List<Integer> searchFollowedCat(int follower_no);
	public void insertFollowingCat(HashMap<String, Object> map);
	public void deleteFollowingCat(HashMap<String, Object> map);
}
