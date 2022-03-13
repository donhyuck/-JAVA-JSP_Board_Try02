package com.don.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.don.board.model.article.Article;
import com.don.board.model.article.ArticleDB;
import com.don.board.model.article.Reply;
import com.don.board.model.article.replyDB;

@WebServlet("/article/*")
public class ArticleController extends HttpServlet {

	ArticleDB db = new ArticleDB();
	replyDB rdb = new replyDB();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

		if (func.equals("write")) {

			write(request, response);

		} else if (func.equals("modify")) {

			modify(request, response);

		} else if (func.equals("delete")) {

			delete(request, response);

		} else if (func.equals("replyWrite")) {

			replyWrite(request, response);

		} else if (func.equals("replyModify")) {

			replyModify(request, response);

		} else if (func.equals("replyDelete")) {

			replyDelete(request, response);

		}

	}

	// 자원을 가져올때 사용
	protected void getProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String func = (String) request.getAttribute("func");

		if (func.equals("showList")) {

			showList(request, response);

		} else if (func.equals("showAddForm")) {

			showAddForm(request, response);

		} else if (func.equals("showModifyForm")) {

			showModifyForm(request, response);

		} else if (func.equals("showDetail")) {

			showDetail(request, response);

		} else if (func.equals("showReplyModifyForm")) {

			showReplyModifyForm(request, response);

		}
	}

	// 게시글 작성하기
	private void write(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String title = request.getParameter("title");
		String body = request.getParameter("body");
		String name = request.getParameter("name");

		db.articleWrite(title, body, name);

		showList(request, response);
	}

	// 게시글 수정하기
	private void modify(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int idx = Integer.parseInt(request.getParameter("idx"));
		String title = request.getParameter("title");
		String body = request.getParameter("body");

		db.articleModify(idx, title, body);

		response.sendRedirect("/article/showDetail?idx=" + idx);
	}

	// 게시글 삭제하기
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int idx = Integer.parseInt(request.getParameter("idx"));

		db.articleDelete(idx);

		response.sendRedirect("/article/showList");
	}

	// 댓글 등록하기
	private void replyWrite(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int articleIdx = Integer.parseInt(request.getParameter("articleIdx"));
		String body = request.getParameter("body");
		String name = request.getParameter("name");

		rdb.replyWrite(articleIdx, body, name);

		response.sendRedirect("/article/showDetail?idx=" + articleIdx);

	}

	// 댓글 수정하기
	private void replyModify(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int idx = Integer.parseInt(request.getParameter("idx"));
		int articleIdx = Integer.parseInt(request.getParameter("articleIdx"));
		String body = request.getParameter("body");

		rdb.replyModify(idx, body);
		response.sendRedirect("/article/showDetail?idx=" + articleIdx);
	}

	// 댓글 삭제하기
	private void replyDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int idx = Integer.parseInt(request.getParameter("idx"));
		int articleIdx = Integer.parseInt(request.getParameter("articleIdx"));

		rdb.replyDelete(idx);
		response.sendRedirect("/article/showDetail?idx=" + articleIdx);
	}

	// 게시글 목록보기
	private void showList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Article> articleList = db.getArticles(); // DB에서 데이터 받아올 틀
		request.setAttribute("articleList", articleList); // request에 데이터를 담는다.

		// 팝업 추가
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("popup")) {
					request.setAttribute("popup", c.getValue());
				}
			}
		}

		forward(request, response, "/Article/list.jsp");

	}

	// 게시글 등록 페이지보기
	private void showAddForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 로그인한 회원의 이름
		HttpSession session = request.getSession();
		String loginedUserName = (String) request.getAttribute("loginedUserName");

		forward(request, response, "/Article/addForm.jsp");
	}

	// 게시글 수정 페이지 보기
	private void showModifyForm(HttpServletRequest request, HttpServletResponse response) {

		int idx = Integer.parseInt(request.getParameter("idx"));
		Article article = db.getArticleByIdx(idx);
		request.setAttribute("article", article);

		forward(request, response, "/Article/modifyForm.jsp");
	}

	// 게시글 상세보기
	private void showDetail(HttpServletRequest request, HttpServletResponse response) {

		int idx = Integer.parseInt(request.getParameter("idx"));
		Article article = db.getArticleByIdx(idx);
		request.setAttribute("article", article);

		// 해당 게시글의 댓글 목록 보기
		ArrayList<Reply> replyList = rdb.getReplyListByArticleIdx(idx);
		request.setAttribute("replyList", replyList);

		forward(request, response, "/Article/showDetail.jsp");
	}

	// 댓글 수정 페이지보기
	private void showReplyModifyForm(HttpServletRequest request, HttpServletResponse response) {

		int idx = Integer.parseInt(request.getParameter("idx"));
		Reply reply = rdb.getReplyByIdx(idx);
		request.setAttribute("reply", reply);

		forward(request, response, "/Article/replyModifyForm.jsp");
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
