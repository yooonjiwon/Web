package com.dieat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.dieat.dao.BoardDao;
import com.dieat.dto.Board;
import com.dieat.dto.BoardAttach;

@Service(value = "boardService")
public class BoardService {
	
	@Autowired
	@Qualifier("boardDao")
	private BoardDao boardDao;
	
	@Autowired
	@Qualifier("txManager")
	private PlatformTransactionManager txManager;
	
	@Autowired
	@Qualifier("txTemplate")
	private TransactionTemplate txTemplate;
	
	
	
	public int writeBoard(Board board) {
		
		Integer newBoardNo = 0;
		txTemplate.execute(new TransactionCallback<Void>() {
			
			@Override
			public Void doInTransaction(TransactionStatus ts) {
				try {
					int BoardNo = boardDao.insertBoard(board);
					for (BoardAttach attach : board.getAttachments()){
						attach.setBoardNo(BoardNo);
						boardDao.insertBoardAttach(attach);
					}
				} catch (Exception ex) {
					ts.setRollbackOnly();
				}
				return null;
			}
		});
		return newBoardNo;
	}

	public int getBoardCount() {
		int count = boardDao.getBoardCount();
		return count;
	}



	public List<Board> findBoardList(int first, int last) {
		List<Board> boards = boardDao.selectBoardList2(first, last);
		return boards;
	}

}
