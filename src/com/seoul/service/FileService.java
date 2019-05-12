package com.seoul.service;

import java.util.ArrayList;
import java.util.List;

import com.seoul.dao.FileDao;
import com.seoul.dao.GuideBoardDao;
import com.seoul.dao.GuideSubDao;
import com.seoul.dto.Guide;
import com.seoul.dto.GuideBoardAttach;
import com.seoul.dto.GuideBoardComment;
import com.seoul.dto.GuideFile;
import com.seoul.dto.GuideSub;
import com.seoul.guideservlet.GuideFileUploadServlet;


public class FileService {

	
	public void insertFile(GuideFile guideFile) {
		FileDao fileDao = new FileDao();
		fileDao.insertFile1(guideFile);
	}

	public GuideFile findFileNo(int file_no) {
		FileDao fileDao = new FileDao();
		GuideFile guideFile = fileDao.selectFileNo(file_no);
		return guideFile;
	}

	


}
