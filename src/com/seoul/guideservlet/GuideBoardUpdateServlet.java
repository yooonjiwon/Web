package com.seoul.guideservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seoul.dto.Guide;
import com.seoul.service.GuideBoardService;

@WebServlet(value ="/seoulmate/update.action")
public class GuideBoardUpdateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//아래 인증코드는 필터로 구현합니다.
		//로그인 하지 않은 경우 로그인 화면으로 이동
//		HttpSession session = req.getSession();
//		if (session.getAttribute("loginuser") == null) {
//			resp.sendRedirect("/demoweb/account/login.action");
//			return;
//		}
		
		
		//1.요청 데이터 읽기(boardno)
		// -boardno가 비정상인 경우 list.action으로 이동
		String sBoardNo = req.getParameter("gub_boardno");
		int gub_BoardNo = -1;
		try {
			gub_BoardNo = Integer.parseInt(sBoardNo);
		}	catch (Exception ex) {
			resp.sendRedirect("/seoul/list.action");
			return;
		}
		
		//2.boardno로 데이터 조회(boardService 사용)
		//조회 실패하면(결과가 null이면) list.action으로 이동
		GuideBoardService guideBoardService = new GuideBoardService();
		Guide guide = guideBoardService.findBoardByBoardNo(gub_BoardNo);
		if (guide == null) {
			resp.sendRedirect("/seoul/list.action");
			return;
		}
		
		
		//현재 페이지 번호 읽기
		String page = req.getParameter("pageno");
		//현재 페이지를 기본적으로 1페이지를 잡고 정상적으로 수행되면 그 요청된 페이지 번호를잡고 실패하면 1페이지로 유지
		int currentPage = 1; //요청된 페이지가 없을때 사용할 번호
		try {
			currentPage = Integer.parseInt(page); //요청된 페이지 번호
		} catch (Exception ex) {	
		}
		
		
		
		
		//3.조회 결과를 request 객체에 저장(jsp에서 사용하도록)
		req.setAttribute("guide", guide);
		req.setAttribute("pageno", currentPage);
		
		
		//4.detail.jsp로 이동
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/seoulmate/guideedit.jsp");
		dispatcher.forward(req, resp);

		
	}

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//브라우저에서 전송된 데이터(name이 memberId인 데이터)를 읽기
		//dao 의 ??? 에 들어갈것만
		
		
		//방법1. 현재 로그인한 아이디가 게시판 글 작성자로 들어갈수 있게 처리하는 방법
		//Member member = (Member)req.getSession().getAttribute("loginuser"); //로그인을 했으니까 세션정보가 있을거고 그 정보를 가져와서
		//String writer = member.getMemberId(); //데이터를 writer에서 사용할 수 있게해줌
		
		//방법2. 현재 로그인한 아이디가 게시판 글 작성자로 들어갈수 있게 처리하는 방법
		//브라우저에서 입력요소를 만들게 해놓고 서버쪽에서 그걸 읽는 방식
		//write.jsp에 input을 이용해서 입력요소 생성후 작성
		String sBoardNo = req.getParameter("gub_boardno");
		int gub_BoardNo = Integer.parseInt(sBoardNo);
		String gub_Name = req.getParameter("gub_name");
		String gub_Email = req.getParameter("gub_email");
		String gub_PassNo = req.getParameter("gub_passno");
		String gub_Phone = req.getParameter("gub_phone");
		String gub_Title = req.getParameter("gub_title");
		String gub_Intro = req.getParameter("gub_intro");
		String gub_HopeArea = req.getParameter("gub_hopearea");
		String gub_Nation = req.getParameter("gub_nation");
		String gub_Target = req.getParameter("gub_target");
		
		
		
		
/*		//브라우저 상에 응답을 띄워주는 단순 결과 반환
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println(memberId + "/" + passwd + "/" + confirm + "/" + email);*/
		
		
		////////////////////////////////////////////////////////
		/********************2번 ****************************/
		////////////////////////////////////////////////////////
		
		
		//사용자의 요청 데이터를 Board 객체에 저장
		Guide guide = new Guide();
		
		guide.setGub_BoardNo(gub_BoardNo);
		guide.setGub_Name(gub_Name);
		guide.setGub_Email(gub_Email);
		guide.setGub_PassNo(gub_PassNo);
		guide.setGub_Phone(gub_Phone);
		guide.setGub_Title(gub_Title);
		guide.setGub_Intro(gub_Intro);
		guide.setGub_HopeArea(gub_HopeArea);
		guide.setGub_Nation(gub_Nation);
		guide.setGub_Target(gub_Target);
		
		//regdate, active, usertype은 default는 기본값을 지정해두었기 떄문에 굳이 명시하지 않아도 된다.
		//굳이 하고 싶다면
		
		
		//member 데이터와함께 registerMember라는 호출기호같은걸 보낸다
		//사용자 수정 처리
		GuideBoardService guideBoardService = new GuideBoardService();
		guideBoardService.updateBoard(guide); //registerMember를 오류클릭해서 처리할 memberService라는 클래스 생성한다
		
		//회원가입을 완료한 후에 브라우저 화면을 home으로 이동
		//home.html 파일을 복사해서 views안에 붙여넣은후에 home.jsp로 이름 변경함(아래경로에 맞게끔)
		//jsp선언명령(jsp파일 맨위에 @ 로 시작하는 구문)을 home.jsp에 넣어 jsp파일 형식을 갖게해준다.
		
		//↓ forward 방식이기 때문에 브라우저상의 경로에 일관된 경로가 나타나지 않는다
		//RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/home.jsp");
		//dispatcher.forward(req, resp);
		
		//↓forward방식을 redirect방식으로 변경해서 다시 설정(하지만WEB-INF 경로에는 브라우저가 직접 참여하지 못하기때문에 404오류)
		//resp.sendRedirect("/demoweb/WEB-INF/views/home.jsp");
		
		//요청에 대한 서블릿을 브라우저가 접근 가능한 경로를 설정해주고 따로 생성해줘야 한다.
		// ★모든 요청은 서블릿으로가야하고 jsp는 그 서블릿의 구성물 역할을 한다고 생각하면 된다.★
		resp.sendRedirect("/seoul/seoulmate/detail.action?gub_boardno=" + gub_BoardNo);
	}
	
	
}




