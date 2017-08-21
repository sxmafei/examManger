package com.mf.shiro.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.mf.util.Cryptography;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("login doget");
		req.getRequestDispatcher("login.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("login DOPOST");
		String username=req.getParameter("userName");
		String password=Cryptography.md5(req.getParameter("password"), "1234");
		Subject currentUser= SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(username,password);
		try {
			if (currentUser.isRemembered()) {
				System.out.println("已被记住");
			} else {
                token.setRememberMe(true);                
			}
			currentUser.login(token);
			Session session=currentUser.getSession();
			System.out.println("session ID:"+session.getId()); 
			System.out.println(" 主机地址:"+session.getHost());
			System.out.println("session有效期：" +session.getTimeout());
			System.out.println(session.getStartTimestamp() );
			System.out.println(session.getLastAccessTime());
			System.out.println(session.getClass());
			session.setAttribute("info", "session回话");
			resp.sendRedirect("success.jsp");
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("errorinfor","用户名或者密码错误");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
		
	}
	
	

}
