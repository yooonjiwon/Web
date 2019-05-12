package com.dieat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import com.dieat.dto.FoodInfo;
import com.dieat.dto.Menu;
import com.dieat.service.FoodInfoService;
import com.dieat.ui.ThePager;
/**
 * Header에서 식단을 클릭시<br>
 * 일어나는 전반의 기능을 관리하는 컨트롤러<br>
 * @author HSL
 *
 */
@Controller
@RequestMapping(value = "/foodinfo")
public class FoodInfoController {
	
	@Autowired
	@Qualifier("foodInfoService")
	private FoodInfoService foodInfoService;
	
	//식품 등록 페이지로 이동
	@RequestMapping(value = "/registerfood.action", method = RequestMethod.GET)
	public String registerForm(){
		
		return "foodinfo/registerfood";}	
	
	//식품 등록 양식 작성 후 DB에 입력
	@RequestMapping(value = "/registerfood.action", method = RequestMethod.POST)
	public String register(FoodInfo foodInfo){		
		foodInfo.setFoodName(foodInfo.getFoodName());
		System.out.println(foodInfo.getFoodName());
		foodInfoService.registFoodInfo(foodInfo);
		return "foodinfo/menupage";}	
	
	//식단 클릭 후 식단 하부 페이지로 이동
	@RequestMapping(value = "/menupage.action", method = RequestMethod.GET)
	public String openMenuPage(){
		return "foodinfo/menupage";
	}
	
	//식단 등록 페이지로 이동
	@RequestMapping(value="/registermenu.action", method = RequestMethod.GET)
	public String registerMenuForm(){
		return "foodinfo/registermenu";
	}
	
	//식품 리스트 페이지로 이동
	@RequestMapping(value="/registermenu.action", method = RequestMethod.POST)
	public String registerMenu(HttpServletRequest req, HttpServletResponse resp, Menu menu){
		return "foodinfo/registermenu";
	}
	
	@RequestMapping(value="/foodlist.action", method = RequestMethod.GET)
	public String foodList( 	
		@RequestParam(value = "pageno", required = false) Integer pageNo, 
		Model model) {
		if (pageNo == null) {
			pageNo = 1;
		}
		
		int pageSize = 5;
		int pagerSize = 3;
		int foodCount = 0;
		String linkUrl = "foodlist.action";
		int first = (pageNo - 1) * pageSize + 1;
		int last = first + pageSize;
		
		List<FoodInfo> foods = foodInfoService.findFoodList(first, last);
		
		foodCount = foodInfoService.getFoodCount();
		ThePager pager = new ThePager(foodCount, pageNo,
				pageSize, pagerSize, linkUrl);
		
		model.addAttribute("foods", foods);		
		model.addAttribute("pageno", pageNo);
		model.addAttribute("pager", pager);
		
		return "foodinfo/foodlist";
	}
}
