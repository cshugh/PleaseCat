package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.cat;

@Repository
@Mapper
public interface CatDao {
	public cat searchCat(int no);
	public List<cat> searchAllCat();
	public void insertCat(cat cat);
	public void updateCat(cat cat);
	public void deleteCat(int no);
}
