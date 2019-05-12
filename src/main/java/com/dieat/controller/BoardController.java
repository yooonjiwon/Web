package com.dieat.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dieat.common.Util;
import com.dieat.dto.Board;
import com.dieat.dto.BoardAttach;
import com.dieat.service.BoardService;
import com.dieat.ui.ThePager;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;
	
	@RequestMapping(value = "/list.action", method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "pageno", required = false) Integer pageNo,
			Model model) {
		if (pageNo == null) {
			pageNo = 1;
		}
		
		int pageSize = 5;
		int pagerSize = 3;
		int boardCount = 0;
		String linkUrl = "list.action";
		int first = (pageNo -1) * pageSize +1;
		int last = first + pageSize;
		
		List<Board> boards = boardService.findBoardList(first, last);
		
		boardCount = boardService.getBoardCount();
		ThePager pager = new ThePager(boardCount, pageNo, pageSize,pagerSize,linkUrl);
		
		model.addAttribute("boards",boards);
		model.addAttribute("pageno",pageNo);
		model.addAttribute("pager",pager);
		
		return "board/list";
}
	
	@RequestMapping(value = "/write.action", method = RequestMethod.GET)
	public String writeForm() {
		
		return "board/write";
	}
	
	@RequestMapping(value = "/write.action", method = RequestMethod.POST)
	public String write(
			MultipartHttpServletRequest req, Board board) {
		
		BoardAttach attach = null;
		ArrayList<BoardAttach> attachments = new ArrayList<>();
		
		MultipartFile file = req.getFile("attach");
		if (!file.isEmpty() && file.getOriginalFilename().length() !=0) {
			String path = req.getServletContext().getRealPath("/WEB-INF/upload");
			String savedFileName = file.getOriginalFilename();
			savedFileName = Util.makeUniqueFileName(savedFileName);
			try {
				file.transferTo(new File(path, savedFileName));
				attach = new BoardAttach();
				attach.setSavedFileName(savedFileName);
				attach.setUserFileName(file.getOriginalFilename());
				
				attachments.add(attach);
			} catch(Exception ex) {}
		}
		
		//DB에 데이터 저장
		board.setAttachments(attachments);
		
		boardService.writeBoard(board);
		
		return "redirect:list.action";
	}
			
}