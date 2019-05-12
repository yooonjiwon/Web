package com.dieat.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.dieat.dto.GymDto;
import com.dieat.mapper.GymMapper;

@Repository( value = "gymDao" )
public class GymDao {

	@Autowired
	@Qualifier("gymMapper")
	private GymMapper gymMapper;

	public List<GymDto> selectGymList(int first, int last) {
		
		HashMap<String, Object> params = new HashMap<>();
		params.put("first", first);
		params.put("last", last);
		
		List<GymDto> gymlist = gymMapper.selectGymList(params);
		
		return gymlist;
	}
	

}
