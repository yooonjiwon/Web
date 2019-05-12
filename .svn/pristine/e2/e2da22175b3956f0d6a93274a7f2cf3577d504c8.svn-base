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
import com.dieat.dao.ExerciseDao;
import com.dieat.dto.Board;
import com.dieat.dto.BoardAttach;
import com.dieat.dto.Exercise;

@Service(value = "exerciseService")
public class ExerciseService {
	
	@Autowired
	@Qualifier("exerciseDao")
	private ExerciseDao exerciseDao;
	
	@Autowired
	@Qualifier("txManager")
	private PlatformTransactionManager txManager;
	
	@Autowired
	@Qualifier("txTemplate")
	private TransactionTemplate txTemplate;

	public void writeWeight(Exercise weight) {
		exerciseDao.writeWeight(weight);
		
	}
	
	
		

}
