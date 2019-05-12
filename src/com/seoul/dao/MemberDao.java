package com.seoul.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.seoul.dto.Guide;
import com.seoul.dto.Member;

public class MemberDao {
	
	public void insertMember(Member member) {	//회원가입 Dao
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = ConnectionHelper.getConnection("oracle");
			String sql = "INSERT INTO member (m_memberid, m_name, m_passwd, m_email, m_birthday, m_country_code, m_phone, m_gender, m_nation, m_interest) VALUES (?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPasswd());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getBirthday());
			pstmt.setString(6, member.getCountry_code());
			pstmt.setString(7, member.getPhone());
			pstmt.setString(8, member.getGender());
			pstmt.setString(9, member.getNation());
			pstmt.setString(10, member.getInterest());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception ex) {
			}
			try {
				pstmt.close();
			} catch (Exception ex) {
			}
		}

	}
	
	public Member selectMemberByIdAndPasswd(String memberId, String passwd) { // 로그인 Dao
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "SELECT m_memberid, m_name, m_email, m_birthday, m_country_code, m_phone, m_gender, m_nation, m_interest,m_passport,m_nickname FROM member WHERE m_memberid= ? AND m_passwd= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString(1));
				member.setName(rs.getString(2));
				member.setEmail(rs.getString(3));
				member.setBirthday(rs.getString(4));
				member.setCountry_code(rs.getString(5));
				member.setPhone(rs.getString(6));
				member.setGender(rs.getString(7));
				member.setNation(rs.getString(8));
				member.setInterest(rs.getString(9));
				member.setPassNo(rs.getString(10));
				member.setNickName(rs.getString(11));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception ex) {
			}
			try {
				pstmt.close();
			} catch (Exception ex) {
			}
			try {
				rs.close();
			} catch (Exception ex) {
			}
		}

		return member;
	}
	

	public int selectCountByMemberId(String memberId) { //아이디 중복검사 Dao
		int rst = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "SELECT count(*) FROM member where m_memberid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rst = rs.getInt(1); //가져온 memberid
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception ex) {
			}
			try {
				pstmt.close();
			} catch (Exception ex) {
			}
			try {
				rs.close();
			} catch (Exception ex) {
			}
		}
		return rst;
	}

	public void updateMember(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			// SQL 작성 및 명령 만들기
			String sql = "UPDATE member SET m_name =?, m_email =?, m_birthday=?, m_country_code=?, m_phone=?, m_gender=?, m_nation=?, m_interest=? where m_memberid=?";
						 
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getBirthday());
			pstmt.setString(4, member.getCountry_code());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getGender());
			pstmt.setString(7, member.getNation());
			pstmt.setString(8, member.getInterest());
			pstmt.setString(9, member.getMemberId());
			
			//명령 실행
			pstmt.executeUpdate();  //insert,update, delete 구문 실행 메서드
			//결과가 있을 경우 처리
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//연결 종료
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}	
	}

	public Member selectMemberByMemberId(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Member bringinfo = null;
		ResultSet rs = null;

		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "SELECT m_name, m_email, m_birthday, m_country_code, m_phone, m_gender, m_nation, m_interest FROM member WHERE m_memberid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				bringinfo = new Member();
				bringinfo.setName(rs.getString(1));
				bringinfo.setEmail(rs.getString(2));
				bringinfo.setBirthday(rs.getString(3));
				bringinfo.setCountry_code(rs.getString(4));
				bringinfo.setPhone(rs.getString(5));
				bringinfo.setGender(rs.getString(6));
				bringinfo.setNation(rs.getString(7));
				bringinfo.setInterest(rs.getString(8));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		return bringinfo;
	}

	
	
		
	}
	 	
