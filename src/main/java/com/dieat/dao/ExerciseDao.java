package com.dieat.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.dieat.dto.Board;
import com.dieat.dto.BoardAttach;
import com.dieat.dto.Exercise;
import com.dieat.mapper.BoardMapper;
import com.dieat.mapper.ExerciseMapper;

@Repository(value = "exerciseDao")
public class ExerciseDao {
	
	@Autowired
	@Qualifier("exerciseMapper")
	private ExerciseMapper exerciseMapper;

	public void writeWeight(Exercise weight) {
		exerciseMapper.writeWeigh(weight);
	}
	
	
	
}
