package com.cugb.javaee.starbucks.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cugb.javaee.starbucks.bean.Customer;



/**
 * �û���Ϣ����ӿڣ���Ҫ���ܰ�����
 * 1.�����û���Ϣ��
 * 2.�޸��û���Ϣ��
 * 3.ɾ���û���Ϣ��
 * 4.��ѯ�����û���Ϣ��
 *
 */
public interface CustomerDAO {
	 /**
     * �����û���Ϣ�� 
     * @param customer �����û���Ϣ�Ķ���
     * @return ���ӵ��û���������
     * @throws SQLException ִ�в��������κ��쳣ʱ��
     */
    public int addCustomer(Customer customer) throws SQLException;
    
    /**
     * ɾ��ָ�����û���Ϣ��
     * @param string Ҫɾ�����û���ID��
     * @return �Ѿ�ɾ�����û���������
     * @throws SQLException ִ�в��������κ��쳣ʱ��
     */
    public int removeCustomer(String string) throws SQLException;
    
    /**
     * �޸�ָ�����û���Ϣ�������޸ĵ���Ϣ������
     * �û�id �û��� ���롣
     * @param customer �����û���Ϣ�Ķ���
     * @return ���޸ĵ��û���������
     * @throws SQLException ִ�в��������κ��쳣ʱ��
     */
    public int modifyCustomer(Customer customer) throws SQLException;
    
    /**
     * ��ѯ���е��û���Ϣ��
     * @return �����û���Ϣ�����ݽṹ�����û�з���NULL��
     * @throws SQLException ִ�в��������κ��쳣ʱ��
     */
    public ArrayList findCustomers() throws SQLException;
    
    /**
     * ��ѯ��һ���û���Ϣ��
     * @param customer ��username
     * @return ���û���������Ϣ
     * @throws SQLException ִ�в��������κ��쳣ʱ��
     */
    public Customer findCustomer(String string) throws SQLException;
}
