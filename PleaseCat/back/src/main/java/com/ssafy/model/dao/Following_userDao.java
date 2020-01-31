package com.ssafy.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.following_user;

@Repository
@Mapper
public interface Following_userDao {
	public following_user searchFollowingUser(HashMap<String, Object> map);
	public List<Integer> searchFollowerUser(int follower_no);
	public List<Integer> searchFollowedUser(int followed_no);
	public void insertFollowingUser(HashMap<String, Object> map);
	public void deleteFollowingUser(HashMap<String, Object> map);

}
