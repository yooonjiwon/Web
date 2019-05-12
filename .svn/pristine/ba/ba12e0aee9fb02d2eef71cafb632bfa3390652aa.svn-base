package com.seoul.guideservlet;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seoul.common.Util;
import com.seoul.dao.MemberDao;
import com.seoul.dto.Member;
import com.sun.mail.smtp.SMTPSaslAuthenticator;

@WebServlet("/seoulmate/sendmail.action")
public class GuideMailServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				
		RequestDispatcher dispatcher = 
			req.getRequestDispatcher("/WEB-INF/views/seoulmate/guidemail.jsp");
		
		dispatcher.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		// 1. 요청 데이터 읽기
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		//Member member = (Member) request.getSession().getAttribute("loginuser");
		//String from = member.getEmail();
/*		String to = "bigdata040@gmail.com"; 	//email
		String cc = "whtjdfhr97@gmail.com";		//email
		String bcc = "whtjdfhr99@naver.com";	//email
*/		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		// 이메일 전송
		Properties props = System.getProperties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
//		props.put("mail.smtp.user", ""); //id		
//		props.put("mail.smtp.debug", "true");
//		props.put("mail.smtp.socketFactory.port", "465");
//		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//		props.put("mail.smtp.socketFactory.fallback", "false");

		Session session = Session.getDefaultInstance(props, new Authenticator() {
	        public PasswordAuthentication getPasswordAuthentication(){
	               return new PasswordAuthentication("bigdata040@gmail.com", "knitknit"); //email, passwd
	        }
		});// 연결

		MimeMessage message = new MimeMessage(session);
		try {
			// 메시지 설정
			message.setFrom(new InternetAddress(from));
			message.setRecipients(RecipientType.TO, to);
/*			message.setRecipients(RecipientType.CC, cc);
			message.setRecipients(RecipientType.BCC, bcc);*/
			message.setSubject(subject);
			message.setText(content, "utf-8");
			
			message.setHeader("content-type", "text/plain;charset=utf-8");

			Transport.send(message);// 전송
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		response.sendRedirect("/seoul/seoulmate/sendmail.action");

	}
}
