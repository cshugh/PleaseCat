package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.ranking;


public interface RankingService {
	
	public ranking searchRanking(int cat_no, int user_no);
	public List<ranking> searchRankingCat(int cat_no);
	public void insertRanking(int cat_no, int user_no);
	public void updateRanking(int cat_no, int user_no, int rank_point);
	public void deleteRanking(int cat_no, int user_no);

}
