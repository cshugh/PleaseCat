package com.ssafy.model.service;

import java.util.List; 

import com.ssafy.model.dto.post;

public interface PostService {
	public post searchPost(int no);
	public List<post> searchPostUser(int no);
	public List<post> searchPostCat(int no);
	public List<post> searchAllPost();
	public void insertPost(post user);
	public void updatePost(post user);
	public void deletePost(int no);
}
