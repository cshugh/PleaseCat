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

import com.ssafy.model.dto.cat;
import com.ssafy.model.service.CatService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RequestMapping("/api/cat")
@RestController
public class CatRestController {
	
	@Autowired
	private CatService catService;
	
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
	
	@ApiOperation("새로운 고양이 정보를 입력한다.")
	@PostMapping("/insert")
	public ResponseEntity<Map<String, Object>> insertCat(@RequestBody cat Cat) throws Exception{
		catService.insertCat(Cat);
		return handleSuccess("고양이 등록 완료");
	}
	
	@ApiOperation("고양이 관리번호로 고양이 정보를 찾는다.")
	@GetMapping("/searchCat")
	public ResponseEntity<Map<String, Object>> searchCat(@RequestParam int cat_no) throws Exception{
		return handleSuccess(catService.searchCat(cat_no));
	}

	@ApiOperation("모든 고양이를 찾는다.")
	@GetMapping("/searchAll")
	public ResponseEntity<Map<String, Object>> searchAllCat() throws Exception{
		return handleSuccess(catService.searchAllCat());
	}
	
	@ApiOperation("고양이 정보 삭제")
	@DeleteMapping("/delete")
	public ResponseEntity<Map<String, Object>> deleteCat(@RequestParam int cat_no) throws Exception{
		catService.deleteCat(cat_no);
		return handleSuccess(cat_no+"번 고양이 삭제완료");
	}
	
	@ApiOperation("cat를 수정")
	@PutMapping("/update")
	public ResponseEntity<Map<String, Object>> updateCat(@RequestBody cat Cat) throws Exception{
		catService.updateCat(Cat);
		return handleSuccess("고양이 정보 수정완료");
	}
	
}
