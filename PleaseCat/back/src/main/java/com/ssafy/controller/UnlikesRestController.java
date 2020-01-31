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

import com.ssafy.model.service.UnlikesService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RequestMapping("/api/Unlikes")
@RestController
public class UnlikesRestController {
	
	@Autowired
	private UnlikesService unlikesService;
	
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
	
	@ApiOperation("회원번호와 게시물번호로 싫어요 여부를 찾는다.")
	@PostMapping("/searchUnlikes")
	public ResponseEntity<Map<String, Object>> searchUnlikes(@RequestParam int user_no, @RequestParam int post_no) throws Exception{
		return handleSuccess(unlikesService.searchUnlikes(user_no,post_no));
	}
	
	@ApiOperation("싫어요를 누른다")
	@PostMapping("/insert")
	public ResponseEntity<Map<String, Object>> insertUnlikes(@RequestParam int user_no, @RequestParam int post_no) throws Exception{
		unlikesService.insertUnlikes(user_no,post_no);
		return handleSuccess("싫어요 완료");
	}

	@ApiOperation("싫어요 취소")
	@DeleteMapping("/delete")
	public ResponseEntity<Map<String, Object>> deleteUnlikes(@RequestParam int user_no, @RequestParam int post_no) throws Exception{
		unlikesService.deleteUnlikes(user_no,post_no);
		return handleSuccess("싫어요 취소");
	}

}
