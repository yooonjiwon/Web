package com.seoul.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.seoul.dto.ContactsAttach;
import com.seoul.dto.ContactsBoard;
import com.seoul.dto.ContactsComment;

public class ContactsBoardDao {
	
	public int insertBoard1(ContactsBoard board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		int newBoardNo = -1;
		try {
			conn = ConnectionHelper.getConnection("oracle");

			String sql = "INSERT INTO w_board (boardno, title, id, content, groupno, step, boardtype, password) " +
						 "VALUES (contactsboard_seq.nextval, ?, ?, ?, contactsboard_seq.currval, 1, 1, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getPassword());
			pstmt.executeUpdate();
			
			sql = "SELECT contactsboard_seq.currval FROM DUAL";
			pstmt2 = conn.prepareStatement(sql);
			rs = pstmt2.executeQuery();
			rs.next();
			newBoardNo = rs.getInt(1);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. ���� ����
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { pstmt2.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return newBoardNo;
	}
	
	public int insertBoard2(ContactsBoard board) {
		Connection conn = null;
		PreparedStatement pstmt = null;	//for insert
		PreparedStatement pstmt2 = null;//for select
		ResultSet rs = null;
		int newBoardNo = -1;
		try {
//			//1. Driver ���
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. ���� �����
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //������ 
//					"seoul", "789123");//��������
			conn = ConnectionHelper.getConnection("oracle");
			//3. SQL �ۼ� �� ��� �����
			String sql = "INSERT INTO w_board (boardno, title, id, content, groupno, step, boardtype, password) " +
						 "VALUES (contactsboard_seq.nextval, ?, ?, ?, contactsboard_seq.currval, 1, 2, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getPassword());
			//4. ��� ����
			pstmt.executeUpdate();//insert, update, delete ���� ���� �޼���
			
			//������ insert�� ���� �۹�ȣ ��ȸ
			//-> ���������� ȣ��� nextval�� ���� ��ȸ
			sql = "SELECT contactsboard_seq.currval FROM DUAL";
			pstmt2 = conn.prepareStatement(sql);
			rs = pstmt2.executeQuery();
			rs.next();
			newBoardNo = rs.getInt(1);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. ���� ����
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { pstmt2.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return newBoardNo;	
	}
	
	public int insertBoard3(ContactsBoard board) {
		Connection conn = null;
		PreparedStatement pstmt = null;	//for insert
		PreparedStatement pstmt2 = null;//for select
		ResultSet rs = null;
		int newBoardNo = -1;
		try {
//			//1. Driver ���
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. ���� �����
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //������ 
//					"seoul", "789123");//��������
			conn = ConnectionHelper.getConnection("oracle");
			//3. SQL �ۼ� �� ��� �����
			String sql = "INSERT INTO w_board (boardno, title, id, content, groupno, step, boardtype, password) " +
						 "VALUES (contactsboard_seq.nextval, ?, ?, ?, contactsboard_seq.currval, 1, 3, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getPassword());
			//4. ��� ����
			pstmt.executeUpdate();//insert, update, delete ���� ���� �޼���
			
			//������ insert�� ���� �۹�ȣ ��ȸ
			//-> ���������� ȣ��� nextval�� ���� ��ȸ
			sql = "SELECT contactsboard_seq.currval FROM DUAL";
			pstmt2 = conn.prepareStatement(sql);
			rs = pstmt2.executeQuery();
			rs.next();
			newBoardNo = rs.getInt(1);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. ���� ����
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { pstmt2.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return newBoardNo;	
	}
	
	public int insertBoard4(ContactsBoard board) {
		Connection conn = null;
		PreparedStatement pstmt = null;	//for insert
		PreparedStatement pstmt2 = null;//for select
		ResultSet rs = null;
		int newBoardNo = -1;
		try {
//			//1. Driver ���
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. ���� �����
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //������ 
//					"seoul", "789123");//��������
			conn = ConnectionHelper.getConnection("oracle");
			//3. SQL �ۼ� �� ��� �����
			String sql = "INSERT INTO w_board (boardno, title, id, content, groupno, step, boardtype, password) " +
						 "VALUES (contactsboard_seq.nextval, ?, ?, ?, contactsboard_seq.currval, 1, 4, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getPassword());
			//4. ��� ����
			pstmt.executeUpdate();//insert, update, delete ���� ���� �޼���
			
			//������ insert�� ���� �۹�ȣ ��ȸ
			//-> ���������� ȣ��� nextval�� ���� ��ȸ
			sql = "SELECT contactsboard_seq.currval FROM DUAL";
			pstmt2 = conn.prepareStatement(sql);
			rs = pstmt2.executeQuery();
			rs.next();
			newBoardNo = rs.getInt(1);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. ���� ����
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { pstmt2.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return newBoardNo;	
	}
	
	public List<ContactsBoard> selectBoard() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//��ȸ�� �����͸� ������ DTO ���� (���� ���̹Ƿ� �÷��� ����)
		ArrayList<ContactsBoard> boards = new ArrayList<>();
		
		try {
//			//1. Driver ���
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. ���� �����
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //������ 
//					"demoweb", "oracle");//��������
			conn = ConnectionHelper.getConnection("oracle");
			
			//3. SQL �ۼ� �� ��� �����
			String sql = "SELECT boardno, boardtitle, id, regdate, readcount, deleted, groupno, step, depth, boardtype" + 
						 "FROM w_board " +
						 "ORDER BY groupno DESC, step ASC ";
			pstmt = conn.prepareStatement(sql);
			//4. ��� ����
			rs = pstmt.executeQuery();//select ���� ���� �޼���
			//5. ����� ���� ��� ó��
			while (rs.next()) { //��ȸ�� �����Ͱ� �ִٸ� 
				ContactsBoard board = new ContactsBoard();
				board.setBoardNo(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setRegDate(rs.getDate(4));
				board.setReadCount(rs.getInt(5));
				board.setisDeleted(rs.getBoolean(6));
				board.setGroupNo(rs.getInt(7));
				board.setStep(rs.getInt(8));
				board.setDepth(rs.getInt(9));
				board.setBoardType(rs.getInt(10));
				boards.add(board);//�� �Խñ� �����͸� ��Ͽ� �߰�
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. ���� ����
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return boards;//��ȸ �����ϸ� ��� �ƴϸ� count�� 0
	}
	
	public List<ContactsBoard> selectBoardList1(int first, int last) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ContactsBoard> boards = new ArrayList<ContactsBoard>();
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			
			StringBuffer sql = new StringBuffer(500);
			sql.append("SELECT * ");
			sql.append("FROM ");
			
			sql.append("( ");
			sql.append("	SELECT "); 
			sql.append("		rownum idx, s.* "); 
			sql.append("	FROM ");
			
			sql.append("	( ");
			sql.append("		SELECT "); 
			sql.append("			boardno, title, id, ");
			sql.append("			regdate, readcount, ");
			sql.append("			deleted, groupno, step, depth, boardtype, password ");
			sql.append("		FROM ");
			sql.append("			w_board ");
			sql.append("		WHERE ");
			sql.append("			boardtype = '1' ");
			sql.append("		ORDER BY groupno DESC, step ASC ");
			sql.append("	) s ");
			
			sql.append(") ");
			
			sql.append("WHERE idx >= ? AND idx < ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, first);
			pstmt.setInt(2, last);
			rs = pstmt.executeQuery();			
			
			while (rs.next()) {
				ContactsBoard board = new ContactsBoard();
				board.setBoardNo(rs.getInt(2));
				board.setTitle(rs.getString(3));
				board.setWriter(rs.getString(4));
				board.setRegDate(rs.getDate(5));
				board.setReadCount(rs.getInt(6));
				board.setisDeleted(rs.getBoolean(7));
				board.setGroupNo(rs.getInt(8));
				board.setStep(rs.getInt(9));
				board.setDepth(rs.getInt(10));
				board.setBoardType(rs.getInt(11));
				board.setPassword(rs.getString(12));
				
				boards.add(board);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
		
		return boards;
	}
	
	public List<ContactsBoard> selectBoardList2(int first, int last) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ContactsBoard> boards = new ArrayList<ContactsBoard>();
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			
			StringBuffer sql = new StringBuffer(500);
			sql.append("SELECT * ");
			sql.append("FROM ");
			
			sql.append("( ");
			sql.append("	SELECT "); 
			sql.append("		rownum idx, s.* "); 
			sql.append("	FROM ");
			
			sql.append("	( ");
			sql.append("		SELECT "); 
			sql.append("			boardno, title, id, ");
			sql.append("			regdate, readcount, ");
			sql.append("			deleted, groupno, step, depth, boardtype, password ");
			sql.append("		FROM ");
			sql.append("			w_board ");
			sql.append("		WHERE ");
			sql.append("			boardtype = '2' ");
			sql.append("		ORDER BY groupno DESC, step ASC ");
			sql.append("	) s ");
			
			sql.append(") ");
			
			sql.append("WHERE idx >= ? AND idx < ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, first);
			pstmt.setInt(2, last);
			rs = pstmt.executeQuery();			
			
			while (rs.next()) {
				ContactsBoard board = new ContactsBoard();
				board.setBoardNo(rs.getInt(2));
				board.setTitle(rs.getString(3));
				board.setWriter(rs.getString(4));
				board.setRegDate(rs.getDate(5));
				board.setReadCount(rs.getInt(6));
				board.setisDeleted(rs.getBoolean(7));
				board.setGroupNo(rs.getInt(8));
				board.setStep(rs.getInt(9));
				board.setDepth(rs.getInt(10));
				board.setBoardType(rs.getInt(11));
				board.setPassword(rs.getString(12));
				
				boards.add(board);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
		
		return boards;
	}
	
	public List<ContactsBoard> selectBoardList3(int first, int last) {
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<ContactsBoard> boards = new ArrayList<ContactsBoard>();
			
			try {
				conn = ConnectionHelper.getConnection("oracle");
				
				StringBuffer sql = new StringBuffer(500);
				sql.append("SELECT * ");
				sql.append("FROM ");

				sql.append("( ");
				sql.append("	SELECT "); 
				sql.append("		rownum idx, s.* "); 
				sql.append("	FROM ");
				
				sql.append("	( ");
				sql.append("		SELECT "); 
				sql.append("			boardno, title, id, ");
				sql.append("			regdate, readcount, ");
				sql.append("			deleted, groupno, step, depth, boardtype, password ");
				sql.append("		FROM ");
				sql.append("			w_board ");
				sql.append("		WHERE ");
				sql.append("			boardtype = '3' ");
				sql.append("		ORDER BY groupno DESC, step ASC ");
				sql.append("	) s ");
				
				sql.append(") ");
				
				sql.append("WHERE idx >= ? AND idx < ?");
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setInt(1, first);
				pstmt.setInt(2, last);
				rs = pstmt.executeQuery();			
				
				while (rs.next()) {
					ContactsBoard board = new ContactsBoard();
					board.setBoardNo(rs.getInt(2));
					board.setTitle(rs.getString(3));
					board.setWriter(rs.getString(4));
					board.setRegDate(rs.getDate(5));
					board.setReadCount(rs.getInt(6));
					board.setisDeleted(rs.getBoolean(7));
					board.setGroupNo(rs.getInt(8));
					board.setStep(rs.getInt(9));
					board.setDepth(rs.getInt(10));
					board.setBoardType(rs.getInt(11));
					board.setPassword(rs.getString(12));
					
					boards.add(board);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
				if (conn != null) try { conn.close(); } catch (Exception ex) {}
			}
			
			return boards;
		}
	
	public List<ContactsBoard> selectBoardList4(int first, int last) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ContactsBoard> boards = new ArrayList<ContactsBoard>();
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			
			StringBuffer sql = new StringBuffer(500);
			sql.append("SELECT * ");
			sql.append("FROM ");
			
			sql.append("( ");
			sql.append("	SELECT "); 
			sql.append("		rownum idx, s.* "); 
			sql.append("	FROM ");
			
			sql.append("	( ");
			sql.append("		SELECT "); 
			sql.append("			boardno, title, id, ");
			sql.append("			regdate, readcount, ");
			sql.append("			deleted, groupno, step, depth, boardtype, password ");
			sql.append("		FROM ");
			sql.append("			w_board ");
			sql.append("		WHERE ");
			sql.append("			boardtype = '4' ");
			sql.append("		ORDER BY groupno DESC, step ASC ");
			sql.append("	) s ");
			
			sql.append(") ");
			
			sql.append("WHERE idx >= ? AND idx < ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, first);
			pstmt.setInt(2, last);
			rs = pstmt.executeQuery();			
			
			while (rs.next()) {
				ContactsBoard board = new ContactsBoard();
				board.setBoardNo(rs.getInt(2));
				board.setTitle(rs.getString(3));
				board.setWriter(rs.getString(4));
				board.setRegDate(rs.getDate(5));
				board.setReadCount(rs.getInt(6));
				board.setisDeleted(rs.getBoolean(7));
				board.setGroupNo(rs.getInt(8));
				board.setStep(rs.getInt(9));
				board.setDepth(rs.getInt(10));
				board.setBoardType(rs.getInt(11));
				board.setPassword(rs.getString(12));
				
				boards.add(board);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
		
		return boards;
	}
	
	public List<ContactsBoard> selectBoardList5(String search1, String search2, int first, int last) {
		
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<ContactsBoard> boards = new ArrayList<ContactsBoard>();
		
	try {
		conn = ConnectionHelper.getConnection("oracle");
			
		StringBuffer sql = new StringBuffer(500);
		sql.append("SELECT * ");
		sql.append("FROM ");
			
		sql.append("( ");
		sql.append("	SELECT "); 
		sql.append("		rownum idx, s.* "); 
		sql.append("	FROM ");
			
		sql.append("	( ");
		sql.append("		SELECT "); 
		sql.append("			boardno, title, id, ");
		sql.append("			regdate, readcount, ");
		sql.append("			deleted, groupno, step, depth, boardtype, content, password ");
		sql.append("		FROM ");
		sql.append("			w_board ");
		sql.append("		WHERE ");
		sql.append("			boardtype = '1' ");
		if (search1.equals("title")) {
			sql.append("		AND title LIKE ? ");
		} else if (search1.equals("content")) {
	//		sql.append("			deleted = '1' ");
			sql.append("		AND content LIKE ? ");
		} else if (search1.equals("id")) {
			sql.append("        AND id LIKE ? ");
		}
		sql.append("		ORDER BY groupno DESC, step ASC "); 
		sql.append("	) s ");
			
		sql.append(") ");
			
		sql.append("WHERE idx >= ? AND idx < ? ");
			
		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, "%" + search2 + "%");			
		pstmt.setInt(2, first);
		pstmt.setInt(3, last);
		rs = pstmt.executeQuery();			
			
		while (rs.next()) {
			ContactsBoard board = new ContactsBoard();
			board.setBoardNo(rs.getInt(2));
			board.setTitle(rs.getString(3));
			board.setWriter(rs.getString(4));
			board.setRegDate(rs.getDate(5));
			board.setReadCount(rs.getInt(6));
			board.setisDeleted(rs.getBoolean(7));
			board.setGroupNo(rs.getInt(8));
			board.setStep(rs.getInt(9));
			board.setDepth(rs.getInt(10));
			board.setBoardType(rs.getInt(11));
			board.setContent(rs.getString(12));
			board.setPassword(rs.getString(13));
			
			boards.add(board);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
		
		return boards;
	}
	
	public List<ContactsBoard> selectBoardList6(String search1, String search2, int first, int last) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ContactsBoard> boards = new ArrayList<ContactsBoard>();
			
		try {
			conn = ConnectionHelper.getConnection("oracle");
				
			StringBuffer sql = new StringBuffer(500);
			sql.append("SELECT * ");
			sql.append("FROM ");
				
			sql.append("( ");
			sql.append("	SELECT "); 
			sql.append("		rownum idx, s.* "); 
			sql.append("	FROM ");
				
			sql.append("	( ");
			sql.append("		SELECT "); 
			sql.append("			boardno, title, id, ");
			sql.append("			regdate, readcount, ");
			sql.append("			deleted, groupno, step, depth, boardtype, content, password ");
			sql.append("		FROM ");
			sql.append("			w_board ");
			sql.append("		WHERE ");
			sql.append("			boardtype = '2' ");
			if (search1.equals("title")) {
				sql.append("		AND title LIKE ? ");
			} else if (search1.equals("content")) {
		//		sql.append("			deleted = '1' ");
				sql.append("		AND content LIKE ? ");
			} else if (search1.equals("id")) {
				sql.append("        AND id LIKE ? ");
			}
			sql.append("		ORDER BY groupno DESC, step ASC "); 
			sql.append("	) s ");
				
			sql.append(") ");
				
			sql.append("WHERE idx >= ? AND idx < ? ");
				
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + search2 + "%");			
			pstmt.setInt(2, first);
			pstmt.setInt(3, last);
			rs = pstmt.executeQuery();			
				
			while (rs.next()) {
				ContactsBoard board = new ContactsBoard();
				board.setBoardNo(rs.getInt(2));
				board.setTitle(rs.getString(3));
				board.setWriter(rs.getString(4));
				board.setRegDate(rs.getDate(5));
				board.setReadCount(rs.getInt(6));
				board.setisDeleted(rs.getBoolean(7));
				board.setGroupNo(rs.getInt(8));
				board.setStep(rs.getInt(9));
				board.setDepth(rs.getInt(10));
				board.setBoardType(rs.getInt(11));
				board.setContent(rs.getString(12));
				board.setPassword(rs.getString(13));
				
				boards.add(board);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
				if (conn != null) try { conn.close(); } catch (Exception ex) {}
			}
			
			return boards;
		}
	
	public List<ContactsBoard> selectBoardList7(String search1, String search2, int first, int last) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ContactsBoard> boards = new ArrayList<ContactsBoard>();
			
		try {
			conn = ConnectionHelper.getConnection("oracle");
				
			StringBuffer sql = new StringBuffer(500);
			sql.append("SELECT * ");
			sql.append("FROM ");
				
			sql.append("( ");
			sql.append("	SELECT "); 
			sql.append("		rownum idx, s.* "); 
			sql.append("	FROM ");
				
			sql.append("	( ");
			sql.append("		SELECT "); 
			sql.append("			boardno, title, id, ");
			sql.append("			regdate, readcount, ");
			sql.append("			deleted, groupno, step, depth, boardtype, content, password ");
			sql.append("		FROM ");
			sql.append("			w_board ");
			sql.append("		WHERE ");
			sql.append("			boardtype = '3' ");
			if (search1.equals("title")) {
				sql.append("		AND title LIKE ? ");
			} else if (search1.equals("content")) {
		//		sql.append("			deleted = '1' ");
				sql.append("		AND content LIKE ? ");
			} else if (search1.equals("id")) {
				sql.append("        AND id LIKE ? ");
			}
			sql.append("		ORDER BY groupno DESC, step ASC "); 
			sql.append("	) s ");
				
			sql.append(") ");
				
			sql.append("WHERE idx >= ? AND idx < ? ");
				
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + search2 + "%");			
			pstmt.setInt(2, first);
			pstmt.setInt(3, last);
			rs = pstmt.executeQuery();			
				
			while (rs.next()) {
				ContactsBoard board = new ContactsBoard();
				board.setBoardNo(rs.getInt(2));
				board.setTitle(rs.getString(3));
				board.setWriter(rs.getString(4));
				board.setRegDate(rs.getDate(5));
				board.setReadCount(rs.getInt(6));
				board.setisDeleted(rs.getBoolean(7));
				board.setGroupNo(rs.getInt(8));
				board.setStep(rs.getInt(9));
				board.setDepth(rs.getInt(10));
				board.setBoardType(rs.getInt(11));
				board.setContent(rs.getString(12));
				board.setPassword(rs.getString(13));
				
				boards.add(board);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
				if (conn != null) try { conn.close(); } catch (Exception ex) {}
			}
			
			return boards;
		}
	
	public List<ContactsBoard> selectBoardList8(String search1, String search2, int first, int last) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ContactsBoard> boards = new ArrayList<ContactsBoard>();
			
		try {
			conn = ConnectionHelper.getConnection("oracle");
				
			StringBuffer sql = new StringBuffer(500);
			sql.append("SELECT * ");
			sql.append("FROM ");
				
			sql.append("( ");
			sql.append("	SELECT "); 
			sql.append("		rownum idx, s.* "); 
			sql.append("	FROM ");
				
			sql.append("	( ");
			sql.append("		SELECT "); 
			sql.append("			boardno, title, id, ");
			sql.append("			regdate, readcount, ");
			sql.append("			deleted, groupno, step, depth, boardtype, content, password ");
			sql.append("		FROM ");
			sql.append("			w_board ");
			sql.append("		WHERE ");
			sql.append("			boardtype = '4' ");
			if (search1.equals("title")) {
				sql.append("		AND title LIKE ? ");
			} else if (search1.equals("content")) {
		//		sql.append("			deleted = '1' ");
				sql.append("		AND content LIKE ? ");
			} else if (search1.equals("id")) {
				sql.append("        AND id LIKE ? ");
			}
			sql.append("		ORDER BY groupno DESC, step ASC "); 
			sql.append("	) s ");
				
			sql.append(") ");
				
			sql.append("WHERE idx >= ? AND idx < ? ");
				
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + search2 + "%");			
			pstmt.setInt(2, first);
			pstmt.setInt(3, last);
			rs = pstmt.executeQuery();			
				
			while (rs.next()) {
				ContactsBoard board = new ContactsBoard();
				board.setBoardNo(rs.getInt(2));
				board.setTitle(rs.getString(3));
				board.setWriter(rs.getString(4));
				board.setRegDate(rs.getDate(5));
				board.setReadCount(rs.getInt(6));
				board.setisDeleted(rs.getBoolean(7));
				board.setGroupNo(rs.getInt(8));
				board.setStep(rs.getInt(9));
				board.setDepth(rs.getInt(10));
				board.setBoardType(rs.getInt(11));
				board.setContent(rs.getString(12));
				board.setPassword(rs.getString(13));
				
				boards.add(board);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
				if (conn != null) try { conn.close(); } catch (Exception ex) {}
			}
			
			return boards;
		}
	
	public int getBoardCount1() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //������ 
//					"demoweb", "oracle");//��������
			conn = ConnectionHelper.getConnection("oracle");
			
			String sql = "SELECT COUNT(*) FROM w_board " +
						 "WHERE boardtype = '1' ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				count = rs.getInt(1);
			
		} catch (Exception ex) {
			count = 0;
			ex.printStackTrace();			
		} finally {
			try { if (rs != null) rs.close(); } catch (Exception ex) { }
			try { if (pstmt != null) pstmt.close(); } catch (Exception ex) { }
			try { if (conn != null) conn.close(); } catch (Exception ex) { }
		}
		return count;
	}
	
	public int getBoardCount2() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //������ 
//					"demoweb", "oracle");//��������
			conn = ConnectionHelper.getConnection("oracle");
			
			String sql = "SELECT COUNT(*) FROM w_board " +
						 "WHERE boardtype = '2' ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				count = rs.getInt(1);
			
		} catch (Exception ex) {
			count = 0;
			ex.printStackTrace();			
		} finally {
			try { if (rs != null) rs.close(); } catch (Exception ex) { }
			try { if (pstmt != null) pstmt.close(); } catch (Exception ex) { }
			try { if (conn != null) conn.close(); } catch (Exception ex) { }
		}
		return count;
	}
	
	public int getBoardCount3() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //������ 
//					"demoweb", "oracle");//��������
			conn = ConnectionHelper.getConnection("oracle");
			
			String sql = "SELECT COUNT(*) FROM w_board " +
						 "WHERE boardtype = '3' ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				count = rs.getInt(1);
			
		} catch (Exception ex) {
			count = 0;
			ex.printStackTrace();			
		} finally {
			try { if (rs != null) rs.close(); } catch (Exception ex) { }
			try { if (pstmt != null) pstmt.close(); } catch (Exception ex) { }
			try { if (conn != null) conn.close(); } catch (Exception ex) { }
		}
		return count;
	}
	
	public int getBoardCount4() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //������ 
//					"demoweb", "oracle");//��������
			conn = ConnectionHelper.getConnection("oracle");
			
			String sql = "SELECT COUNT(*) FROM w_board " +
						 "WHERE boardtype = '4' ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				count = rs.getInt(1);
			
		} catch (Exception ex) {
			count = 0;
			ex.printStackTrace();			
		} finally {
			try { if (rs != null) rs.close(); } catch (Exception ex) { }
			try { if (pstmt != null) pstmt.close(); } catch (Exception ex) { }
			try { if (conn != null) conn.close(); } catch (Exception ex) { }
		}
		return count;
	}
	
	public int getBoardCount5(String search1, String search2) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {

			conn = ConnectionHelper.getConnection("oracle");
			
			StringBuffer sql = new StringBuffer(500);
			sql.append("SELECT COUNT(*) FROM w_board " );
			if (search1.equals("title")) {
			sql.append("WHERE title LIKE ? AND boardtype = '1' ");
			} else if (search1.equals("content")) {
			sql.append("WHERE content LIKE ? AND boardtype = '1' ");
			} else if (search1.equals("id")) {
			sql.append("WHERE id LIKE ? AND boardtype = '1' ");
			}
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + search2 + "%");
			rs = pstmt.executeQuery();
	
			if (rs.next())
				count = rs.getInt(1);
			
			} catch (Exception ex) {
			count = 0;
			ex.printStackTrace();			
			} finally {
			try { if (rs != null) rs.close(); } catch (Exception ex) { }
			try { if (pstmt != null) pstmt.close(); } catch (Exception ex) { }
			try { if (conn != null) conn.close(); } catch (Exception ex) { }
		}
		return count;
	}
	
	public int getBoardCount6(String search1, String search2) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {

			conn = ConnectionHelper.getConnection("oracle");
			
			StringBuffer sql = new StringBuffer(500);
			sql.append("SELECT COUNT(*) FROM w_board " );
			if (search1.equals("title")) {
			sql.append("WHERE title LIKE ? AND boardtype = '2' ");
			} else if (search1.equals("content")) {
			sql.append("WHERE content LIKE ? AND boardtype = '2' ");
			} else if (search1.equals("id")) {
			sql.append("WHERE id LIKE ? AND boardtype = '2' ");
			}
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + search2 + "%");
			rs = pstmt.executeQuery();
	
			if (rs.next())
				count = rs.getInt(1);
			
			} catch (Exception ex) {
			count = 0;
			ex.printStackTrace();			
			} finally {
			try { if (rs != null) rs.close(); } catch (Exception ex) { }
			try { if (pstmt != null) pstmt.close(); } catch (Exception ex) { }
			try { if (conn != null) conn.close(); } catch (Exception ex) { }
		}
		return count;
	}
	
	public int getBoardCount7(String search1, String search2) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {

			conn = ConnectionHelper.getConnection("oracle");
			
			StringBuffer sql = new StringBuffer(500);
			sql.append("SELECT COUNT(*) FROM w_board " );
			if (search1.equals("title")) {
			sql.append("WHERE title LIKE ? AND boardtype = '3' ");
			} else if (search1.equals("content")) {
			sql.append("WHERE content LIKE ? AND boardtype = '3' ");
			} else if (search1.equals("id")) {
			sql.append("WHERE id LIKE ? AND boardtype = '3' ");
			}
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + search2 + "%");
			rs = pstmt.executeQuery();
	
			if (rs.next())
				count = rs.getInt(1);
			
			} catch (Exception ex) {
			count = 0;
			ex.printStackTrace();			
			} finally {
			try { if (rs != null) rs.close(); } catch (Exception ex) { }
			try { if (pstmt != null) pstmt.close(); } catch (Exception ex) { }
			try { if (conn != null) conn.close(); } catch (Exception ex) { }
		}
		return count;
	}
	
	public int getBoardCount8(String search1, String search2) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {

			conn = ConnectionHelper.getConnection("oracle");
			
			StringBuffer sql = new StringBuffer(500);
			sql.append("SELECT COUNT(*) FROM w_board " );
			if (search1.equals("title")) {
			sql.append("WHERE title LIKE ? AND boardtype = '4' ");
			} else if (search1.equals("content")) {
			sql.append("WHERE content LIKE ? AND boardtype = '4' ");
			} else if (search1.equals("id")) {
			sql.append("WHERE id LIKE ? AND boardtype = '4' ");
			}
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + search2 + "%");
			rs = pstmt.executeQuery();
	
			if (rs.next())
				count = rs.getInt(1);
			
			} catch (Exception ex) {
			count = 0;
			ex.printStackTrace();			
			} finally {
			try { if (rs != null) rs.close(); } catch (Exception ex) { }
			try { if (pstmt != null) pstmt.close(); } catch (Exception ex) { }
			try { if (conn != null) conn.close(); } catch (Exception ex) { }
		}
		return count;
	}
	
	public ContactsBoard selectBoardByBoardNo(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		ContactsBoard board = null;//��ȸ�� �����͸� ������ DTO ����
		
		try {
//			//1. Driver ���
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. ���� �����
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //������ 
//					"demoweb", "oracle");//��������
			conn = ConnectionHelper.getConnection("oracle");
			//3. SQL �ۼ� �� ��� �����
			String sql = "SELECT boardno, title, id, regdate, readcount, groupno, step, depth, content " + 
						 "FROM w_board " +
						 "WHERE boardno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			//4. ��� ����
			rs = pstmt.executeQuery();//select ���� ���� �޼���
			//5. ����� ���� ��� ó��
			while (rs.next()) { //��ȸ�� �����Ͱ� �ִٸ� 
				board = new ContactsBoard();
				board.setBoardNo(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setRegDate(rs.getDate(4));
				board.setReadCount(rs.getInt(5));
				board.setGroupNo(rs.getInt(6));
				board.setStep(rs.getInt(7));
				board.setDepth(rs.getInt(8));
				board.setContent(rs.getString(9));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. ���� ����
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return board;//��ȸ �����ϸ� Board �ƴϸ� null
	}
	
	
	public ArrayList<ContactsComment> selectCommentByBoardNo(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ContactsComment> comments = new ArrayList<>();
		
		try {
//			//1. Driver ���
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. ���� �����
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //������ 
//					"demoweb", "oracle");//��������
			conn = ConnectionHelper.getConnection("oracle");
			String sql = 
				"SELECT commentno, boardno, id, content, regdate " + 
				"FROM w_comment WHERE boardno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
				
			while (rs.next()) {
				ContactsComment comment = new ContactsComment();
				comment.setCommentNo(rs.getInt(1));
				comment.setBoardNo(rs.getInt(2));
				comment.setWriter(rs.getString(3));
				comment.setContent(rs.getString(4));
				comment.setRegDate(rs.getDate(5));
				comments.add(comment);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		return comments;
	}

	
	public void updateReadCount(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
//			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			conn = ConnectionHelper.getConnection("oracle");
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE w_board " +
						 "SET readcount = readcount + 1 " +
						 "WHERE boardno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
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
	
	public void updateBoard(ContactsBoard board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
//			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			conn = ConnectionHelper.getConnection("oracle");
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE w_board " +
						 "SET title = ?, content = ?, password = ? " +
						 "WHERE boardno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());			
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getPassword());
			pstmt.setInt(4, board.getBoardNo());
			
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
	
	public void deleteBoard(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
//			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			conn = ConnectionHelper.getConnection("oracle");
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE w_board " +
						 "SET deleted = '1' " +
						 "WHERE boardno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
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
	
	public void insertComment(ContactsComment comment) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {

			conn = ConnectionHelper.getConnection("oracle");
			String sql = 
				"INSERT INTO w_comment " +
				"(commentno, boardno, id, content) " +
				"VALUES (contactscomment_seq.nextVal, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comment.getBoardNo());
			pstmt.setString(2, comment.getWriter());
			pstmt.setString(3, comment.getContent());

			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
	}

	public void insertBoardAttach(ContactsAttach attach) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
//			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			conn = ConnectionHelper.getConnection("oracle");
			String sql = 
				"INSERT INTO w_attachment " + 
				"(attachno, boardno, savedfilename, userfilename) " +
				"VALUES (contactsattachment_seq.nextval, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,attach.getBoardNo());
			pstmt.setString(2, attach.getSavedFileName());
			pstmt.setString(3, attach.getUserFileName());
			pstmt.executeUpdate();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try { pstmt.close(); } catch (Exception ex) { }
			try { conn.close(); } catch (Exception ex) { }
		}		
		
	}
	
	public ArrayList<ContactsAttach> selectBoardAttachByBoardNo(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ContactsAttach> attachments = new ArrayList<ContactsAttach>();
		
		try {
//			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			conn = ConnectionHelper.getConnection("oracle");
			String sql = 
				"SELECT attachno, boardno, savedfilename, userfilename " + 
				"FROM w_attachment WHERE boardno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
				
			while (rs.next()) {
				ContactsAttach attachment = new ContactsAttach();
				attachment.setAttachNo(rs.getInt(1));
				attachment.setBoardNo(rs.getInt(2));
				attachment.setSavedFileName(rs.getString(3));
				attachment.setUserFileName(rs.getString(4));
				attachments.add(attachment);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		return attachments;
		
	}
	
	public ContactsAttach selectBoardAttachByAttachNo(int attachNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ContactsAttach attachment = null;
		
		try {
			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			conn = ConnectionHelper.getConnection("oracle");
			String sql = 
				"SELECT attachno, boardno, savedfilename, userfilename " + 
				"FROM w_attachment WHERE attachno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, attachNo);
			rs = pstmt.executeQuery();
				
			if (rs.next()) {
				attachment = new ContactsAttach();
				attachment.setAttachNo(rs.getInt(1));
				attachment.setBoardNo(rs.getInt(2));
				attachment.setSavedFileName(rs.getString(3));
				attachment.setUserFileName(rs.getString(4));
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		return attachment;
		
	}

		public void updateStep(int groupNo, int step) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
//			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			conn = ConnectionHelper.getConnection("oracle");
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE w_board " +
						 "SET step = step + 1 " +
						 "WHERE groupno = ? and step > ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, groupNo);
			pstmt.setInt(2, step);
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

		public void insertReply1(ContactsBoard board) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = ConnectionHelper.getConnection("oracle");
				
				String sql = "INSERT INTO w_board (boardno, title, id, content, groupno, step, depth, boardtype, password) " +
							 "VALUES (contactsboard_seq.nextval, ?, ?, ?, ?, ?, ?, 1, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getTitle());
				pstmt.setString(2, board.getWriter());
				pstmt.setString(3, board.getContent());
				pstmt.setInt(4, board.getGroupNo());
				pstmt.setInt(5, board.getStep());
				pstmt.setInt(6, board.getDepth());
				pstmt.setString(7, board.getPassword());
				
				pstmt.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				//6. 연결 종료
				try { pstmt.close(); } catch (Exception ex) {}
				try { conn.close(); } catch (Exception ex) {}
			}		
			
		}
		
		public void insertReply2(ContactsBoard board) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = ConnectionHelper.getConnection("oracle");
				
				String sql = "INSERT INTO w_board (boardno, title, id, content, groupno, step, depth, boardtype, password) " +
							 "VALUES (contactsboard_seq.nextval, ?, ?, ?, ?, ?, ?, 2, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getTitle());
				pstmt.setString(2, board.getWriter());
				pstmt.setString(3, board.getContent());
				pstmt.setInt(4, board.getGroupNo());
				pstmt.setInt(5, board.getStep());
				pstmt.setInt(6, board.getDepth());
				pstmt.setString(7, board.getPassword());
				
				pstmt.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				//6. 연결 종료
				try { pstmt.close(); } catch (Exception ex) {}
				try { conn.close(); } catch (Exception ex) {}
			}		
			
		}
		
		public void insertReply3(ContactsBoard board) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = ConnectionHelper.getConnection("oracle");
				
				String sql = "INSERT INTO w_board (boardno, title, id, content, groupno, step, depth, boardtype, password) " +
							 "VALUES (contactsboard_seq.nextval, ?, ?, ?, ?, ?, ?, 3, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getTitle());
				pstmt.setString(2, board.getWriter());
				pstmt.setString(3, board.getContent());
				pstmt.setInt(4, board.getGroupNo());
				pstmt.setInt(5, board.getStep());
				pstmt.setInt(6, board.getDepth());
				pstmt.setString(7, board.getPassword());
				
				pstmt.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				//6. 연결 종료
				try { pstmt.close(); } catch (Exception ex) {}
				try { conn.close(); } catch (Exception ex) {}
			}		
			
		}
		
		public void insertReply4(ContactsBoard board) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = ConnectionHelper.getConnection("oracle");
				
				String sql = "INSERT INTO w_board (boardno, title, id, content, groupno, step, depth, boardtype, password) " +
							 "VALUES (contactsboard_seq.nextval, ?, ?, ?, ?, ?, ?, 4, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getTitle());
				pstmt.setString(2, board.getWriter());
				pstmt.setString(3, board.getContent());
				pstmt.setInt(4, board.getGroupNo());
				pstmt.setInt(5, board.getStep());
				pstmt.setInt(6, board.getDepth());
				pstmt.setString(7, board.getPassword());
				
				pstmt.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				//6. 연결 종료
				try { pstmt.close(); } catch (Exception ex) {}
				try { conn.close(); } catch (Exception ex) {}
			}		
			
		}
		
		public void updateComment(ContactsComment comment) {
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = ConnectionHelper.getConnection("oracle");
				
				String sql = 
					"UPDATE w_comment " +
					"SET content = ?" +
					"WHERE commentno = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, comment.getContent());
				pstmt.setInt(2, comment.getCommentNo());

				pstmt.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
				if (conn != null) try { conn.close(); } catch (Exception ex) {}
			}
		}

		public void deleteComment(int commentNo) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = ConnectionHelper.getConnection("oracle");
			
				String sql = 
					"DELETE FROM w_comment " +				
					"WHERE commentno = ?";
				pstmt = conn.prepareStatement(sql);			
				pstmt.setInt(1, commentNo);

				pstmt.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
				if (conn != null) try { conn.close(); } catch (Exception ex) {}
			}
		}

		public String checkPassword(int boardNo) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String password = null;
			try {
				conn = ConnectionHelper.getConnection("oracle");
				
				String sql =
						"SELECT password " +
						"FROM w_board " +
						"WHERE boardNo = ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, boardNo);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					password = rs.getString(1);
				}
				
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				//6. ���� ����
				try { rs.close(); } catch (Exception ex) {}
				try { pstmt.close(); } catch (Exception ex) {}
				try { conn.close(); } catch (Exception ex) {}
			}

			return password;//��ȸ �����ϸ� ��� �ƴϸ� count�� 0
			
			}
				
}
