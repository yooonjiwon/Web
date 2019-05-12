package com.dieat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dieat.dto.Workout;
import com.dieat.service.WorkoutService;
import com.dieat.ui.ThePager;

@Controller
@RequestMapping(value = "/workout")
public class WorkoutController {
	
//	@Autowired
//	@Qualifier("workoutService")
//	private WorkoutService workoutService;
	
	@RequestMapping(value = "/workoutlist.action", method = RequestMethod.GET)
	private String workoutlist(){
//			@RequestParam(value = "pageno", required = false) Integer pageNo, 
//			Model model) {
//		System.out.println("운동방법");
//		if (pageNo == null) {
//			pageNo = 1;
//		}
//		
//		int pageSize = 5;
//		int pagerSize = 3;
//		int boardCount = 0;
//		String linkUrl = "workoutlist.action";
//		int first = (pageNo - 1) * pageSize + 1;
//		int last = first + pagerSize;
//		
//		List<Workout> workouts = workoutService.findBoardList(first, last);
//		
//		ThePager pager = new ThePager(boardCount, pageNo,
//				pageSize, pagerSize, linkUrl);
//		
//		model.addAttribute("workouts", workouts);		
//		model.addAttribute("pageno", pageNo);
//		model.addAttribute("pager", pager);
		
		return "workout/workoutlist";
	
	}
	
	@RequestMapping(value = "/workoutwrite.action", method = RequestMethod.GET)
	private String workoutwrite(){
		return "workout/workoutwrite";
	}
	
//	@RequestMapping(value ="/workoutwrite.action", method = RequestMethod.POST)
//	private String workoutwriteForm() {
//		return "workout/workoutwrite";
//	}

}
