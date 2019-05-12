package com.dieat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dieat.dao.FoodInfoDao;
import com.dieat.dto.FoodInfo;

@Service(value = "foodInfoService")
public class FoodInfoService {

	@Autowired
	@Qualifier("foodInfoDao")
	private FoodInfoDao foodInfoDao;	
	
	public void registFoodInfo(FoodInfo foodInfo) {		
		foodInfoDao.registFoodInfo(foodInfo);		
	}

	public List<FoodInfo> findFoodList(int first, int last) {

		List<FoodInfo> foods = foodInfoDao.selectFoodList(first, last);
		return foods;
	}

	public int getFoodCount() {
		int count = foodInfoDao.getFoodCount();
		return count;
	}

	

}
