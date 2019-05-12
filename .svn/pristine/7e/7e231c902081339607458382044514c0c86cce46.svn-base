package com.seoul.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.seoul.dto.TureCommenteCount;
import com.seoul.dto.TureMember;

public class TourMemberDao {

	public void insertMember(TureMember member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {			
			conn = ConnectionHelper.getConnection("oracle");
			//3. SQL 작성 및 명령 만들기
			String sql = "INSERT INTO member (memberid, passwd, email) " +
						 "VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getEmail());
			//4. 명령 실행
			pstmt.executeUpdate();//insert, update, delete 구문 실행 메서드
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}		
	}

	public TureMember selectMemberByIdAndPasswd(String memberId, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TureMember member = null;//조회된 데이터를 저장할 DTO 변수
		try {
			conn = ConnectionHelper.getConnection("oracle");
			//3. SQL 작성 및 명령 만들기
			String sql = "SELECT m_memberid, m_passport FROM member WHERE m_memberid = ? AND m_passwd = ?";
						 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, passwd);
			//4. 명령 실행
			rs = pstmt.executeQuery();//select 구문 실행 메서드
			//5. 결과가 있을 경우 처리
			if (rs.next()) { //조회된 데이터가 있다면 
				member = new TureMember();
				member.setMemberId(rs.getString(1));
				member.setPassNo(rs.getString(2));
				
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return member;//조회 성공하면 조회된 데이터 아니면 null
	}

	public TureCommenteCount readCount(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TureCommenteCount count = null;//조회된 데이터를 저장할 DTO 변수
		try {
			conn = ConnectionHelper.getConnection("oracle");
			//3. SQL 작성 및 명령 만들기
			String sql = "SELECT COUNT(TBC_NO) FROM H_BOARDCOMMENT WHERE m_memberid = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			//4. 명령 실행
			rs = pstmt.executeQuery();//select 구문 실행 메서드
			//5. 결과가 있을 경우 처리
			if (rs.next()) { //조회된 데이터가 있다면 
				count = new TureCommenteCount();
				count.setCount(rs.getInt(1));
				
				
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return count;//조회 성공하면 조회된 데이터 아니면 null
	}

}
