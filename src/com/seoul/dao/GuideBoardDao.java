package com.seoul.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.seoul.dao.ConnectionHelper;
import com.seoul.dto.Guide;
import com.seoul.dto.GuideBoardAttach;
import com.seoul.dto.GuideBoardComment;
import com.seoul.guideservlet.GuideFileUploadServlet;

public class GuideBoardDao {

	public int insertBoard(Guide guide) {

		Connection conn = null;
		PreparedStatement pstmt = null; //for insert
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
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
			String sql = "INSERT INTO j_guideboard (gub_boardno, gub_writer, gub_name, gub_email, gub_passno, gub_phone, gub_title, gub_intro, gub_hopearea, gub_nation, gub_target) " //***groupno중요****/
						+ "VALUES (guideboard_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			//VALUES 의 ? ? ? 에 들어갈 내용
			pstmt.setString(1,guide.getGub_Writer());
			pstmt.setString(2,guide.getGub_Name());
			pstmt.setString(3,guide.getGub_Email());
			pstmt.setString(4,guide.getGub_PassNo());
			pstmt.setString(5,guide.getGub_Phone());
			pstmt.setString(6,guide.getGub_Title());
			pstmt.setString(7,guide.getGub_Intro());
			pstmt.setString(8,guide.getGub_HopeArea());
			pstmt.setString(9,guide.getGub_Nation());
			pstmt.setString(10,guide.getGub_Target());
			//4. 명령 실행
			pstmt.executeUpdate(); //insert, update, delete 구문 실행 메서드
			
			sql = "SELECT guideboard_seq.currval FROM DUAL";
			pstmt2 = conn.prepareStatement(sql);
			rs = pstmt2.executeQuery();
			rs.next();
			newBoardNo = rs.getInt(1);
			
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//5. 연결 종료
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
			
		}
		return newBoardNo;
		
		
	}

	public List<Guide> selectBoardList2(int first, int last) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Guide> boards = new ArrayList<Guide>();
		
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
			
			StringBuffer sql = new StringBuffer(500);
			sql.append("SELECT * ");
			sql.append("FROM ");
			sql.append("( ");
			sql.append("	SELECT "); 
			sql.append("		rownum idx, s.* "); 
			sql.append("	FROM ");
			sql.append("	( ");
			sql.append("		SELECT "); 
			sql.append("			gub_boardno, gub_title, gub_writer, ");
			sql.append("			gub_regdate, gub_readcount, ");
			sql.append("			gub_deleted, gub_groupno, gub_step, gub_depth ");
			sql.append("		FROM ");
			sql.append("			j_guideboard ");
//			sql.append("		WHERE ");
//			sql.append("			deleted = '0' ");
//			sql.append("		ORDER BY gub_groupno DESC, gub_step ASC ");
			sql.append("		ORDER BY gub_boardno DESC ");
			sql.append("	) s ");
			sql.append(") ");
			sql.append("WHERE idx >= ? AND idx < ?");
			
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, first);
			pstmt.setInt(2, last);
			   
			rs = pstmt.executeQuery();			
			
			while (rs.next()) {
				Guide board = new Guide();
				board.setGub_BoardNo(rs.getInt(2));
				board.setGub_Title(rs.getString(3));
				board.setGub_Writer(rs.getString(4));
				board.setGub_RegDate(rs.getDate(5));
				board.setGub_ReadCount(rs.getInt(6));
				board.setGub_Deleted(rs.getBoolean(7));
				board.setGub_GroupNo(rs.getInt(8));
				board.setGub_Step(rs.getInt(9));
				board.setGub_Depth(rs.getInt(10));
				
				
/*				board.setGub_Deleted(rs.getBoolean(7));
				board.setGub_GroupNo(rs.getInt(8));
				board.setGub_Step(rs.getInt(9));
				board.setGub_Depth(rs.getInt(10));*/
				
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
			
		    /*// 커넥션이용해서 아래 한줄로 줄임
			//1. 드라이버 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", //연결대상 
					"demoweb", "oracle"); //계정정보
			 		
			*/
			conn = ConnectionHelper.getConnection("oracle");
			
			//conn = ConnectionHelper.getConnection(dsn);
			String sql = "SELECT COUNT(*) FROM J_GUIDEBOARD";
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

	public Guide selectBoardByBoardNo(int gub_BoardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		/*추가*/
/**/	ResultSet rs = null;
/**/	Guide guide = null; //조회된 데이터를 저장할 DTO변수

		//데이터베이스 연동 코드를 입력하는곳(JDBC코드 입력)
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
			//3. SQL작성 및 명령 만들기
/**/		String sql = "SELECT gub_boardno, gub_title, gub_lang, gub_nation, gub_email, gub_intro, gub_passno, gub_target, gub_hopearea, gub_phone, gub_regdate, gub_writer, gub_readcount, gub_name " 
						+ "FROM j_guideboard "
						+ "WHERE gub_boardno =  ? ";
			pstmt = conn.prepareStatement(sql);
			//VALUES 의 ? ? ? 에 들어갈 내용
			pstmt.setInt(1, gub_BoardNo);
/**///삭제	//pstmt.setString(3, member.getEmail());
			
			//4. 명령 실행
/**/		rs = pstmt.executeQuery(); //select 구문 실행 메서드
/**///추가	//5. 결과가 있을 경우 결과 처리
			while (rs.next()) { //조회된 데이터가 있다면
				guide = new Guide();
				guide.setGub_BoardNo(rs.getInt(1));
				guide.setGub_Title(rs.getString(2));
				guide.setGub_Lang(rs.getString(3));
				guide.setGub_Nation(rs.getString(4));
				guide.setGub_Email(rs.getString(5));
				guide.setGub_Intro(rs.getString(6));
				guide.setGub_PassNo(rs.getString(7));
				guide.setGub_Target(rs.getString(8));
				guide.setGub_HopeArea(rs.getString(9));
				guide.setGub_Phone(rs.getString(10));
				guide.setGub_RegDate(rs.getDate(11));
				guide.setGub_Writer(rs.getString(12));
				guide.setGub_ReadCount(rs.getInt(13));
				guide.setGub_Name(rs.getString(14));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
/**///추가	
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
/**///추가	
		return guide; //조회 성공하면 Board 아니면 null
	}

	

	public ArrayList<GuideBoardComment> selectCommentByBoardNo(int gub_BoardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<GuideBoardComment> gub_Comments = new ArrayList<>();
		
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
				"SELECT guc_commentno, guc_boardno, guc_writer, guc_content, guc_regdate " + 
				"FROM j_guidecomment WHERE guc_boardno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gub_BoardNo);
			rs = pstmt.executeQuery();
				
			while (rs.next()) {
				GuideBoardComment boardComment = new GuideBoardComment();
				boardComment.setGuc_CommentNo(rs.getInt(1));
				boardComment.setGuc_BoardNo(rs.getInt(2));
				boardComment.setGuc_Writer(rs.getString(3));
				boardComment.setGuc_Content(rs.getString(4));
				boardComment.setGuc_RegDate(rs.getDate(5));
				gub_Comments.add(boardComment);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				try { rs.close(); } catch (Exception ex) {}
				try { pstmt.close(); } catch (Exception ex) {}
				try { conn.close(); } catch (Exception ex) {}
			}
			return gub_Comments;
			}

	public void updateReadCount(int gub_BoardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		//데이터베이스 연동 코드를 입력하는곳(JDBC코드 입력)
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
			
			
			//3. SQL작성 및 명령 만들기
			String sql = "UPDATE j_guideboard " +
						 "SET gub_readcount = gub_readcount + 1 " +
						 "WHERE gub_boardno = ? ";
			pstmt = conn.prepareStatement(sql);
			//VALUES 의 ? ? ? 에 들어갈 내용
			pstmt.setInt(1, gub_BoardNo);
			//4. 명령 실행
			pstmt.executeUpdate(); //insert, update, delete 구문 실행 메서드
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//5. 연결 종료
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
			//6. lib폴더에 jar형식의 라이브러리 저장
			// (C:\oraclexe\app\oracle\product\11.2.0\server\jdbc)에서 ojdbc6_g.jar 복사해서 WEB-INF/lib에 저장

	}

	public void deleteBoard(int gub_BoardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		//데이터베이스 연동 코드를 입력하는곳(JDBC코드 입력)
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
			
			
			//3. SQL작성 및 명령 만들기
/*			String sql = "UPDATE j_guideboard " +
						 "SET gub_deleted = '1' " +
						 "WHERE gub_boardno = ? ";*/
			String sql = "DELETE FROM j_guideboard " +
						 "WHERE gub_boardno = ? "; 
			
			pstmt = conn.prepareStatement(sql);
			//VALUES 의 ? ? ? 에 들어갈 내용
			pstmt.setInt(1, gub_BoardNo);
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

	public void updateBoard(Guide guide) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		//데이터베이스 연동 코드를 입력하는곳(JDBC코드 입력)
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
			
			
			
			//3. SQL작성 및 명령 만들기
			String sql = "UPDATE j_guideboard " +
						 "SET gub_title = ?, gub_intro = ?, gub_name = ?, gub_email = ?, gub_passno = ?, gub_phone = ?, gub_hopearea = ?, gub_nation = ?, gub_target = ? " +
						 "WHERE gub_boardno =?";
			pstmt = conn.prepareStatement(sql);
			//VALUES 의 ? ? ? 에 들어갈 내용
			pstmt.setString(1, guide.getGub_Title());
			pstmt.setString(2, guide.getGub_Intro());
			pstmt.setString(3, guide.getGub_Name());
			pstmt.setString(4, guide.getGub_Email());
			pstmt.setString(5, guide.getGub_PassNo());
			pstmt.setString(6, guide.getGub_Phone());
			pstmt.setString(7, guide.getGub_HopeArea());
			pstmt.setString(8, guide.getGub_Nation());
			pstmt.setString(9, guide.getGub_Target());
			pstmt.setInt(10, guide.getGub_BoardNo());
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

	public static void updateStep(int gub_GroupNo, int gub_Step) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		//데이터베이스 연동 코드를 입력하는곳(JDBC코드 입력)
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
			
			
			//3. SQL작성 및 명령 만들기
			String sql = "UPDATE j_guideboard " +
						 "SET gub_step = gub_step + 1 " +
						 "WHERE gub_groupno = ? and gub_step > ? ";
			pstmt = conn.prepareStatement(sql);
			//VALUES 의 ? ? ? 에 들어갈 내용
			pstmt.setInt(1, gub_GroupNo);
			pstmt.setInt(2, gub_Step);
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


	public void insertComment(GuideBoardComment guideBoardComment) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
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
				"INSERT INTO j_guidecomment (guc_commentno, guc_boardno, guc_writer, guc_content) "
				+ "VALUES (guidecomment_seq.nextVal, ?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, guideBoardComment.getGuc_BoardNo());
			pstmt.setString(2, guideBoardComment.getGuc_Writer());
			pstmt.setString(3, guideBoardComment.getGuc_Content());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
	}

	public void updateComment(GuideBoardComment guideComment) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
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
				"UPDATE j_guidecomment " +
				"SET guc_content = ?" +
				"WHERE guc_commentno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, guideComment.getGuc_Content());
			pstmt.setInt(2, guideComment.getGuc_CommentNo());

			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
	}

	public void deleteComment(int guc_CommentNo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
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
				"DELETE FROM j_guidecomment " +				
				"WHERE guc_commentno = ?";
			pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, guc_CommentNo);

			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
	}

	public GuideBoardAttach selectBoardAttachByAttachNo(int sub_AttachNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GuideBoardAttach guideAttachment = null;
		
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
			"SELECT sub_attachno, sub_subno, sub_savedfile, sub_userfile " + 
			"FROM j_subbook WHERE sub_attachno = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, sub_AttachNo);
		rs = pstmt.executeQuery();
			
		if (rs.next()) {
			guideAttachment = new GuideBoardAttach();
			guideAttachment.setSub_AttachNo(rs.getInt(1));
			guideAttachment.setSub_SubNo(rs.getInt(2));
			guideAttachment.setSub_SavedFile(rs.getString(3));
			guideAttachment.setSub_UserFile(rs.getString(4));
			
		}
	} catch (Exception ex) {
		ex.printStackTrace();
	} finally {
		try { rs.close(); } catch (Exception ex) {}
		try { pstmt.close(); } catch (Exception ex) {}
		try { conn.close(); } catch (Exception ex) {}
	}
	return guideAttachment;
	
}

	public void insertBoardAttach(GuideBoardAttach guideAttachment) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
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
				"INSERT INTO j_subbook " + 
				"(sub_attachno, sub_subno, sub_savedfile, sub_userfile) " +
				"VALUES (subbook_seq.nextVal, subbook_seq.nextVal, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, guideAttachment.getSub_SavedFile());
			pstmt.setString(2, guideAttachment.getSub_UserFile());
			pstmt.executeUpdate();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try { pstmt.close(); } catch (Exception ex) { }
			try { conn.close(); } catch (Exception ex) { }
		}		
		
	}

	public int fileUploadBoard(GuideFileUploadServlet guide) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Guide> selectBoardList() {
	/**/ // -> 복사붙여넣기 할때 변경되는 부분
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		/*추가*/
/**/	ResultSet rs = null;
		//조회된 데이터를 저장할 DTO변수(여러건이므로 컬렉션 형식)
/**/	ArrayList<Guide> guides = new ArrayList<>(); //조회된 데이터를 저장할 DTO변수

		//데이터베이스 연동 코드를 입력하는곳(JDBC코드 입력)
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
			
			//3. SQL작성 및 명령 만들기
/**/		String sql = "SELECT gub_boardno, gub_title, gub_writer, gub_regdate, gub_readcount, gub_deleted, gub_groupno, gub_step, gub_depth " 
						+ "FROM j_guideboard "
						+ "ORDER BY groupno DESC, step ASC ";

			pstmt = conn.prepareStatement(sql);
			//VALUES 의 ? ? ? 에 들어갈 내용
/**///삭제	//pstmt.setString(3, member.getEmail());
			
			//4. 명령 실행
/**/		rs = pstmt.executeQuery(); //select 구문 실행 메서드

/**///추가	//5. 결과가 있을 경우 결과 처리
			while (rs.next()) { //조회된 데이터가 있다면
				Guide guide = new Guide();
				guide.setGub_BoardNo(rs.getInt(1));
				guide.setGub_Title(rs.getString(2));
				guide.setGub_Writer(rs.getString(3));
				guide.setGub_RegDate(rs.getDate(4));
				guide.setGub_ReadCount(rs.getInt(5));
				guide.setGub_Deleted(rs.getBoolean(6));
				guide.setGub_GroupNo(rs.getInt(7));
				guide.setGub_Step(rs.getInt(8));
				guide.setGub_Depth(rs.getInt(9));
				guides.add(guide); //각 게시글 데이터를 목록에 추가
			}

		} catch (Exception ex) {
		} finally {
			//6. 연결 종료
/**///추가	
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
/**///추가	
		return guides; //조회 성공하면 목록반환, 아니면 count가 0
	}


}
	
	
	
	
	
	




