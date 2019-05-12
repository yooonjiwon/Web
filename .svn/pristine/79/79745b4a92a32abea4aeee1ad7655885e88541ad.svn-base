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
import com.seoul.dto.GuideSub;
import com.seoul.guideservlet.GuideFileUploadServlet;

public class GuideSubDao {

	public void insertSub(GuideSub guideSub) {

		Connection conn = null;
		PreparedStatement pstmt = null; //for insert
		int newBoardNo = -1; //-1은 임의의값. 0도 상관없음
		
		//데이터베이스 연동 코드를 입력하는곳(JDBC코드 입력)
		try {
			/*//1. 드라이버 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123"); //계정정보
*/			
			conn = ConnectionHelper.getConnection("oracle");
			

			
			
			
			//3. SQL작성 및 명령 만들기
			String sql = "INSERT INTO j_subbook (sub_subno, sub_writer, sub_phone, sub_email, sub_copies1, sub_copies2, sub_addr1, sub_addr2, sub_cause) " //***groupno중요****/
						+ "VALUES (subbook_seq.nextVal,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			//VALUES 의 ? ? ? 에 들어갈 내용
			pstmt.setString(1,guideSub.getSub_Writer());
			pstmt.setString(2,guideSub.getSub_Phone());
			pstmt.setString(3,guideSub.getSub_Email());
			pstmt.setString(4,guideSub.getSub_Copies1());
			pstmt.setString(5,guideSub.getSub_Copies2());
			pstmt.setString(6,guideSub.getSub_Addr1());
			pstmt.setString(7,guideSub.getSub_Addr2());
			pstmt.setString(8,guideSub.getSub_Cause());
			//4. 명령 실행
			pstmt.executeUpdate(); //insert, update, delete 구문 실행 메서드
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//5. 연결 종료
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
			
		}
		
	}

	
}

