package com.cugb.javaee.starbucks.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cugb.javaee.starbucks.bean.Customer;
import com.cugb.javaee.starbucks.biz.CustomerService;
import com.cugb.javaee.starbucks.dao.CustomerDAOImpl;

@WebServlet("/register")
public class RegisterControl extends baseControl {

	public RegisterControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ����
				super.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("registerName");
		String password = req.getParameter("registerPass");
		String password2 = req.getParameter("registerconfirmPass");
		String email = req.getParameter("registerEmail");
		Customer customer = new Customer();
		customer.setUsername(username);
		customer.setPassword(password);
		customer.setEmail(email);
		//�ж��Ƿ��ͻ�󣬽��û��洢�����ݿ���
		CustomerService cService = new CustomerService();
		RequestDispatcher rd = null;
		try {
			if(password.equals(password2))
			{
				if(cService.isExistCustomer(username)){
					//����û��Ѵ���
					PrintWriter out = resp.getWriter();
					String a = URLEncoder.encode("�û��Ѿ����ڣ����¼��", "UTF-8");  
			        out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='customerLogin.jsp'</script>"); 		
				}
				else{
					//ע��ɹ�
					CustomerDAOImpl cuMySqlImpl = new CustomerDAOImpl();
					cuMySqlImpl.addCustomer(customer);
					String a = URLEncoder.encode("ע��ɹ������½��", "UTF-8");  
					resp.getWriter().print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='customerLogin.jsp'</script>");
				}
			}
			else {
				PrintWriter out = resp.getWriter();
				String a = URLEncoder.encode("�������벻һ�£����������룡", "UTF-8");  
		        out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='customerLogin.jsp'</script>"); 		
			}
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
