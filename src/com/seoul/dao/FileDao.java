package com.seoul.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.seoul.dao.ConnectionHelper;
import com.seoul.dto.Guide;
import com.seoul.dto.GuideBoardAttach;
import com.seoul.dto.GuideBoardComment;
import com.seoul.dto.GuideFile;
import com.seoul.guideservlet.GuideFileUploadServlet;

public class FileDao {

	

	public int insertFile1(GuideFile guideFile) {
		int re = -1;
		

		Connection conn = null;
		PreparedStatement pstmt = null;

		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			
			String sql = "insert into j_file(file_no, file_savedname, file_username) " +
			 "values(file_seq.nextVal,?,?) ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, guideFile.getFile_SavedName());
			pstmt.setString(2, guideFile.getFile_UserName());
			re = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}

		return re;
	}


	public GuideFile selectFileNo(int file_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GuideFile guideFile = null;
		
	try {
		/* 커넥션이용해서 아래 한줄로 줄임
		 * //1. 드라이버 등록
		Class.forName("oracle.jdbc.OracleDriver");
		//2. 연결 만들기
		conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
				"demoweb", "oracle"); //계정정보
		 */			
		
		conn = ConnectionHelper.getConnection("oracle");
		
		String sql = 
			"SELECT file_no, file_savedname " + 
			"FROM j_file WHERE file_no = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, file_no);
		rs = pstmt.executeQuery();
			
		if (rs.next()) {
			guideFile = new GuideFile();
			guideFile.setFile_No(rs.getInt(1));
			guideFile.setFile_SavedName(rs.getString(2));
			
		}
	} catch (Exception ex) {
		ex.printStackTrace();
	} finally {
		try { rs.close(); } catch (Exception ex) {}
		try { pstmt.close(); } catch (Exception ex) {}
		try { conn.close(); } catch (Exception ex) {}
	}
	return guideFile;
	}
	}
	

	
	
