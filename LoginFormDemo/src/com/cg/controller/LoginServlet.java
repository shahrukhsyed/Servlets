package com.cg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.bean.Login;
import com.cg.service.LoginService;
import com.cg.service.LoginServiceImpl;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      LoginService service=new LoginServiceImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String qstr=request.getParameter("action");
		if("index".equals(qstr)){
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("login.html");
			dispatcher.forward(request,response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String qstr=request.getParameter("action");
		if("login".equals(qstr)){
		String user=request.getParameter("username");
		String password=request.getParameter("password");
		Login login=new Login(user,password);
		Login obj=service.loginUser(login);
		if(obj!=null){
		PrintWriter out=response.getWriter();
		out.println("Welcome\n, you have logged in with username: "+user+" and password: "+password);		
		}
		}
	}

}
