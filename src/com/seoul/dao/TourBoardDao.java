package com.seoul.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.seoul.dto.Member;
import com.seoul.dto.TureBoard;
import com.seoul.dto.TureBoardAttach;
import com.seoul.dto.TureBoardComment;
import com.seoul.dto.TureMember;

public class TourBoardDao {

	public int insertBoard(TureBoard board) {
		Connection conn = null;
		PreparedStatement pstmt = null;//for insert
		PreparedStatement pstmt2 = null;//for select 글 작성 후 바로 작성된 번호를 가져오기 위함
		ResultSet rs = null;
		int newBoardNo = -1;
		try {
			conn = ConnectionHelper.getConnection("oracle");
//			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "INSERT INTO h_board (tb_no, tb_title, m_memberid, tb_content, tb_groupno, tb_step, tb_passno, tb_location, tb_time, tb_day) " +
						 "VALUES (guideboard_seq.nextval, ?, ?, ?, guideboard_seq.currval, 1, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getPassNo());
			pstmt.setString(5, board.getLocation());
			pstmt.setString(6, board.getTime());
			pstmt.setString(7, board.getDay());
			//4. 명령 실행
			pstmt.executeUpdate();//insert, update, delete 구문 실행 메서드
			//마지막으로 호출된 NEXTVAL의 값을 조회>>글쓰기에서 생성된 글 번호를 가져와야 파일저장가능(자동증가된 값)
			sql="SELECT guideboard_seq.currval FROM DUAL";
					pstmt2 = conn.prepareStatement(sql);
			rs = pstmt2.executeQuery();
			rs.next();
			newBoardNo = rs.getInt(1);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
			try { pstmt.close(); } catch (Exception ex) {}
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt2.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}		
		
		return newBoardNo; 
	}

	public List<TureBoard> selectBoard(/*int first, int last*/) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//조회된 데이터를 저장할 DTO 변수 (여러 건이므로 컬렉션 형식)
		ArrayList<TureBoard> boards = new ArrayList<>();
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			
			//3. SQL 작성 및 명령 만들기
			String sql = "SELECT tb_no, tb_title, m_memberid, tb_regdate, tb_deleted, tb_groupno, tb_depth, tb_passno " + 
						 "FROM h_board ORDER BY tb_groupno DESC";
			
//			String sql = "SELECT * FROM(SELECT rownum idx, s.* FROM (SELECT tb_no, tb_title, m_memberid, tb_regdate, tb_deleted, tb_groupno, tb_depth, tb_passno " + 
//			"FROM h_board ORDER BY tb_groupno DESC)s) WHERE idx >= ? AND idx < ?";
			
			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, first);
//			pstmt.setInt(2, last);
			//4. 명령 실행
			rs = pstmt.executeQuery();//select 구문 실행 메서드
			//5. 결과가 있을 경우 처리
			while (rs.next()) { //조회된 데이터가 있다면 
				TureBoard board = new TureBoard();
				board.setBoardNo(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setRegDate(rs.getDate(4));
				board.setDelated(rs.getBoolean(5));
				board.setGroupNo(rs.getInt(6));
				board.setDepth(rs.getInt(7));
				board.setPassNo(rs.getString(8));
				boards.add(board);//각 게시글 데이터를 목록에 추가
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return boards;//조회 성공하면 목록 아니면 count가 0
	}


	public TureBoard selectBoardByBoardNo(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//조회된 데이터를 저장할 DTO
		TureBoard board = null;
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "SELECT tb_no, tb_title, m_memberid, tb_regdate, tb_groupno, tb_step, tb_depth, tb_content, tb_location, tb_time, tb_day " + 
						 "FROM h_board WHERE tb_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			//Where 에 대응하는 변수 설정^
			//4. 명령 실행
			rs = pstmt.executeQuery();//select 구문 실행 메서드
			//5. 결과가 있을 경우 처리
			while (rs.next()) { //조회된 데이터가 있다면 
				board = new TureBoard();
				board.setBoardNo(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setRegDate(rs.getDate(4));
				board.setGroupNo(rs.getInt(5));
				board.setStep(rs.getInt(6));
				board.setDepth(rs.getInt(7));
				board.setContent(rs.getString(8));
				board.setLocation(rs.getString(9));
				board.setTime(rs.getString(10));
				board.setDay(rs.getString(11));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return board;//조회 성공하면 목록 아니면 count가 0
	}

	public void updateBoard(TureBoard board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionHelper.getConnection("oracle");
//			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE h_board SET tb_title = ?, tb_content = ? WHERE tb_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getBoardNo());
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
			conn = ConnectionHelper.getConnection("oracle");
//			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE h_board SET tb_deleted = '1' WHERE tb_no = ?";
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

	public void updateReadCount(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionHelper.getConnection("oracle");
//			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE board SET readcount = readcount + 1 WHERE boardno = ?";
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

	public void insertReply(TureBoard board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionHelper.getConnection("oracle");
//			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "INSERT INTO board (boardno, title, writer, content, groupno, step, depth ) " +
						 "VALUES (board_sequence.nextval, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.setInt(4, board.getGroupNo());
			pstmt.setInt(5, board.getStep());
			pstmt.setInt(6, board.getDepth());
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

	public void updateStep(int groupNo, int step) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionHelper.getConnection("oracle");
//			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE board SET step = step + 1 WHERE groupno = ? and step > ?";
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
	
	public List<TureBoard> selectBoardList2(int first, int last) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<TureBoard> boards = new ArrayList<TureBoard>();
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
//			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			
			StringBuffer sql = new StringBuffer(500);
			sql.append("SELECT * ");
			sql.append("FROM ");
			
			sql.append("( ");
			sql.append("	SELECT "); 
			sql.append("		rownum idx, s.* "); 
			sql.append("	FROM ");
			
			sql.append("	( ");
			sql.append("		SELECT "); 
			sql.append("			tb_no, tb_title, m_memberid, ");
			sql.append("			tb_regdate, ");
			sql.append("			tb_deleted, tb_groupno, tb_depth, tb_passno, tb_content, tb_location, tb_time, tb_day ");
			sql.append("		FROM ");
			sql.append("			h_board ");
			sql.append("		WHERE ");
			sql.append("			tb_deleted = '0' ");
			sql.append("		ORDER BY tb_groupno DESC ");
			sql.append("	) s ");
			
			sql.append(") ");
			
			sql.append("WHERE idx >= ? AND idx < ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, first);
			pstmt.setInt(2, last);
			rs = pstmt.executeQuery();			
			
			while (rs.next()) {
				TureBoard board = new TureBoard();
				board.setBoardNo(rs.getInt(2));
				board.setTitle(rs.getString(3));
				board.setWriter(rs.getString(4));
				board.setRegDate(rs.getDate(5));
				board.setDelated(rs.getBoolean(6));
				board.setGroupNo(rs.getInt(7));
				board.setDepth(rs.getInt(8));
				board.setPassNo(rs.getString(9));
				board.setContent(rs.getString(10));
				board.setLocation(rs.getString(11));
				board.setTime(rs.getString(12));
				board.setDay(rs.getString(13));
				
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
	
	public int getBoardCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			//1. Driver 등록
			conn = ConnectionHelper.getConnection("oracle");
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			String sql = "SELECT COUNT(*) FROM h_board";
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
	
public void insertBoardAttach(TureBoardAttach attach) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			conn = ConnectionHelper.getConnection("oracle");
			String sql = 
				"INSERT INTO h_boardattach " + 
				"(tba_no, tb_no, tba_savedfilename, tba_userfilename) " +
				"VALUES(tba_seq.nextval, ?, ?, ?)";
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
	
	public ArrayList<TureBoardAttach> selectBoardAttachByBoardNo(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<TureBoardAttach> attachments = new ArrayList<TureBoardAttach>();
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
//			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			String sql = 
				"SELECT tba_no, tb_no, tba_savedfilename, tba_userfilename " + 
				"FROM h_boardattach WHERE tb_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
				
			while (rs.next()) {
				TureBoardAttach attachment = new TureBoardAttach();
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
	
	public TureBoardAttach selectBoardAttachByAttachNo(int attachNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TureBoardAttach attachment = null;
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
//			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			String sql = 
				"SELECT tba_no, tb_no, tba_savedfilename, tba_userfilename, tba_mainimg " + 
				"FROM h_boardattach WHERE tba_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, attachNo);
			rs = pstmt.executeQuery();
				
			if (rs.next()) {
				attachment = new TureBoardAttach();
				attachment.setAttachNo(rs.getInt(1));
				attachment.setBoardNo(rs.getInt(2));
				attachment.setSavedFileName(rs.getString(3));
				attachment.setUserFileName(rs.getString(4));
				attachment.setMainImg(rs.getBoolean(5));
				
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
	
/////////////////////////////////////////////////////////////
	public void insertComment(TureBoardComment comment) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
//			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			
			String sql = 
				"INSERT INTO h_boardcomment " +
				"(tbc_no, tb_no, m_memberid, tbc_content) " +
				"VALUES (guidecomment_seq.nextVal, ?, ?, ?)" ;
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
	
	public void updateComment(TureBoardComment comment) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
//			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			
			String sql = 
				"UPDATE h_boardcomment " +
				"SET tbc_content = ?" +
				"WHERE tbc_no = ?";
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
//			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			
			String sql = 
				"DELETE FROM h_boardcomment " +				
				"WHERE tbc_no = ?";
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
	
	public ArrayList<TureBoardComment> selectCommentByBoardNo(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<TureBoardComment> comments = new ArrayList<>();
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
//			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			String sql = 
				"SELECT tbc_no, tb_no, m_memberid, tbc_content, tbc_regdate " + 
				"FROM h_boardcomment WHERE tb_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
				
			while (rs.next()) {
				TureBoardComment comment = new TureBoardComment();
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

	public List<TureBoardAttach> selectBoardAttachList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<TureBoardAttach> attachments = new ArrayList<TureBoardAttach>();
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
//			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			String sql = 
				"SELECT tba_no, tb_no, tba_savedfilename, tba_userfilename " + 
				"FROM h_boardattach";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
				
			while (rs.next()) {
				TureBoardAttach attachment = new TureBoardAttach();
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

	public List<TureBoard> selectMyCheckBoardList(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<TureBoard> boards = new ArrayList<TureBoard>();
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
//			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			
			StringBuffer sql = new StringBuffer(500);
			
			sql.append("		SELECT DISTINCT"); 
			sql.append("			b.tb_no, b.tb_title, b.m_memberid, ");
			sql.append("			b.tb_regdate, ");
			sql.append("			b.tb_deleted, b.tb_groupno, b.tb_depth, b.tb_passno, b.tb_content, b.tb_location, b.tb_time, b.tb_day ");
			sql.append("		FROM ");
			sql.append("			h_board b, h_boardcomment bc");
			sql.append("		WHERE ");
			sql.append("			b.tb_deleted = '0' and b.tb_no = bc.tb_no and bc.m_memberid = ? ");
			sql.append("		ORDER BY b.tb_groupno DESC ");
			
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, memberId);
		
			
			rs = pstmt.executeQuery();			
			
			while (rs.next()) {
				TureBoard board = new TureBoard();
				board.setBoardNo(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setRegDate(rs.getDate(4));
				board.setDelated(rs.getBoolean(5));
				board.setGroupNo(rs.getInt(6));
				board.setDepth(rs.getInt(7));
				board.setPassNo(rs.getString(8));
				board.setContent(rs.getString(9));
				board.setLocation(rs.getString(10));
				board.setTime(rs.getString(11));
				board.setDay(rs.getString(12));
				
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

	public void deleteBoardComment(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
//			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			
			String sql = 
				"DELETE FROM h_boardcomment " +				
				"WHERE tb_no = ?";
			pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, boardNo);

			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
		
	}

	public void deleteBoardAttach(int boardNo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
//			//1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
//					"demoweb", "oracle");//계정정보
			
			String sql = 
				"DELETE FROM h_boardattach " +				
				"WHERE tb_no = ?";
			pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, boardNo);

			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
		
	}

	public static Member selectMemberByGuideId(String guideId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member guideProfile = null;//조회된 데이터를 저장할 DTO 변수
		try {
			conn = ConnectionHelper.getConnection("oracle");
			//3. SQL 작성 및 명령 만들기
			String sql = "SELECT m_memberid, m_gender, m_email, m_phone FROM member WHERE m_memberid = ? ";
						 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, guideId);
			
			//4. 명령 실행
			rs = pstmt.executeQuery();//select 구문 실행 메서드
			//5. 결과가 있을 경우 처리
			if (rs.next()) { //조회된 데이터가 있다면 
				guideProfile = new Member();
				guideProfile.setMemberId(rs.getString(1));
				guideProfile.setGender(rs.getString(2));
				guideProfile.setEmail(rs.getString(3));
				guideProfile.setPhone(rs.getString(4));

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return guideProfile;//조회 성공하면 조회된 데이터 아니면 null
	}

	public void insertGuide(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = ConnectionHelper.getConnection("oracle");
			String sql = "UPDATE member SET m_nickname = ? WHERE m_memberid = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getNickName());
			pstmt.setString(2, member.getMemberId());
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

	public void insertTurlist(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = ConnectionHelper.getConnection("oracle");
			String sql = "UPDATE member SET m_nickname = ? WHERE m_memberid = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getNickName());
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

	public TureBoard findConnection(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TureBoard connection = null;//조회된 데이터를 저장할 DTO 변수
		try {
			conn = ConnectionHelper.getConnection("oracle");
			//3. SQL 작성 및 명령 만들기
			String sql = "SELECT tb_time FROM h_board WHERE m_memberid = ? ";
						 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			//4. 명령 실행
			rs = pstmt.executeQuery();//select 구문 실행 메서드
			//5. 결과가 있을 경우 처리
			if (rs.next()) { //조회된 데이터가 있다면 
				connection = new TureBoard();
				connection.setTime(rs.getString(1));
	

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return connection;//조회 성공하면 조회된 데이터 아니면 null
		
	}

	public void insertPoint(TureBoard member) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = ConnectionHelper.getConnection("oracle");
			String sql = "UPDATE member SET m_point = m_point + ? WHERE m_memberid = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getTime());
			pstmt.setString(2, member.getWriter());
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


	
}
