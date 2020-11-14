package com.cugb.javaee.starbucks.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cugb.javaee.starbucks.bean.Customer;
import com.cugb.javaee.starbucks.biz.CustomerService;
import com.cugb.javaee.starbucks.utils.ConfigFactory;

/**
 * Servlet implementation class LoginContrler
 */
//@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public LoginControl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request,response);
		String adminUsername = ConfigFactory.readProperty("username");
		String adminPassword = ConfigFactory.readProperty("password");
		
		String username = request.getParameter("loginName");
		String password = request.getParameter("loginPass");
		Customer loginuser = new Customer();
		loginuser.setUsername(username);
		loginuser.setPassword(password);
		
		//���ݿ���֤
		CustomerService cService = new CustomerService();
		try {
			if (username.equals(adminUsername) && password.equals(adminPassword)) {
				//����Ա ��֤ͨ��
				HttpSession session = request.getSession(true);
				session.setAttribute("loginuser", loginuser);
				session.setAttribute("admin", true);
				request.getRequestDispatcher("adminIndex.jsp").forward(request, response);
			} else if (cService.validateCustomer(loginuser)) {
				//��ͨ�û� ��֤ͨ��
				HttpSession session = request.getSession(true);
				session.setAttribute("loginuser", loginuser);
				session.setAttribute("admin", false);
				request.getRequestDispatcher("customerIndex.jsp").forward(request, response);
			}
			else {
				//�������µ�¼
				response.sendRedirect("customerLogin.jsp");
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
