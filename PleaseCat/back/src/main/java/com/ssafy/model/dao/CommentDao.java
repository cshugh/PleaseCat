package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.comment;

@Repository
@Mapper
public interface CommentDao {
	public comment searchComment(int no);
	public List<comment> searchCommentUser(int no);
	public List<comment> searchCommentPost(int no);
	public void insertComment(comment comment);
	public void updateComment(comment comment);
	public void deleteComment(int no);
}
