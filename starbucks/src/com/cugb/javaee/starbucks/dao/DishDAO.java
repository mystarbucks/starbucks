package com.cugb.javaee.starbucks.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cugb.javaee.starbucks.bean.Dish;


/**
 * ��Ʒ��Ϣ����ӿڣ���Ҫ���ܰ����� 1.���Ӳ�Ʒ��Ϣ�� 2.�޸Ĳ�Ʒ��Ϣ�� 3.ɾ����Ʒ��Ϣ�� 4.��ѯ���в�Ʒ��Ϣ��
 *
 */
public interface DishDAO {
	/**
	 * ���Ӳ�Ʒ��Ϣ��
	 * 
	 * @param Dish
	 *            ������Ʒ��Ϣ�Ķ���
	 * @return ���ӵĲ�Ʒ��������
	 * @throws SQLException
	 *             ִ�в��������κ��쳣ʱ��
	 */
	public int addDish(Dish dish) throws SQLException;

	/**
	 * ɾ��ָ���Ĳ�Ʒ��Ϣ��
	 * 
	 * @param dishidΪҪɾ���Ĳ�Ʒ��ID��
	 * @return �Ѿ�ɾ���Ĳ�Ʒ��������
	 * @throws SQLException
	 *             ִ�в��������κ��쳣ʱ��
	 */
	public int removeDish(int dishid) throws SQLException;

	/**
	 * �޸�ָ���Ĳ�Ʒ��Ϣ�������޸ĵ���Ϣ������ ԭ��Ʒid ���ĳɵĲ�Ʒȫ����Ϣ��
	 * 
	 * @param Dish
	 *            ������Ʒ��Ϣ�Ķ���
	 * @return ���޸ĵĲ�Ʒ��������
	 * @throws SQLException
	 *             ִ�в��������κ��쳣ʱ��
	 */
	public int modifyDish(Dish dish) throws SQLException;

	/**
	 * ��ѯ���еĲ�Ʒ��Ϣ��
	 * 
	 * @return ������Ʒ��Ϣ�����ݽṹ�����û�з���NULL��
	 * @throws SQLException
	 *             ִ�в��������κ��쳣ʱ��
	 */
	public ArrayList findDishs() throws SQLException;

	/**
	 * ��ѯ��һ�Ĳ�Ʒ��Ϣ��
	 * 
	 * @param Dish
	 *            ��id
	 * @return �ò�Ʒ��������Ϣ
	 * @throws SQLException
	 *             ִ�в��������κ��쳣ʱ��
	 */
	public Dish findDish(int dishid) throws SQLException;

	/**
	 * ��ѯ������Ĳ�Ʒ��Ϣ��
	 * 
	 * @param
	 * @return ���²�Ʒ����Ϣ
	 * @throws SQLException
	 *             ִ�в��������κ��쳣ʱ��
	 */
	public Dish findMaxDish() throws SQLException;

	/**
	 * ���ز�Ʒ����
	 */
	public int getTotalDishs(String strsql);

	ArrayList<Dish> findDishs(String sql, Object[] params);
}
