package com.ssafy.controller;

import java.util.HashMap;     
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ssafy.model.dto.user;
import com.ssafy.model.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RequestMapping("/api/user")
@RestController
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
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
	
	@ApiOperation("새로운 유저 정보를 입력한다.")
	@PostMapping("/insert")
	public ResponseEntity<Map<String, Object>> insertUser(@RequestBody user User) throws Exception{
		userService.insertUser(User);
		return handleSuccess("유저 등록 완료");
	}
	
	@ApiOperation("회원 관리번호로 회원 정보를 찾는다.")
	@GetMapping("/searchUserNo")
	public ResponseEntity<Map<String, Object>> searchUser(@RequestParam int user_no) throws Exception{
		return handleSuccess(userService.searchUser(user_no));
	}
	
	@ApiOperation("회원 이메일로 회원 정보를 찾는다.")
	@GetMapping("/searchUserEmail")
	public ResponseEntity<Map<String, Object>> searchUserEmail(@RequestParam String user_email) throws Exception{
		return handleSuccess(userService.searchUserEmail(user_email));
	}
	
	@ApiOperation("모든 회원 정보를 찾는다.")
	@GetMapping("/searchAll")
	public ResponseEntity<Map<String, Object>> searchAllUser() throws Exception{
		return handleSuccess(userService.searchAllUser());
	}
	
	@ApiOperation("로그인 처리")
	@GetMapping("/login")
	public ResponseEntity<Map<String, Object>> searchUser(@RequestParam String user_email, @RequestParam String user_pw ) throws Exception{
		return handleSuccess(userService.login(user_email,user_pw));
	}
	
	@ApiOperation("회원정보 삭제")
	@DeleteMapping("/delete")
	public ResponseEntity<Map<String, Object>> deleteUser(@RequestParam int user_no) throws Exception{
		userService.deleteUser(user_no);
		return handleSuccess(user_no+"번 회원삭제완료");
	}
	
	@ApiOperation("회원정보를 수정")
	@PutMapping("/update")
	public ResponseEntity<Map<String, Object>> updateUser(@RequestBody user User) throws Exception{
		userService.updateUser(User);
		return handleSuccess("회원 수정완료");
	}
	
}
