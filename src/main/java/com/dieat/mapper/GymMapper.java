package com.dieat.mapper;

import java.util.HashMap;
import java.util.List;

import com.dieat.dto.GymDto;

public interface GymMapper {
		
	void insertGym(GymDto gymDto);

	List<GymDto> selectGymList(HashMap<String, Object> params);
		
}
