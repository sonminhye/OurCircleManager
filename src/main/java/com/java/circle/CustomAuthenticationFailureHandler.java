package com.java.circle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/* 이 클래스는, 로그인이 실패하였을 경우 어떠한 이유 때문에 실패하였는지를 알아보기 위해 만든 핸들러 클래스임 */
/* 그냥 security-context 안에 있는 구문으로는 어떠한 에러 로그도 나오지 않기 때문에 이런식으로 따로 클래스를 만들어
 *  exception 으로 알 수 있는 듯 하다 */

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	private String loginidname; //로그인 id 값이 들어오는
	private String loginpasswdname;
	private String loginredirectname;
	private String exceptionmsgname;
	private String defaultFailureUrl;
	

	public CustomAuthenticationFailureHandler() {
		
		this.loginidname = "account";
		this.loginpasswdname = "password";
		this.loginredirectname = "loginRedirect";
		this.exceptionmsgname = "securityexceptionmsg";
		this.defaultFailureUrl = "/signin_view?fail=true";
	}


	public String getLoginidname() {
		return loginidname;
	}


	public void setLoginidname(String loginidname) {
		this.loginidname = loginidname;
	}


	public String getLoginpasswdname() {
		return loginpasswdname;
	}


	public void setLoginpasswdname(String loginpasswdname) {
		this.loginpasswdname = loginpasswdname;
	}


	public String getLoginredirectname() {
		return loginredirectname;
	}


	public void setLoginredirectname(String loginredirectname) {
		this.loginredirectname = loginredirectname;
	}


	public String getExceptionmsgname() {
		return exceptionmsgname;
	}


	public void setExceptionmsgname(String exceptionmsgname) {
		this.exceptionmsgname = exceptionmsgname;
	}


	public String getDefaultFailureUrl() {
		return defaultFailureUrl;
	}


	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}


	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		String loginid = request.getParameter(loginidname);
		String loginpasswd = request.getParameter(loginpasswdname);
		String loginRedirect = request.getParameter(loginredirectname);
		
		System.out.println("authentication Failure 함수 ");
		System.out.println(loginidname + " : " + loginid);
		
		request.setAttribute(loginidname, loginid);
		request.setAttribute(loginpasswdname, loginpasswd);
		request.setAttribute(loginredirectname, loginRedirect);
		
		request.setAttribute(exceptionmsgname, exception);

		request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
		
	}

}
