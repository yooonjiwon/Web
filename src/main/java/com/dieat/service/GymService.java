package com.dieat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dieat.dao.GymDao;
import com.dieat.dto.GymDto;

@Service(value = "gymService")
public class GymService {

	@Autowired
	@Qualifier("gymDao")
	private GymDao gymDao;

	
	public List<GymDto> selectGymList(int first, int last) {
		List<GymDto> gymlist = gymDao.selectGymList(first, last);
		return gymlist;
	}
	
}
