package com.don.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("*.do")
public class MemberController extends HttpServlet {

	MemberDB db = new MemberDB();
	ArticleDB adb = new ArticleDB();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 인코딩 설정
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// 사용자가 원하는 기능 분별
		String uri = request.getRequestURI();

		String[] uriPieces = uri.split("/");

		if (uriPieces.length < 3) {
			System.out.println("잘못된 요청입니다.");
			return;
		}

		String func = uriPieces[2];

		// POST, GET 처리구분
		String method = request.getMethod();

		request.setAttribute("func", func);

		if (method.equals("POST")) {

			postProcess(request, response);

		} else if (method.equals("GET")) {

			getProcess(request, response);

		}

	}

	// 자원을 처리할때 사용
	protected void postProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String func = (String) request.getAttribute("func");

		if (func.equals("join.do")) {

			join(request, response);

		} else if (func.equals("login.do")) {

			login(request, response);

		}

	}

	// 자원을 가져올때 사용
	protected void getProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String func = (String) request.getAttribute("func");

		if (func.equals("showJoinForm.do")) {

			showJoinForm(request, response);

		} else if (func.equals("showLoginForm.do")) {

			showLoginForm(request, response);

		} else if (func.equals("logout.do")) {

			logout(request, response);

		}
	}

	// 회원가입
	private void join(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");
		String name = request.getParameter("name");

		db.memberJoin(loginId, loginPw, name);

		response.sendRedirect("/article/showList");

	}

	// 회원 가입 페이지 보기
	private void showJoinForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/Member/joinForm.jsp");
		rd.forward(request, response);

	}

	// 회원 로그인 페이지 보기
	private void showLoginForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		forward(request, response, "/Member/loginForm.jsp");

	}

	// 로그인 처리
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");

		int memberIdx = db.getMemberIdxByLoginInfo(loginId, loginPw);

		if (memberIdx != 0) {

			Member member = db.getMemberBymemberIdx(memberIdx);

			HttpSession session = request.getSession();
			session.setAttribute("loginedUserName", member.getName());

			// 쿠키 추가(리다이렉트 전에 쿠키 정보를 넣는다.)
			Cookie popupCookie = new Cookie("popup", "true");

			// 쿠키 설정
			popupCookie.setPath("/");
			popupCookie.setMaxAge(60 * 10); // 10분 간 유지

			response.addCookie(popupCookie);
			response.sendRedirect("/article/showList");

		} else {
			System.out.println("로그인 실패");
			response.sendRedirect("/article/showList");
		}
	}

	// 로그아웃 처리
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();
		session.removeAttribute("loginedUserName");

		response.sendRedirect("/article/showList");

	}

	// 포워드(요청정보를 재사용)
	private void forward(HttpServletRequest request, HttpServletResponse response, String path) {

		try {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		} catch (ServletException e) {
			System.out.println("포워딩 서블릿 에러발생");
		} catch (IOException e) {
			System.out.println("입출력 중 에러발생");
		} catch (Exception e) {
			System.out.println("포워딩 중 에러발생");
		}
	}
}
