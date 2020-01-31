package com.ssafy.model.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.likes;

@Repository
@Mapper
public interface LikesDao {
	//public likes searchLikes(int user_no, int post_no);
	public likes searchLikes(HashMap<String, Object> map);
	public void insertLikes(HashMap<String, Object> map);
	public void deleteLikes(HashMap<String, Object> map);

}
