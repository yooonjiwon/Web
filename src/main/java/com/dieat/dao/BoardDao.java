package com.dieat.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.dieat.dto.Board;
import com.dieat.dto.BoardAttach;
import com.dieat.mapper.BoardMapper;

@Repository(value = "boardDao")
public class BoardDao {
	
	@Autowired
	@Qualifier("boardMapper")
	private BoardMapper boardMapper;

	public int insertBoard(Board board) {
		boardMapper.insertBoard(board);
		return board.getBoardNo();
	}
	

	public void insertBoardAttach(BoardAttach attach) {
		boardMapper.insertBoardAttach(attach);
		
	}

	public List<Board> selectBoardList2(int first, int last) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("first",first);
		params.put("last", last);
		
		List<Board> boards = boardMapper.selectBoardList(params);
		
		return boards;
	}

	public int getBoardCount() {
		int count = boardMapper.selectBoardCount();
		return count;
	}


	public List<Board> selectBoard() {
		List<Board> boards = boardMapper.selectBoardList2();
		return boards;
	}

}
