package com.don.board.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/article/showDetail", "/article/showAddForm", "/address/showAddForm",
		"/address/showMyAddrList" })
public class loginCheckFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		// 로그인 설정
		// 로그아웃 상태이면 로그인 페이지로 이동
		HttpSession session = req.getSession();

		if (session.getAttribute("loginedUserName") == null) {
			res.sendRedirect("/member/showLoginForm.do");
			return;
		}

		chain.doFilter(request, response);
	}

}
