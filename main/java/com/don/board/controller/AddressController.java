package com.don.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/address/*")
public class AddressController extends HttpServlet {

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

	protected void postProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String func = (String) request.getAttribute("func");

		if (func.equals("write")) {

			// 주소록 등록하기

		}
	}

	protected void getProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String func = (String) request.getAttribute("func");

		if (func.equals("showAddrMenu")) {

			// 주소록 메뉴 페이지 보기
			forward(request, response, "/Address/addrMenu.jsp");
		}
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
