package com.ssafy.model.dao;

import java.util.List; 

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.post;

@Repository
@Mapper
public interface PostDao {
	public post searchPost(int no);
	public List<post> searchPostUser(int no);
	public List<post> searchPostCat(int no);
	public List<post> searchAllPost();
	public void insertPost(post user);
	public void updatePost(post user);
	public void deletePost(int no);
}
