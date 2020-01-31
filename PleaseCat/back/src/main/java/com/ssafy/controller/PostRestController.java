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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.post;
import com.ssafy.model.service.PostService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RequestMapping("/api/post")
@RestController
public class PostRestController {
	
	@Autowired
	private PostService postService;
	
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
	
	@ApiOperation("새로운 게시글 정보를 등록한다.")
	@PostMapping("/insert")
	public ResponseEntity<Map<String, Object>> insertPost(@RequestBody post Post) throws Exception{
		postService.insertPost(Post);
		return handleSuccess("게시글 등록 완료");
	}
	
	@ApiOperation("게시글 관리번호로 게시글 정보를 찾는다.")
	@GetMapping("/searchPost/{Post_no}")
	public ResponseEntity<Map<String, Object>> searchPost(@RequestParam int Post_no) throws Exception{
		return handleSuccess(postService.searchPost(Post_no));
	}
	
	@ApiOperation("회원 관리번호로 게시글 정보를 찾는다.")
	@GetMapping("/searchPostUser/{User_no}")
	public ResponseEntity<Map<String, Object>> searchPostUser(@RequestParam int User_no) throws Exception{
		return handleSuccess(postService.searchPostUser(User_no));
	}
	
	@ApiOperation("고양이 관리번호로 게시글 정보를 찾는다.")
	@GetMapping("/searchPostCat/{Cat_no}")
	public ResponseEntity<Map<String, Object>> searchPostCat(@RequestParam int Cat_no) throws Exception{
		return handleSuccess(postService.searchPostCat(Cat_no));
	}

	@ApiOperation("모든 게시글을 찾는다.")
	@GetMapping("/searchAll")
	public ResponseEntity<Map<String, Object>> searchAllPost() throws Exception{
		return handleSuccess(postService.searchAllPost());
	}
	
	@ApiOperation("게시글 정보 삭제")
	@DeleteMapping("/delete/{Post_no}")
	public ResponseEntity<Map<String, Object>> deletePost(@RequestParam int Post_no) throws Exception{
		postService.deletePost(Post_no);
		return handleSuccess(Post_no+"번 게시글 삭제완료");
	}
	
	@ApiOperation("게시글을 수정")
	@PutMapping("/update")
	public ResponseEntity<Map<String, Object>> updatePost(@RequestBody post Post) throws Exception{
		postService.updatePost(Post);
		return handleSuccess("게시글 정보 수정완료");
	}
	
}
