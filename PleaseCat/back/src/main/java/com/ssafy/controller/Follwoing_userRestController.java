package com.ssafy.controller;

import java.util.HashMap;  
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.service.Following_userService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RequestMapping("/api/FollwoingUser")
@RestController
public class Follwoing_userRestController {
	
	@Autowired
	private Following_userService followingUserService;
	
	@ExceptionHandler
	public ResponseEntity<Map<String, Object>> handle(Exception e){
		return handleFail(e.getMessage(), HttpStatus.OK);
	}
	
	public ResponseEntity<Map<String, Object>> handleSuccess(Object data){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("state", "ok");
		resultMap.put("data", data);
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
	
	public ResponseEntity<Map<String, Object>> handleFail(Object data, HttpStatus state){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("state", "fail");
		resultMap.put("data", data);
		return new ResponseEntity<Map<String,Object>>(resultMap, state); 
	}
	
	@ApiOperation("follower, followed no로 팔로잉 여부 확인")
	@PostMapping("/searchFollwoingUser")
	public ResponseEntity<Map<String, Object>> searchFollwoingUser(@RequestParam int follower_no, @RequestParam int followed_no) throws Exception{
		return handleSuccess(followingUserService.searchFollowingUser(follower_no,followed_no));
	}
	
	@ApiOperation("follower no로 팔로잉 목록 출력")
	@PostMapping("/searchFollwerUser")
	public ResponseEntity<Map<String, Object>> searchFollwerUser(@RequestParam int follower_no) throws Exception{
		return handleSuccess(followingUserService.searchFollowerUser(follower_no));
	}
	
	@ApiOperation("followed no로 팔로잉 목록 출력")
	@PostMapping("/searchFollowedUser")
	public ResponseEntity<Map<String, Object>> searchFollowedUser(@RequestParam int followed_no) throws Exception{
		return handleSuccess(followingUserService.searchFollowedUser(followed_no));
	}
	
	@ApiOperation("팔로잉 하기")
	@PostMapping("/insert")
	public ResponseEntity<Map<String, Object>> insertFollowingUser(@RequestParam int follower_no, @RequestParam int followed_no) throws Exception{
		followingUserService.insertFollowingUser(follower_no,followed_no);
		return handleSuccess("following OK");
	}

	@ApiOperation("팔로잉 취소")
	@DeleteMapping("/delete")
	public ResponseEntity<Map<String, Object>> deleteFollowingUser(@RequestParam int follower_no, @RequestParam int followed_no) throws Exception{
		followingUserService.deleteFollowingUser(follower_no,followed_no);
		return handleSuccess("following cancel");
	}

}
