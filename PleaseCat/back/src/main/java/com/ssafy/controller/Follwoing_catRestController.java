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

import com.ssafy.model.service.Following_catService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RequestMapping("/api/FollwoingCat")
@RestController
public class Follwoing_catRestController {
	
	@Autowired
	private Following_catService followingCatService;
	
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
	
	@ApiOperation("follower, cat no로 팔로잉 여부 확인")
	@PostMapping("/searchFollwoingCat")
	public ResponseEntity<Map<String, Object>> searchFollwoingCat(@RequestParam int follower_no, @RequestParam int cat_no) throws Exception{
		return handleSuccess(followingCatService.searchFollowingCat(follower_no,cat_no));
	}
	
	@ApiOperation("cat no로 팔로워 목록 출력")
	@PostMapping("/searchFollwerCat")
	public ResponseEntity<Map<String, Object>> searchFollwerCat(@RequestParam int cat_no) throws Exception{
		return handleSuccess(followingCatService.searchFollowerCat(cat_no));
	}
	
	@ApiOperation("follower no로 cat 목록 출력")
	@PostMapping("/searchFollowedCat")
	public ResponseEntity<Map<String, Object>> searchFollwedCat(@RequestParam int follower_no) throws Exception{
		return handleSuccess(followingCatService.searchFollowedCat(follower_no));
	}
	
	@ApiOperation("cat 팔로잉 하기")
	@PostMapping("/insert")
	public ResponseEntity<Map<String, Object>> insertFollowingCat(@RequestParam int follower_no, @RequestParam int cat_no) throws Exception{
		followingCatService.insertFollowingCat(follower_no,cat_no);
		return handleSuccess("following OK");
	}

	@ApiOperation("팔로잉 취소")
	@DeleteMapping("/delete")
	public ResponseEntity<Map<String, Object>> deleteFollowingCat(@RequestParam int follower_no, @RequestParam int cat_no) throws Exception{
		followingCatService.deleteFollowingCat(follower_no,cat_no);
		return handleSuccess("following cancel");
	}

}
