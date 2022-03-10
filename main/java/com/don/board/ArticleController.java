package com.don.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/article/*")
public class ArticleController extends HttpServlet {

	ArticleDB db = new ArticleDB();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("게시글");

		// 인코딩 설정
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// 사용자가 원하는 기능 분별
		String uri = request.getRequestURI();

		String[] uriPieces = uri.split("/");

		if (uriPieces.length < 3) {
			System.out.println("잘못된 요청입니다.");
			return;
		}

		String func = uriPieces[2];

		if (func.equals("write")) {

			// 게시글 작성하기
			String title = request.getParameter("title");
			String body = request.getParameter("body");
			String name = request.getParameter("name");

			db.articleWrite(title, body, name);
			showList(request, response);

		} else if (func.equals("showList")) {

			showList(request, response);

		} else if (func.equals("showAddForm")) {

			// 게시글 등록 페이지보기
			RequestDispatcher rd = request.getRequestDispatcher("/Article/addForm.jsp");
			rd.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// 게시글 목록보기
	private void showList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Article> articleList = db.getArticleList(); // DB에서 데이터 받아올 틀
		request.setAttribute("articleList", articleList); // request에 데이터를 담는다.

		forward(request, response, "/Article/list.jsp");

	}

	// 포워드
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
