package com.seoul.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.seoul.dto.Information;
import com.seoul.service.InformationBoardService;

public class InformationBoardDao {

////////////////////////////////////////<1>////////////////////////////////////////////	
	public void insertBoard(Information information) {

		Connection conn = null;
		PreparedStatement pstmt = null; //for insert

		//데이터베이스 연동 코드를 입력하는곳(JDBC코드 입력)
		try {
			//1. 드라이버 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123"); //계정정보
			//3. SQL작성 및 명령 만들기
			String sql = "INSERT INTO p_information (in_no, in_area, in_title, m_memberid, in_serialno, in_address, in_telephone, in_readcount, in_content) " //***groupno중요****/
						+ "VALUES (info_seq.nextval,?,?,?,1,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			//VALUES 의 ? ? ? 에 들어갈 내용
			pstmt.setString(1, information.getIn_Area());
			pstmt.setString(2, information.getIn_Title());
			pstmt.setString(3, information.getM_MemberId());	
			pstmt.setString(4, information.getIn_Address());
			pstmt.setString(5, information.getIn_Telephone());
			pstmt.setInt(6, information.getReadCount());
			pstmt.setString(7, information.getIn_Content());
			
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

	public List<Information> selectBoard () {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			//조회된 데이터를 저장할 DTO 변수 (여러 건이므로 컬렉션 형식)
			ArrayList<Information> informations = new ArrayList<>();
			
			try {
				//1. Driver 등록
				Class.forName("oracle.jdbc.OracleDriver");
				//2. 연결 만들기
				conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
						"seoul", "789123"); //계정정보
				//3. SQL 작성 및 명령 만들기
				String sql = "SELECT in_no, in_area, in_title, m_memberid, in_serialno, in_address, in_telephone, in_content, in_readcount, in_deleted " + 
								"FROM p_information " +
								"WHERE in_serialno=1 " +
								"ORDER BY in_no desc ";
				pstmt = conn.prepareStatement(sql);
				//4. 명령 실행
				rs = pstmt.executeQuery();//select 구문 실행 메서드
				//5. 결과가 있을 경우 처리
				while (rs.next()) { //조회된 데이터가 있다면, while문으로 여러 게시글을 게시, rs.next기능이 여러번 복수형태로 다음 게시글을 게시할수 있게 하는 기능
					Information information = new Information();
					information.setIn_No(rs.getInt(1));
					information.setIn_Area(rs.getString(2));
					information.setIn_Title(rs.getString(3));
					information.setM_MemberId(rs.getString(4));
					information.setIn_SerialNo(rs.getInt(5));
					information.setIn_Address(rs.getString(6));
					information.setIn_Telephone(rs.getString(7));
					information.setIn_Content(rs.getString(8));
					information.setReadCount(rs.getInt(9));
					information.setDeleted(rs.getBoolean(10));
					/*information.setIn_Content(rs.getString(6));*/
					
					informations.add(information); //각 게시글 데이터를 목록에 추가
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				//6. 연결 종료
				try { rs.close(); } catch (Exception ex) {}
				try { pstmt.close(); } catch (Exception ex) {}
				try { conn.close(); } catch (Exception ex) {}
			}
			
			return informations;//조회 성공하면 목록 아니면 count가 0
		}


////////////////////////////////////////<2>////////////////////////////////////////////	
public void insertBoard2(Information information) {

Connection conn = null;
PreparedStatement pstmt = null; //for insert

//데이터베이스 연동 코드를 입력하는곳(JDBC코드 입력)
try {
//1. 드라이버 등록
Class.forName("oracle.jdbc.OracleDriver");
//2. 연결 만들기
conn = DriverManager.getConnection(
"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
"seoul", "789123"); //계정정보
//3. SQL작성 및 명령 만들기
String sql = "INSERT INTO p_information (in_no, in_area, in_title, m_memberid, in_serialno, in_address, in_telephone, in_readcount, in_content) " //***groupno중요****/
+ "VALUES (info_seq.nextval,?,?,?,2,?,?,?,?)";
pstmt = conn.prepareStatement(sql);
//VALUES 의 ? ? ? 에 들어갈 내용
pstmt.setString(1, information.getIn_Area());
pstmt.setString(2, information.getIn_Title());
pstmt.setString(3, information.getM_MemberId());	
pstmt.setString(4, information.getIn_Address());
pstmt.setString(5, information.getIn_Telephone());
pstmt.setInt(6, information.getReadCount());
pstmt.setString(7, information.getIn_Content());

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

public List<Information> selectBoard2 () {
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
//조회된 데이터를 저장할 DTO 변수 (여러 건이므로 컬렉션 형식)
ArrayList<Information> informations = new ArrayList<>();

try {
//1. Driver 등록
Class.forName("oracle.jdbc.OracleDriver");
//2. 연결 만들기
conn = DriverManager.getConnection(
"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
"seoul", "789123"); //계정정보
//3. SQL 작성 및 명령 만들기
String sql = "SELECT in_no, in_area, in_title, m_memberid, in_serialno, in_address, in_telephone, in_content, in_readcount, in_deleted " + 
"FROM p_information " +
"WHERE in_serialno=2 " +
"ORDER BY in_no desc ";
pstmt = conn.prepareStatement(sql);
//4. 명령 실행
rs = pstmt.executeQuery();//select 구문 실행 메서드
//5. 결과가 있을 경우 처리
while (rs.next()) { //조회된 데이터가 있다면, while문으로 여러 게시글을 게시, rs.next기능이 여러번 복수형태로 다음 게시글을 게시할수 있게 하는 기능
Information information = new Information();
information.setIn_No(rs.getInt(1));
information.setIn_Area(rs.getString(2));
information.setIn_Title(rs.getString(3));
information.setM_MemberId(rs.getString(4));
information.setIn_SerialNo(rs.getInt(5));
information.setIn_Address(rs.getString(6));
information.setIn_Telephone(rs.getString(7));
information.setIn_Content(rs.getString(8));
information.setReadCount(rs.getInt(9));
information.setDeleted(rs.getBoolean(10));
/*information.setIn_Content(rs.getString(6));*/

informations.add(information); //각 게시글 데이터를 목록에 추가
}
} catch (Exception ex) {
ex.printStackTrace();
} finally {
//6. 연결 종료
try { rs.close(); } catch (Exception ex) {}
try { pstmt.close(); } catch (Exception ex) {}
try { conn.close(); } catch (Exception ex) {}
}

return informations;//조회 성공하면 목록 아니면 count가 0
}
	
////////////////////////////////////////<3>////////////////////////////////////////////	
public void insertBoard3(Information information) {

Connection conn = null;
PreparedStatement pstmt = null; //for insert

//데이터베이스 연동 코드를 입력하는곳(JDBC코드 입력)
try {
//1. 드라이버 등록
Class.forName("oracle.jdbc.OracleDriver");
//2. 연결 만들기
conn = DriverManager.getConnection(
"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
"seoul", "789123"); //계정정보
//3. SQL작성 및 명령 만들기
String sql = "INSERT INTO p_information (in_no, in_area, in_title, m_memberid, in_serialno, in_address, in_telephone, in_readcount, in_content) " //***groupno중요****/
+ "VALUES (info_seq.nextval,?,?,?,3,?,?,?,?)";
pstmt = conn.prepareStatement(sql);
//VALUES 의 ? ? ? 에 들어갈 내용
pstmt.setString(1, information.getIn_Area());
pstmt.setString(2, information.getIn_Title());
pstmt.setString(3, information.getM_MemberId());	
pstmt.setString(4, information.getIn_Address());
pstmt.setString(5, information.getIn_Telephone());
pstmt.setInt(6, information.getReadCount());
pstmt.setString(7, information.getIn_Content());

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

public List<Information> selectBoard3 () {
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
//조회된 데이터를 저장할 DTO 변수 (여러 건이므로 컬렉션 형식)
ArrayList<Information> informations = new ArrayList<>();

try {
//1. Driver 등록
Class.forName("oracle.jdbc.OracleDriver");
//2. 연결 만들기
conn = DriverManager.getConnection(
"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
"seoul", "789123"); //계정정보
//3. SQL 작성 및 명령 만들기
String sql = "SELECT in_no, in_area, in_title, m_memberid, in_serialno, in_address, in_telephone, in_content, in_readcount, in_deleted " + 
"FROM p_information " +
"WHERE in_serialno=3 " +
"ORDER BY in_no desc ";
pstmt = conn.prepareStatement(sql);
//4. 명령 실행
rs = pstmt.executeQuery();//select 구문 실행 메서드
//5. 결과가 있을 경우 처리
while (rs.next()) { //조회된 데이터가 있다면, while문으로 여러 게시글을 게시, rs.next기능이 여러번 복수형태로 다음 게시글을 게시할수 있게 하는 기능
Information information = new Information();
information.setIn_No(rs.getInt(1));
information.setIn_Area(rs.getString(2));
information.setIn_Title(rs.getString(3));
information.setM_MemberId(rs.getString(4));
information.setIn_SerialNo(rs.getInt(5));
information.setIn_Address(rs.getString(6));
information.setIn_Telephone(rs.getString(7));
information.setIn_Content(rs.getString(8));
information.setReadCount(rs.getInt(9));
information.setDeleted(rs.getBoolean(10));
/*information.setIn_Content(rs.getString(6));*/

informations.add(information); //각 게시글 데이터를 목록에 추가
}
} catch (Exception ex) {
ex.printStackTrace();
} finally {
//6. 연결 종료
try { rs.close(); } catch (Exception ex) {}
try { pstmt.close(); } catch (Exception ex) {}
try { conn.close(); } catch (Exception ex) {}
}

return informations;//조회 성공하면 목록 아니면 count가 0
}

////////////////////////////////////////<4>////////////////////////////////////////////	
public void insertBoard4(Information information) {

Connection conn = null;
PreparedStatement pstmt = null; //for insert

//데이터베이스 연동 코드를 입력하는곳(JDBC코드 입력)
try {
//1. 드라이버 등록
Class.forName("oracle.jdbc.OracleDriver");
//2. 연결 만들기
conn = DriverManager.getConnection(
"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
"seoul", "789123"); //계정정보
//3. SQL작성 및 명령 만들기
String sql = "INSERT INTO p_information (in_no, in_area, in_title, m_memberid, in_serialno, in_address, in_telephone, in_readcount, in_content) " //***groupno중요****/
+ "VALUES (info_seq.nextval,?,?,?,4,?,?,?,?)";
pstmt = conn.prepareStatement(sql);
//VALUES 의 ? ? ? 에 들어갈 내용
pstmt.setString(1, information.getIn_Area());
pstmt.setString(2, information.getIn_Title());
pstmt.setString(3, information.getM_MemberId());	
pstmt.setString(4, information.getIn_Address());
pstmt.setString(5, information.getIn_Telephone());
pstmt.setInt(6, information.getReadCount());
pstmt.setString(7, information.getIn_Content());

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

public List<Information> selectBoard4 () {
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
//조회된 데이터를 저장할 DTO 변수 (여러 건이므로 컬렉션 형식)
ArrayList<Information> informations = new ArrayList<>();

try {
//1. Driver 등록
Class.forName("oracle.jdbc.OracleDriver");
//2. 연결 만들기
conn = DriverManager.getConnection(
"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
"seoul", "789123"); //계정정보
//3. SQL 작성 및 명령 만들기
String sql = "SELECT in_no, in_area, in_title, m_memberid, in_serialno, in_address, in_telephone, in_content, in_readcount, in_deleted " + 
"FROM p_information " +
"WHERE in_serialno=4 " +
"ORDER BY in_no desc ";
pstmt = conn.prepareStatement(sql);
//4. 명령 실행
rs = pstmt.executeQuery();//select 구문 실행 메서드
//5. 결과가 있을 경우 처리
while (rs.next()) { //조회된 데이터가 있다면, while문으로 여러 게시글을 게시, rs.next기능이 여러번 복수형태로 다음 게시글을 게시할수 있게 하는 기능
Information information = new Information();
information.setIn_No(rs.getInt(1));
information.setIn_Area(rs.getString(2));
information.setIn_Title(rs.getString(3));
information.setM_MemberId(rs.getString(4));
information.setIn_SerialNo(rs.getInt(5));
information.setIn_Address(rs.getString(6));
information.setIn_Telephone(rs.getString(7));
information.setIn_Content(rs.getString(8));
information.setReadCount(rs.getInt(9));
information.setDeleted(rs.getBoolean(10));
/*information.setIn_Content(rs.getString(6));*/

informations.add(information); //각 게시글 데이터를 목록에 추가
}
} catch (Exception ex) {
ex.printStackTrace();
} finally {
//6. 연결 종료
try { rs.close(); } catch (Exception ex) {}
try { pstmt.close(); } catch (Exception ex) {}
try { conn.close(); } catch (Exception ex) {}
}

return informations;//조회 성공하면 목록 아니면 count가 0
}
			

	
////////////////////////////////////////<5>////////////////////////////////////////////	
public void insertBoard5(Information information) {

Connection conn = null;
PreparedStatement pstmt = null; //for insert

//데이터베이스 연동 코드를 입력하는곳(JDBC코드 입력)
try {
//1. 드라이버 등록
Class.forName("oracle.jdbc.OracleDriver");
//2. 연결 만들기
conn = DriverManager.getConnection(
"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
"seoul", "789123"); //계정정보
//3. SQL작성 및 명령 만들기
String sql = "INSERT INTO p_information (in_no, in_area, in_title, m_memberid, in_serialno, in_address, in_telephone, in_readcount, in_content) " //***groupno중요****/
+ "VALUES (info_seq.nextval,?,?,?,5,?,?,?,?)";
pstmt = conn.prepareStatement(sql);
//VALUES 의 ? ? ? 에 들어갈 내용
pstmt.setString(1, information.getIn_Area());
pstmt.setString(2, information.getIn_Title());
pstmt.setString(3, information.getM_MemberId());	
pstmt.setString(4, information.getIn_Address());
pstmt.setString(5, information.getIn_Telephone());
pstmt.setInt(6, information.getReadCount());
pstmt.setString(7, information.getIn_Content());

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

public List<Information> selectBoard5 () {
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
//조회된 데이터를 저장할 DTO 변수 (여러 건이므로 컬렉션 형식)
ArrayList<Information> informations = new ArrayList<>();

try {
//1. Driver 등록
Class.forName("oracle.jdbc.OracleDriver");
//2. 연결 만들기
conn = DriverManager.getConnection(
"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
"seoul", "789123"); //계정정보
//3. SQL 작성 및 명령 만들기
String sql = "SELECT in_no, in_area, in_title, m_memberid, in_serialno, in_address, in_telephone, in_content, in_readcount, in_deleted " + 
"FROM p_information " +
"WHERE in_serialno=5 " +
"ORDER BY in_no desc ";
pstmt = conn.prepareStatement(sql);
//4. 명령 실행
rs = pstmt.executeQuery();//select 구문 실행 메서드
//5. 결과가 있을 경우 처리
while (rs.next()) { //조회된 데이터가 있다면, while문으로 여러 게시글을 게시, rs.next기능이 여러번 복수형태로 다음 게시글을 게시할수 있게 하는 기능
Information information = new Information();
information.setIn_No(rs.getInt(1));
information.setIn_Area(rs.getString(2));
information.setIn_Title(rs.getString(3));
information.setM_MemberId(rs.getString(4));
information.setIn_SerialNo(rs.getInt(5));
information.setIn_Address(rs.getString(6));
information.setIn_Telephone(rs.getString(7));
information.setIn_Content(rs.getString(8));
information.setReadCount(rs.getInt(9));
information.setDeleted(rs.getBoolean(10));
/*information.setIn_Content(rs.getString(6));*/

informations.add(information); //각 게시글 데이터를 목록에 추가
}
} catch (Exception ex) {
ex.printStackTrace();
} finally {
//6. 연결 종료
try { rs.close(); } catch (Exception ex) {}
try { pstmt.close(); } catch (Exception ex) {}
try { conn.close(); } catch (Exception ex) {}
}

return informations;//조회 성공하면 목록 아니면 count가 0
}

////////////////////////////////////////<6>////////////////////////////////////////////	
public void insertBoard6(Information information) {

Connection conn = null;
PreparedStatement pstmt = null; //for insert

//데이터베이스 연동 코드를 입력하는곳(JDBC코드 입력)
try {
//1. 드라이버 등록
Class.forName("oracle.jdbc.OracleDriver");
//2. 연결 만들기
conn = DriverManager.getConnection(
"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
"seoul", "789123"); //계정정보
//3. SQL작성 및 명령 만들기
String sql = "INSERT INTO p_information (in_no, in_area, in_title, m_memberid, in_serialno, in_address, in_telephone, in_readcount, in_content) " //***groupno중요****/
+ "VALUES (info_seq.nextval,?,?,?,6,?,?,?,?)";
pstmt = conn.prepareStatement(sql);
//VALUES 의 ? ? ? 에 들어갈 내용
pstmt.setString(1, information.getIn_Area());
pstmt.setString(2, information.getIn_Title());
pstmt.setString(3, information.getM_MemberId());	
pstmt.setString(4, information.getIn_Address());
pstmt.setString(5, information.getIn_Telephone());
pstmt.setInt(6, information.getReadCount());
pstmt.setString(7, information.getIn_Content());

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

public List<Information> selectBoard6 () {
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
//조회된 데이터를 저장할 DTO 변수 (여러 건이므로 컬렉션 형식)
ArrayList<Information> informations = new ArrayList<>();

try {
//1. Driver 등록
Class.forName("oracle.jdbc.OracleDriver");
//2. 연결 만들기
conn = DriverManager.getConnection(
"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
"seoul", "789123"); //계정정보
//3. SQL 작성 및 명령 만들기
String sql = "SELECT in_no, in_area, in_title, m_memberid, in_serialno, in_address, in_telephone, in_content, in_readcount, in_deleted " + 
"FROM p_information " +
"WHERE in_serialno=6 " +
"ORDER BY in_no desc ";
pstmt = conn.prepareStatement(sql);
//4. 명령 실행
rs = pstmt.executeQuery();//select 구문 실행 메서드
//5. 결과가 있을 경우 처리
while (rs.next()) { //조회된 데이터가 있다면, while문으로 여러 게시글을 게시, rs.next기능이 여러번 복수형태로 다음 게시글을 게시할수 있게 하는 기능
Information information = new Information();
information.setIn_No(rs.getInt(1));
information.setIn_Area(rs.getString(2));
information.setIn_Title(rs.getString(3));
information.setM_MemberId(rs.getString(4));
information.setIn_SerialNo(rs.getInt(5));
information.setIn_Address(rs.getString(6));
information.setIn_Telephone(rs.getString(7));
information.setIn_Content(rs.getString(8));
information.setReadCount(rs.getInt(9));
information.setDeleted(rs.getBoolean(10));
/*information.setIn_Content(rs.getString(6));*/

informations.add(information); //각 게시글 데이터를 목록에 추가
}
} catch (Exception ex) {
ex.printStackTrace();
} finally {
//6. 연결 종료
try { rs.close(); } catch (Exception ex) {}
try { pstmt.close(); } catch (Exception ex) {}
try { conn.close(); } catch (Exception ex) {}
}

return informations;//조회 성공하면 목록 아니면 count가 0
}

////////////////////////////////////////<7>////////////////////////////////////////////	
public void insertBoard7(Information information) {

Connection conn = null;
PreparedStatement pstmt = null; //for insert

//데이터베이스 연동 코드를 입력하는곳(JDBC코드 입력)
try {
//1. 드라이버 등록
Class.forName("oracle.jdbc.OracleDriver");
//2. 연결 만들기
conn = DriverManager.getConnection(
"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
"seoul", "789123"); //계정정보
//3. SQL작성 및 명령 만들기
String sql = "INSERT INTO p_information (in_no, in_area, in_title, m_memberid, in_serialno, in_address, in_telephone, in_readcount, in_content) " //***groupno중요****/
+ "VALUES (info_seq.nextval,?,?,?,7,?,?,?,?)";
pstmt = conn.prepareStatement(sql);
//VALUES 의 ? ? ? 에 들어갈 내용
pstmt.setString(1, information.getIn_Area());
pstmt.setString(2, information.getIn_Title());
pstmt.setString(3, information.getM_MemberId());	
pstmt.setString(4, information.getIn_Address());
pstmt.setString(5, information.getIn_Telephone());
pstmt.setInt(6, information.getReadCount());
pstmt.setString(7, information.getIn_Content());

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

public List<Information> selectBoard7 () {
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
//조회된 데이터를 저장할 DTO 변수 (여러 건이므로 컬렉션 형식)
ArrayList<Information> informations = new ArrayList<>();

try {
//1. Driver 등록
Class.forName("oracle.jdbc.OracleDriver");
//2. 연결 만들기
conn = DriverManager.getConnection(
"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
"seoul", "789123"); //계정정보
//3. SQL 작성 및 명령 만들기
String sql = "SELECT in_no, in_area, in_title, m_memberid, in_serialno, in_address, in_telephone, in_content, in_readcount, in_deleted " + 
"FROM p_information " +
"WHERE in_serialno=7 " +
"ORDER BY in_no desc ";
pstmt = conn.prepareStatement(sql);
//4. 명령 실행
rs = pstmt.executeQuery();//select 구문 실행 메서드
//5. 결과가 있을 경우 처리
while (rs.next()) { //조회된 데이터가 있다면, while문으로 여러 게시글을 게시, rs.next기능이 여러번 복수형태로 다음 게시글을 게시할수 있게 하는 기능
Information information = new Information();
information.setIn_No(rs.getInt(1));
information.setIn_Area(rs.getString(2));
information.setIn_Title(rs.getString(3));
information.setM_MemberId(rs.getString(4));
information.setIn_SerialNo(rs.getInt(5));
information.setIn_Address(rs.getString(6));
information.setIn_Telephone(rs.getString(7));
information.setIn_Content(rs.getString(8));
information.setReadCount(rs.getInt(9));
information.setDeleted(rs.getBoolean(10));
/*information.setIn_Content(rs.getString(6));*/

informations.add(information); //각 게시글 데이터를 목록에 추가
}
} catch (Exception ex) {
ex.printStackTrace();
} finally {
//6. 연결 종료
try { rs.close(); } catch (Exception ex) {}
try { pstmt.close(); } catch (Exception ex) {}
try { conn.close(); } catch (Exception ex) {}
}

return informations;//조회 성공하면 목록 아니면 count가 0
}

////////////////////////////////////////<8>////////////////////////////////////////////	
public void insertBoard8(Information information) {

Connection conn = null;
PreparedStatement pstmt = null; //for insert

//데이터베이스 연동 코드를 입력하는곳(JDBC코드 입력)
try {
//1. 드라이버 등록
Class.forName("oracle.jdbc.OracleDriver");
//2. 연결 만들기
conn = DriverManager.getConnection(
"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
"seoul", "789123"); //계정정보
//3. SQL작성 및 명령 만들기
String sql = "INSERT INTO p_information (in_no, in_area, in_title, m_memberid, in_serialno, in_address, in_telephone, in_readcount, in_content) " //***groupno중요****/
+ "VALUES (info_seq.nextval,?,?,?,8,?,?,?,?)";
pstmt = conn.prepareStatement(sql);
//VALUES 의 ? ? ? 에 들어갈 내용
pstmt.setString(1, information.getIn_Area());
pstmt.setString(2, information.getIn_Title());
pstmt.setString(3, information.getM_MemberId());	
pstmt.setString(4, information.getIn_Address());
pstmt.setString(5, information.getIn_Telephone());
pstmt.setInt(6, information.getReadCount());
pstmt.setString(7, information.getIn_Content());

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

public List<Information> selectBoard8 () {
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
//조회된 데이터를 저장할 DTO 변수 (여러 건이므로 컬렉션 형식)
ArrayList<Information> informations = new ArrayList<>();

try {
//1. Driver 등록
Class.forName("oracle.jdbc.OracleDriver");
//2. 연결 만들기
conn = DriverManager.getConnection(
"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
"seoul", "789123"); //계정정보
//3. SQL 작성 및 명령 만들기
String sql = "SELECT in_no, in_area, in_title, m_memberid, in_serialno, in_address, in_telephone, in_content, in_readcount, in_deleted " + 
"FROM p_information " +
"WHERE in_serialno=8 " +
"ORDER BY in_no desc ";
pstmt = conn.prepareStatement(sql);
//4. 명령 실행
rs = pstmt.executeQuery();//select 구문 실행 메서드
//5. 결과가 있을 경우 처리
while (rs.next()) { //조회된 데이터가 있다면, while문으로 여러 게시글을 게시, rs.next기능이 여러번 복수형태로 다음 게시글을 게시할수 있게 하는 기능
Information information = new Information();
information.setIn_No(rs.getInt(1));
information.setIn_Area(rs.getString(2));
information.setIn_Title(rs.getString(3));
information.setM_MemberId(rs.getString(4));
information.setIn_SerialNo(rs.getInt(5));
information.setIn_Address(rs.getString(6));
information.setIn_Telephone(rs.getString(7));
information.setIn_Content(rs.getString(8));
information.setReadCount(rs.getInt(9));
information.setDeleted(rs.getBoolean(10));
/*information.setIn_Content(rs.getString(6));*/

informations.add(information); //각 게시글 데이터를 목록에 추가
}
} catch (Exception ex) {
ex.printStackTrace();
} finally {
//6. 연결 종료
try { rs.close(); } catch (Exception ex) {}
try { pstmt.close(); } catch (Exception ex) {}
try { conn.close(); } catch (Exception ex) {}
}

return informations;//조회 성공하면 목록 아니면 count가 0
}


///////////////////////////////BoardCount(1)/////////////////////////////////

	public int getBoardCount() {		
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int count = 0;
			try {
				
				//1. Driver 등록
				Class.forName("oracle.jdbc.OracleDriver");
				//2. 연결 만들기
				conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
						"seoul", "789123");//계정정보
				
				String sql = "SELECT COUNT(*) FROM p_information";
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
	
///////////////////////////////BoardCount(2)/////////////////////////////////

public int getBoardCount2() {		

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
int count = 0;
try {

//1. Driver 등록
Class.forName("oracle.jdbc.OracleDriver");
//2. 연결 만들기
conn = DriverManager.getConnection(
"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
"seoul", "789123");//계정정보

String sql = "SELECT COUNT(*) FROM p_information";
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

///////////////////////////////BoardCount(3)/////////////////////////////////

public int getBoardCount3() {		

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
int count = 0;
try {

//1. Driver 등록
Class.forName("oracle.jdbc.OracleDriver");
//2. 연결 만들기
conn = DriverManager.getConnection(
"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
"seoul", "789123");//계정정보

String sql = "SELECT COUNT(*) FROM p_information";
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

///////////////////////////////BoardCount(4)/////////////////////////////////

public int getBoardCount4() {		

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
int count = 0;
try {

//1. Driver 등록
Class.forName("oracle.jdbc.OracleDriver");
//2. 연결 만들기
conn = DriverManager.getConnection(
"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
"seoul", "789123");//계정정보

String sql = "SELECT COUNT(*) FROM p_information";
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

///////////////////////////////BoardCount(5)/////////////////////////////////

public int getBoardCount5() {		

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
int count = 0;
try {

//1. Driver 등록
Class.forName("oracle.jdbc.OracleDriver");
//2. 연결 만들기
conn = DriverManager.getConnection(
"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
"seoul", "789123");//계정정보

String sql = "SELECT COUNT(*) FROM p_information";
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

///////////////////////////////BoardCount(6)/////////////////////////////////

public int getBoardCount6() {		

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
int count = 0;
try {

//1. Driver 등록
Class.forName("oracle.jdbc.OracleDriver");
//2. 연결 만들기
conn = DriverManager.getConnection(
"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
"seoul", "789123");//계정정보

String sql = "SELECT COUNT(*) FROM p_information";
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

///////////////////////////////BoardCount(7)/////////////////////////////////

public int getBoardCount7() {		

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
int count = 0;
try {

//1. Driver 등록
Class.forName("oracle.jdbc.OracleDriver");
//2. 연결 만들기
conn = DriverManager.getConnection(
"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
"seoul", "789123");//계정정보

String sql = "SELECT COUNT(*) FROM p_information";
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

///////////////////////////////BoardCount(8)/////////////////////////////////

public int getBoardCount8() {		

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
int count = 0;
try {

//1. Driver 등록
Class.forName("oracle.jdbc.OracleDriver");
//2. 연결 만들기
conn = DriverManager.getConnection(
"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
"seoul", "789123");//계정정보

String sql = "SELECT COUNT(*) FROM p_information";
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

	/////////////////////////////////readcount(1)////////////////////////////////
	
	public void updateReadCount(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE p_information " +						 	
					 		"SET in_readcount = in_readcount + 1 " +
						 	"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
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
	
	/////////////////////////////////readcount(2)////////////////////////////////
	
	public void updateReadCount2(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE p_information " +						 	
					 		"SET in_readcount = in_readcount + 1 " +
						 	"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
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
	
	/////////////////////////////////readcount(3)////////////////////////////////
	
	public void updateReadCount3(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE p_information " +						 	
					 		"SET in_readcount = in_readcount + 1 " +
						 	"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
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
	
	/////////////////////////////////readcount(4)////////////////////////////////
	
	public void updateReadCount4(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE p_information " +						 	
					 		"SET in_readcount = in_readcount + 1 " +
						 	"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
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
	
	/////////////////////////////////readcount(5)////////////////////////////////
	
	public void updateReadCount5(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE p_information " +						 	
					 		"SET in_readcount = in_readcount + 1 " +
						 	"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
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
	
	/////////////////////////////////readcount(6)////////////////////////////////
	
	public void updateReadCount6(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE p_information " +						 	
					 		"SET in_readcount = in_readcount + 1 " +
						 	"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
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
	
	/////////////////////////////////readcount(7)////////////////////////////////
	
	public void updateReadCount7(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE p_information " +						 	
					 		"SET in_readcount = in_readcount + 1 " +
						 	"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
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
	
	/////////////////////////////////readcount(8)////////////////////////////////
	
	public void updateReadCount8(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE p_information " +						 	
					 		"SET in_readcount = in_readcount + 1 " +
						 	"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
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
	
	////////////////////////////////////////////////////////////////////////////

	public Information selectBoardByBoardNo(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Information information = null; //조회된 데이터를 저장할 DTO 변수

		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "SELECT in_no, m_memberid, in_area, in_title, in_address, in_telephone, in_readcount, in_content, in_deleted " + 
							"FROM p_information " +
							"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			//4. 명령 실행
			rs = pstmt.executeQuery();//select 구문 실행 메서드
			//5. 결과가 있을 경우 처리
			while (rs.next()) { //조회된 데이터가 있다면, while문으로 여러 게시글을 게시
				information = new Information();
				information.setIn_No(rs.getInt(1));
				information.setM_MemberId(rs.getString(2));
				information.setIn_Area(rs.getString(3));
				information.setIn_Title(rs.getString(4));				
				information.setIn_Address(rs.getString(5));
				information.setIn_Telephone(rs.getString(6));
				information.setReadCount(rs.getInt(7));
				information.setIn_Content(rs.getString(8));
				information.setDeleted(rs.getBoolean(9));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return information;//조회 성공하면 Board 아니면 null
	}

	public Information selectBoardByBoardNo2(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Information information = null; //조회된 데이터를 저장할 DTO 변수
		
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "SELECT in_no, m_memberid, in_area, in_title, in_address, in_telephone, in_content " + 
							"FROM p_information " +
							"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			//4. 명령 실행
			rs = pstmt.executeQuery();//select 구문 실행 메서드
			//5. 결과가 있을 경우 처리
			while (rs.next()) { //조회된 데이터가 있다면, while문으로 여러 게시글을 게시
				information = new Information();
				information.setIn_No(rs.getInt(1));
				information.setM_MemberId(rs.getString(2));
				information.setIn_Area(rs.getString(3));
				information.setIn_Title(rs.getString(4));				
				information.setIn_Address(rs.getString(5));
				information.setIn_Telephone(rs.getString(6));
				information.setIn_Content(rs.getString(7));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return information;//조회 성공하면 Board 아니면 null
	}
	
	public Information selectBoardByBoardNo3(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Information information = null; //조회된 데이터를 저장할 DTO 변수
		
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "SELECT in_no, m_memberid, in_area, in_title, in_address, in_telephone, in_content " + 
							"FROM p_information " +
							"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			//4. 명령 실행
			rs = pstmt.executeQuery();//select 구문 실행 메서드
			//5. 결과가 있을 경우 처리
			while (rs.next()) { //조회된 데이터가 있다면, while문으로 여러 게시글을 게시
				information = new Information();
				information.setIn_No(rs.getInt(1));
				information.setM_MemberId(rs.getString(2));
				information.setIn_Area(rs.getString(3));
				information.setIn_Title(rs.getString(4));				
				information.setIn_Address(rs.getString(5));
				information.setIn_Telephone(rs.getString(6));
				information.setIn_Content(rs.getString(7));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return information;//조회 성공하면 Board 아니면 null
	}
	
	public Information selectBoardByBoardNo4(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Information information = null; //조회된 데이터를 저장할 DTO 변수
		
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "SELECT in_no, m_memberid, in_area, in_title, in_address, in_telephone, in_content " + 
							"FROM p_information " +
							"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			//4. 명령 실행
			rs = pstmt.executeQuery();//select 구문 실행 메서드
			//5. 결과가 있을 경우 처리
			while (rs.next()) { //조회된 데이터가 있다면, while문으로 여러 게시글을 게시
				information = new Information();
				information.setIn_No(rs.getInt(1));
				information.setM_MemberId(rs.getString(2));
				information.setIn_Area(rs.getString(3));
				information.setIn_Title(rs.getString(4));				
				information.setIn_Address(rs.getString(5));
				information.setIn_Telephone(rs.getString(6));
				information.setIn_Content(rs.getString(7));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return information;//조회 성공하면 Board 아니면 null
	}
	
	public Information selectBoardByBoardNo5(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Information information = null; //조회된 데이터를 저장할 DTO 변수
		
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "SELECT in_no, m_memberid, in_area, in_title, in_address, in_telephone, in_content " + 
							"FROM p_information " +
							"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			//4. 명령 실행
			rs = pstmt.executeQuery();//select 구문 실행 메서드
			//5. 결과가 있을 경우 처리
			while (rs.next()) { //조회된 데이터가 있다면, while문으로 여러 게시글을 게시
				information = new Information();
				information.setIn_No(rs.getInt(1));
				information.setM_MemberId(rs.getString(2));
				information.setIn_Area(rs.getString(3));
				information.setIn_Title(rs.getString(4));				
				information.setIn_Address(rs.getString(5));
				information.setIn_Telephone(rs.getString(6));
				information.setIn_Content(rs.getString(7));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return information;//조회 성공하면 Board 아니면 null
	}
	
	public Information selectBoardByBoardNo6(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Information information = null; //조회된 데이터를 저장할 DTO 변수
		
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "SELECT in_no, m_memberid, in_area, in_title, in_address, in_telephone, in_content " + 
							"FROM p_information " +
							"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			//4. 명령 실행
			rs = pstmt.executeQuery();//select 구문 실행 메서드
			//5. 결과가 있을 경우 처리
			while (rs.next()) { //조회된 데이터가 있다면, while문으로 여러 게시글을 게시
				information = new Information();
				information.setIn_No(rs.getInt(1));
				information.setM_MemberId(rs.getString(2));
				information.setIn_Area(rs.getString(3));
				information.setIn_Title(rs.getString(4));				
				information.setIn_Address(rs.getString(5));
				information.setIn_Telephone(rs.getString(6));
				information.setIn_Content(rs.getString(7));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return information;//조회 성공하면 Board 아니면 null
	}
	
	public Information selectBoardByBoardNo7(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Information information = null; //조회된 데이터를 저장할 DTO 변수
		
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "SELECT in_no, m_memberid, in_area, in_title, in_address, in_telephone, in_content " + 
							"FROM p_information " +
							"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			//4. 명령 실행
			rs = pstmt.executeQuery();//select 구문 실행 메서드
			//5. 결과가 있을 경우 처리
			while (rs.next()) { //조회된 데이터가 있다면, while문으로 여러 게시글을 게시
				information = new Information();
				information.setIn_No(rs.getInt(1));
				information.setM_MemberId(rs.getString(2));
				information.setIn_Area(rs.getString(3));
				information.setIn_Title(rs.getString(4));				
				information.setIn_Address(rs.getString(5));
				information.setIn_Telephone(rs.getString(6));
				information.setIn_Content(rs.getString(7));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return information;//조회 성공하면 Board 아니면 null
	}
	
	public Information selectBoardByBoardNo8(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Information information = null; //조회된 데이터를 저장할 DTO 변수
		
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "SELECT in_no, m_memberid, in_area, in_title, in_address, in_telephone, in_content " + 
							"FROM p_information " +
							"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			//4. 명령 실행
			rs = pstmt.executeQuery();//select 구문 실행 메서드
			//5. 결과가 있을 경우 처리
			while (rs.next()) { //조회된 데이터가 있다면, while문으로 여러 게시글을 게시
				information = new Information();
				information.setIn_No(rs.getInt(1));
				information.setM_MemberId(rs.getString(2));
				information.setIn_Area(rs.getString(3));
				information.setIn_Title(rs.getString(4));				
				information.setIn_Address(rs.getString(5));
				information.setIn_Telephone(rs.getString(6));
				information.setIn_Content(rs.getString(7));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return information;//조회 성공하면 Board 아니면 null
	}
	
	
	///////////////////////////////////////<UP.DEL(1)>//////////////////////////////////////////
	
	public void deleteBoard(int boardNo) {		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "DELETE FROM p_information " +
						 	"WHERE in_NO = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);			
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
	
	public void updateBoard(Information board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE p_information " +
						 	"SET in_title = ?, m_memberid = ?, in_address = ?, in_telephone = ?, in_content = ? " +
						 	"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getIn_Title());
			pstmt.setString(2, board.getM_MemberId());
			pstmt.setString(3, board.getIn_Address());
			pstmt.setString(4, board.getIn_Telephone());
			pstmt.setString(5, board.getIn_Content());
			pstmt.setInt(6, board.getIn_No());
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
	
	///////////////////////////////////////<UP.DEL(2)>//////////////////////////////////////////
	
	public void deleteBoard2(int boardNo) {		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "DELETE FROM p_information " +
						 	"WHERE in_NO = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);			
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
	
	public void updateBoard2(Information board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE p_information " +
						 	"SET in_title = ?, m_memberid = ?, in_address = ?, in_telephone = ?, in_content = ? " +
						 	"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getIn_Title());
			pstmt.setString(2, board.getM_MemberId());
			pstmt.setString(3, board.getIn_Address());
			pstmt.setString(4, board.getIn_Telephone());
			pstmt.setString(5, board.getIn_Content());
			pstmt.setInt(6, board.getIn_No());
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
	
	///////////////////////////////////////<UP.DEL(3)>//////////////////////////////////////////
	
	public void deleteBoard3(int boardNo) {		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "DELETE FROM p_information " +
						 	"WHERE in_NO = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);			
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
	
	public void updateBoard3(Information board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE p_information " +
						 	"SET in_title = ?, m_memberid = ?, in_address = ?, in_telephone = ?, in_content = ? " +
						 	"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getIn_Title());
			pstmt.setString(2, board.getM_MemberId());
			pstmt.setString(3, board.getIn_Address());
			pstmt.setString(4, board.getIn_Telephone());
			pstmt.setString(5, board.getIn_Content());
			pstmt.setInt(6, board.getIn_No());
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
	
	///////////////////////////////////////<UP.DEL(4)>//////////////////////////////////////////
	
	public void deleteBoard4(int boardNo) {		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "DELETE FROM p_information " +
						 	"WHERE in_NO = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);			
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
	
	public void updateBoard4(Information board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE p_information " +
						 	"SET in_title = ?, m_memberid = ?, in_address = ?, in_telephone = ?, in_content = ? " +
						 	"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getIn_Title());
			pstmt.setString(2, board.getM_MemberId());
			pstmt.setString(3, board.getIn_Address());
			pstmt.setString(4, board.getIn_Telephone());
			pstmt.setString(5, board.getIn_Content());
			pstmt.setInt(6, board.getIn_No());
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
	
	///////////////////////////////////////<UP.DEL(5)>//////////////////////////////////////////
	
	public void deleteBoard5(int boardNo) {		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "DELETE FROM p_information " +
						 	"WHERE in_NO = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);			
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
	
	public void updateBoard5(Information board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE p_information " +
						 	"SET in_title = ?, m_memberid = ?, in_address = ?, in_telephone = ?, in_content = ? " +
						 	"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getIn_Title());
			pstmt.setString(2, board.getM_MemberId());
			pstmt.setString(3, board.getIn_Address());
			pstmt.setString(4, board.getIn_Telephone());
			pstmt.setString(5, board.getIn_Content());
			pstmt.setInt(6, board.getIn_No());
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
	
	///////////////////////////////////////<UP.DEL(6)>//////////////////////////////////////////
	
	public void deleteBoard6(int boardNo) {		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "DELETE FROM p_information " +
						 	"WHERE in_NO = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);			
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
	
	public void updateBoard6(Information board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE p_information " +
						 	"SET in_title = ?, m_memberid = ?, in_address = ?, in_telephone = ?, in_content = ? " +
						 	"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getIn_Title());
			pstmt.setString(2, board.getM_MemberId());
			pstmt.setString(3, board.getIn_Address());
			pstmt.setString(4, board.getIn_Telephone());
			pstmt.setString(5, board.getIn_Content());
			pstmt.setInt(6, board.getIn_No());
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
	
	///////////////////////////////////////<UP.DEL(7)>//////////////////////////////////////////
	
	public void deleteBoard7(int boardNo) {		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "DELETE FROM p_information " +
						 	"WHERE in_NO = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);			
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
	
	public void updateBoard7(Information board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE p_information " +
						 	"SET in_title = ?, m_memberid = ?, in_address = ?, in_telephone = ?, in_content = ? " +
						 	"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getIn_Title());
			pstmt.setString(2, board.getM_MemberId());
			pstmt.setString(3, board.getIn_Address());
			pstmt.setString(4, board.getIn_Telephone());
			pstmt.setString(5, board.getIn_Content());
			pstmt.setInt(6, board.getIn_No());
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
	
	///////////////////////////////////////<UP.DEL(8)>//////////////////////////////////////////
	
	public void deleteBoard8(int boardNo) {		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "DELETE FROM p_information " +
						 	"WHERE in_NO = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);			
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
	
	public void updateBoard8(Information board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
					"seoul", "789123");//계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE p_information " +
						 	"SET in_title = ?, m_memberid = ?, in_address = ?, in_telephone = ?, in_content = ? " +
						 	"WHERE in_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getIn_Title());
			pstmt.setString(2, board.getM_MemberId());
			pstmt.setString(3, board.getIn_Address());
			pstmt.setString(4, board.getIn_Telephone());
			pstmt.setString(5, board.getIn_Content());
			pstmt.setInt(6, board.getIn_No());
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
	

		





