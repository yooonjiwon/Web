package com.dieat.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.dieat.dto.Workout;
import com.dieat.mapper.WorkoutMapper;

/**
 * 운동방법 게시판 Dao
 * @author Jiwon
 */

@Repository(value = "workoutDao")
public class WorkoutDao {
	
	@Autowired
	@Qualifier("workoutMapper")
	private WorkoutMapper workoutMapper;

//	public List<Workout> selectWorkoutList(int first, int last) {
//		HashMap<String, Object> params = new HashMap<>();
//		params.put("first", first);
//		params.put("last", last);
//		List<Workout> workouts = workoutMapper.findWorkoutList(params);
//		System.out.println(workouts.get(1).toString());
//		return workouts;
//	}

//	public int insertWorkout(Workout workout) {
//		workoutMapper.insertWorkout(workout);
//		return workout.getBoardNo();
//	}

//	public int getBoardCount() {
//		int count = workoutMapper.selectBoardCount();
//		return count;
//	}

	
}