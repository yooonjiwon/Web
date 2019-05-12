package com.dieat.mapper;

import java.util.HashMap;
import java.util.List;

import com.dieat.dto.FoodInfo;
/**
 * 식품 정보 입력을 위한 DAO mapper<br>
 * @author HSL
 *
 */
public interface FoodInfoMapper {	            

	
	void registFoodInfo(FoodInfo foodInfo);
	
	List<FoodInfo> selectFoodList(HashMap<String, Object> params);
	
	int selectFoodCount();

	List<FoodInfo> selectFoodNameList();

	
}
