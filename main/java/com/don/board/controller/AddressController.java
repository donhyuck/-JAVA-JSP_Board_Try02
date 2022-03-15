package com.don.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.don.board.model.address.Address;
import com.don.board.model.address.AddressDB;
import com.don.board.model.article.Reply;

@WebServlet("/address/*")
public class AddressController extends HttpServlet {

	AddressDB db = new AddressDB();

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

			write(request, response);

		} else if (func.equals("search")) {

			search(request, response);

		}
	}

	protected void getProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String func = (String) request.getAttribute("func");

		if (func.equals("showAddrMenu")) {

			// 주소록 메뉴 페이지 보기
			forward(request, response, "/Address/addrMenu.jsp");

		} else if (func.equals("showAddrList")) {

			showAddrList(request, response);

		} else if (func.equals("showAddForm")) {

			showAddForm(request, response);

		} else if (func.equals("showSearchForm")) {

			// 주소록 검색 페이지 보기
			forward(request, response, "/Address/searchForm.jsp");

		} else if (func.equals("showResultForm")) {

			// 주소록 검색결과 페이지 보기
			forward(request, response, "/Address/resultForm.jsp");

		} else if (func.equals("showMyAddrList")) {

			showMyAddrList(request, response);

		}
	}

	// 주소록 등록하기
	private void write(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String addr = request.getParameter("addr");
		String phone = request.getParameter("phone");
		String name = request.getParameter("name");

		db.addressWrite(addr, phone, name);

		response.sendRedirect("/address/showAddrMenu");
	}

	// 주소록 검색하기
	private void search(HttpServletRequest request, HttpServletResponse response) {

		String infoType = request.getParameter("infoType");
		String keyword = request.getParameter("keyword");
		ArrayList<Address> addressList = db.getAddressListByKeyword(infoType, keyword);

		request.setAttribute("addressList", addressList);

		forward(request, response, "/Address/resultForm.jsp");

	}

	// 주소록 전체 목록 보기
	private void showAddrList(HttpServletRequest request, HttpServletResponse response) {

		ArrayList<Address> addressList = db.getAddresses();
		request.setAttribute("addressList", addressList);

		forward(request, response, "/Address/list.jsp");
	}

	// 주소록 등록 페이지 보기
	private void showAddForm(HttpServletRequest request, HttpServletResponse response) {

		// 로그인 유저 정보 보내기
		HttpSession session = request.getSession();
		String loginedUserName = (String) request.getAttribute("loginedUserName");

		forward(request, response, "/Address/addForm.jsp");
	}

	// 등록된 내 주소록 목록 페이지 보기
	private void showMyAddrList(HttpServletRequest request, HttpServletResponse response) {

		// 로그인 유저 정보 보내기
		HttpSession session = request.getSession();
		String loginedUserName = (String) request.getAttribute("loginedUserName");
		
		// 주소록 목록
		ArrayList<Address> addressList = db.getAddresses();
		request.setAttribute("addressList", addressList);

		forward(request, response, "/Address/myAddrList.jsp");
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
