package com.dieat.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.dieat.dao.WorkoutDao;
import com.dieat.dto.Workout;

@Service(value = "workoutService")
public class WorkoutService {

	@Autowired
	@Qualifier("workoutDao")
	private WorkoutDao workoutDao;

	
//	public List<Workout> findBoardList(int first, int last) {
//		List<Workout> workouts = workoutDao.selectWorkoutList(first, last);
//		return workouts;
//	}

//	public int getBoardCount() {
//	int count = workoutDao.getBoardCount();
//	return count;
//}
		
	}