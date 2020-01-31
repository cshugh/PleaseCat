package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.cat;

public interface CatService {
	public cat searchCat(int no);
	public void insertCat(cat Cat);
	public void updateCat(cat Cat);
	public void deleteCat(int no);
	public List<cat> searchAllCat();
}
