package com.ssafy.model.dao;

import java.util.HashMap; 
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.ranking;

@Repository
@Mapper
public interface RankingDao {
	public ranking searchRanking(HashMap<String, Object> map);
	public List<ranking> searchRankingCat(int cat_no);
	public void insertRanking(HashMap<String, Object> map);
	public void updateRanking(HashMap<String, Object> map);
	public void deleteRanking(HashMap<String, Object> map);
}
