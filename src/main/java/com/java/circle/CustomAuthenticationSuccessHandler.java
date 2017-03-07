package com.java.circle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.java.circle.command.CCircleCheckCommand;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private String loginidname; //로그인 id 값이 들어오는
	private String loginpasswdname;
	private String loginredirectname;
	private String exceptionmsgname;
	private String defaultSuccessUrl;
	

	public CustomAuthenticationSuccessHandler() {
		
		this.loginidname = "account";
		this.loginpasswdname = "password";
		this.loginredirectname = "loginRedirect";
		this.exceptionmsgname = "securityexceptionmsg";
		this.defaultSuccessUrl = "/check_circle";
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


	public String getDefaultSuccessUrl() {
		return defaultSuccessUrl;
	}


	public void setDefaultSuccessUrl(String defaultSuccessUrl) {
		this.defaultSuccessUrl = defaultSuccessUrl;
	}


	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String loginid = request.getParameter(loginidname);
		String loginpasswd = request.getParameter(loginpasswdname);
		String loginRedirect = request.getParameter(loginredirectname);
		
		request.setAttribute(loginidname, loginid);
		request.setAttribute(loginpasswdname, loginpasswd);
		request.setAttribute(loginredirectname, loginRedirect);
		
		request.getRequestDispatcher(defaultSuccessUrl).forward(request, response);
		
	}

}
