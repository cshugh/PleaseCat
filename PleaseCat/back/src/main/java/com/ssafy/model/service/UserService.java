package com.ssafy.model.service;

import java.util.List; 

import com.ssafy.model.dto.user;

public interface UserService  {
	public user searchUser(int no) ;
	public void insertUser(user User) ;
	public void updateUser(user User);
	public void deleteUser(int no);
	public List<user> searchAllUser();
	public user searchUserEmail(String user_email);
	public boolean login(String user_email, String user_pw);

}
