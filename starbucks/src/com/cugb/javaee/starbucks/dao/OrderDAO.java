package com.cugb.javaee.starbucks.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cugb.javaee.starbucks.bean.Order;


public interface OrderDAO {
	/**
	 * 	
	 * @param order �����һ��Ԕ��
	 * @return
	 * @throws SQLException
	 */
	public int addOrder(Order order) throws SQLException;

	/**
	 * 
	 * @param string
	 * @return 
	 * @throws SQLException
	 */
	//public int removeOrder(String string) throws SQLException;

	/**
	 * 
	 * @param order
	 * @return
	 * @throws SQLException
	 */
	public int modifyOrder(String orderId, String paystatus) throws SQLException;

	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public ArrayList findOrders(String userId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
}
