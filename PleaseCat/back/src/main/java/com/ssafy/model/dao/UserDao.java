package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.user;

@Repository
@Mapper
public interface UserDao {
	public user searchUser(int no);
	public void insertUser(user user);
	public void updateUser(user user);
	public void deleteUser(int no);
	public List<user> searchAllUser();
	public user searchUserEmail(String user_email);

}
