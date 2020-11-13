package com.cugb.javaee.starbucks.biz;

import java.sql.SQLException;

import com.cugb.javaee.starbucks.bean.Customer;
import com.cugb.javaee.starbucks.dao.CustomerDAO;
import com.cugb.javaee.starbucks.utils.DAOFactory;

/**
 * 
 * @author fcxl9876
 * ҵ���߼����ж��û��Ƿ���ڡ���֤�û���¼ͨ����
 * 2018��11��20��
 */
public class CustomerService {
	CustomerDAO CustomerDAO = null;
	public boolean isExistCustomer(String username) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		CustomerDAO = (CustomerDAO) DAOFactory.newInstance("CustomerDAO");
		Customer customer = CustomerDAO.findCustomer(username);
		if(customer != null)
			return true;
		else return false;
	}
	public boolean validateCustomer(Customer customer) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		CustomerDAO CustomerDAO = (CustomerDAO) DAOFactory.newInstance("CustomerDAO");
		Customer cus = CustomerDAO.findCustomer(customer.getUsername());
		if(cus.getPassword().equals(customer.getPassword()))
			return true;
		else return false;
	}
}
