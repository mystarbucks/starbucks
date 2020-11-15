package com.cugb.javaee.starbucks.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cugb.javaee.starbucks.bean.Restaurant;

/**
 * ������Ϣ����ӿڣ���Ҫ���ܰ�����
 * 1.���Ӳ�����Ϣ��
 * 2.�޸Ĳ�����Ϣ��
 * 3.ɾ��������Ϣ��
 * 4.���ݲ���id��ȡ��������
 */
public interface RestaurantDAO {
	
	public int addRestaurant(Restaurant res) throws SQLException;

	public int removeRestaurant(int restaurantid) throws SQLException; 

	public int modifyDish(Restaurant res) throws SQLException; 

	public Restaurant findRestaurant(int restaurantid) throws SQLException; 

	public ArrayList findRestaurants() throws SQLException;
}
