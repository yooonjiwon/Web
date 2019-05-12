package com.dieat.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dieat.dto.GymDto;
import com.dieat.ui.ThePager;
import com.dieat.service.GymService;

@Controller
@RequestMapping(value = "/gym")
public class GymController {
	
	@Autowired
	@Qualifier("gymService")
	private GymService gymService;
	
	@RequestMapping(value = { "/gym.action" }, method = RequestMethod.GET)
	public String gymlist(@RequestParam(value = "pageno", required = false) Integer pageNo, Model model) {
		
			if (pageNo == null) {
				pageNo = 1;
			}
			
			int pageSize = 5;
			int pagerSize = 3;
			int boardCount = 0;
			String linkUrl = "gym.action";
			int first = (pageNo - 1) * pageSize + 1;
			int last = first + pageSize;
			
			List<GymDto> gymlist = gymService.selectGymList(first, last);
			
			ThePager pager = new ThePager(boardCount, pageNo,
			pageSize, pagerSize, linkUrl);
			
			model.addAttribute("gymlist", gymlist);
			model.addAttribute("pageno", pageNo);
			model.addAttribute("pager", pager);
			
			return "gym/gym";
		
	}
	
}
