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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.service.RankingService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RequestMapping("/api/Ranking")
@RestController
public class RankingRestController {
	
	@Autowired
	private RankingService rankingService;
	
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
	
	@ApiOperation("rank에 존재하는 여부확인")
	@PostMapping("/searchRanking")
	public ResponseEntity<Map<String, Object>> searchRanking(@RequestParam int cat_no, @RequestParam int user_no) throws Exception{
		return handleSuccess(rankingService.searchRanking(cat_no,user_no));
	}
	
	@ApiOperation("고양이에 해당하는 ranking")
	@PostMapping("/searchRankingCat")
	public ResponseEntity<Map<String, Object>> searchRankingCat(@RequestParam int cat_no) throws Exception{
		return handleSuccess(rankingService.searchRankingCat(cat_no));
	}

	
	@ApiOperation("new Ranking")
	@PostMapping("/insert")
	public ResponseEntity<Map<String, Object>> insertRanking(@RequestParam int cat_no, @RequestParam int user_no) throws Exception{
		rankingService.insertRanking(cat_no,user_no);
		return handleSuccess("ranking Insert Ok");
	}

	@ApiOperation("Ranking 삭제")
	@DeleteMapping("/delete")
	public ResponseEntity<Map<String, Object>> deleteRanking(@RequestParam int cat_no, @RequestParam int user_no) throws Exception{
		rankingService.deleteRanking(cat_no,user_no);
		return handleSuccess("ranking delete");
	}
	
	@ApiOperation("Ranking 점수 수정")
	@PutMapping("/update")
	public ResponseEntity<Map<String, Object>> updateRanking(@RequestParam int cat_no, @RequestParam int user_no, @RequestParam int rank_point) throws Exception{
		rankingService.updateRanking(cat_no,user_no,rank_point);
		return handleSuccess("ranking update");
	}

}
