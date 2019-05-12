package com.dieat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dieat.dto.Exercise;
import com.dieat.dao.ExerciseDao;
import com.dieat.service.ExerciseService;
/**
 * Weight-Exercise list, write
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/exercise")
public class ExerciseController {
	
	@Autowired
	@Qualifier("exerciseService")
	private ExerciseService exerciseService;
	
	@RequestMapping(value = "/weight-list.action", method = RequestMethod.GET)
	public String list() {
		return "exercise/weight-list";
	}
	
	@RequestMapping(value = "/weight-write.action", method = RequestMethod.GET)
	public String writeFrom() {
		return "exercise/weight-write";
	}
	
	@RequestMapping(value = "/weight-write.action", method = RequestMethod.POST)
	public String write(Exercise weight) {		
		exerciseService.writeWeight(weight);		
		return "exercise/weight-write";
	}
	
}