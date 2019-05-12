package com.dieat.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.dieat.dto.FoodInfo;
import com.dieat.mapper.FoodInfoMapper;
/**
 * 음식 정보 입력 DAO
 * @author HSL
 *
 */
@Repository(value = "foodInfoDao")
public class FoodInfoDao {
	
	@Autowired
	@Qualifier("foodInfoMapper")
	private FoodInfoMapper foodInfoMapper;

	public void registFoodInfo(FoodInfo foodInfo) {		
		foodInfoMapper.registFoodInfo(foodInfo);		
	}

	public List<FoodInfo> selectFoodList(int first, int last) {
		
		HashMap<String, Object> params = new HashMap<>();
		params.put("first", first);
		params.put("last", last);
		
		List<FoodInfo> foods = foodInfoMapper.selectFoodList(params);
		
		return foods;
	}

	public int getFoodCount() {
		int count = foodInfoMapper.selectFoodCount();
		return count;
	}

	public List<FoodInfo> selectFoodNameList(){
		System.out.println("START!");	
		List<FoodInfo> foods = foodInfoMapper.selectFoodNameList();			
		return foods;
	}


}
