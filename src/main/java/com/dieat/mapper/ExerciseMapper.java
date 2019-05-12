package com.dieat.mapper;
import java.util.HashMap;
import java.util.List;

import com.dieat.dto.Board;
import com.dieat.dto.BoardAttach;
import com.dieat.dto.Exercise;

public interface ExerciseMapper {
	List<Board> selectBoardList(HashMap<String, Object> params);
	int selectBoardCount();
	
	void insertBoard(Board board);
	void insertBoard2(Board board);
	void insertBoardAttach(BoardAttach attach);
	List<Board> selectBoardList2();
	void writeWeigh(Exercise weight);	 
	
}
