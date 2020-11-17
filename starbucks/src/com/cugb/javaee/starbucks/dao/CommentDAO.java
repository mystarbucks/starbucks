package com.cugb.javaee.starbucks.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cugb.javaee.starbucks.bean.CommentItem;
import com.cugb.javaee.starbucks.bean.Dish;

/**
 * ������Ϣ����ӿڣ���Ҫ���ܰ�����
 * 1.����������Ϣ��
 * 2.�޸�������Ϣ��
 * 3.ɾ��������Ϣ��
 */
public interface CommentDAO {
	public int addComment(CommentItem res) throws SQLException;

	public int removeComment(int Commentid) throws SQLException; 

	public int modifyComment(CommentItem res) throws SQLException; 
	
	public ArrayList findComments(int dishid) throws SQLException;
	
	public CommentItem findComment(int commentid) throws SQLException;
}
