package com.cugb.javaee.starbucks.action;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cugb.javaee.starbucks.bean.CommentItem;
import com.cugb.javaee.starbucks.bean.Dish;
import com.cugb.javaee.starbucks.dao.CommentDAO;
import com.cugb.javaee.starbucks.dao.DishDAO;
import com.cugb.javaee.starbucks.utils.DAOFactory;

public class CommentAddControl extends HttpServlet {

	
	public CommentAddControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("��������");
		System.out.println(request.getParameter("commentid"));
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("dishid"));
		System.out.println(request.getParameter("commentid"));
		System.out.println(request.getParameter("commenttext"));
		
		java.util.Date today = new java.util.Date();
		Timestamp timestamp = new Timestamp(today.getTime());
		CommentItem commentItem = new CommentItem();
		//commentItem.setCommentid(6);
		commentItem.setUsername(request.getParameter("username"));
		commentItem.setDishid(Integer.parseInt(request.getParameter("dishid")));
		commentItem.setTime(timestamp);
		commentItem.setCommenttext(request.getParameter("commenttext"));

		
		CommentDAO commentdao= (CommentDAO) DAOFactory.newInstance("CommentDAO");
		System.out.println("������");
		 try { 
			 commentdao.addComment(commentItem); Dish current = new Dish(); 
			 DishDAO dishdao = (DishDAO) DAOFactory.newInstance("DishDAO"); 
			 current =dishdao.findDish(Integer.parseInt(request.getParameter("dishid")));
			 request.setAttribute("current", current);
			 request.getRequestDispatcher("showdetails.jsp").forward(request, response); }
		  	catch (SQLException e) { 
		  		// TODO Auto-generated catch block
		  		e.printStackTrace(); 
		  	}
		 
	}
	
}
