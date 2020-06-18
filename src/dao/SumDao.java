package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import mybean.Beans;

public class SumDao extends Dao {

	public List<Beans> findUsersSum() {
		// ͨ�������� �û���, ���������Ӳ�ѯ�û����˺ţ��û�����������sum��buyNum���������ܼ�  sum(buyNum*newsPrice)
		QueryRunner qr = new QueryRunner(ds);
		String sql = "select  Users.userID, userName, Sum(buyNum) as buyNum, sum(buyNum*newsPrice) sumPrice from Goods, Users, News  where Users.userID = Goods.userID and News.newsID = Goods.newsID group by Users.userID, userName";
		
		try {
			return qr.query(sql, new BeanListHandler<>(Beans.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Beans> findNewsSum() {
		// ͨ��������ͱ���������ӣ���ѯ�����ţ��������� ���������� ���ۼ�
		QueryRunner qr = new QueryRunner(ds);
		String sql = "select News.newsID, newsName, sum(buyNum) as sellNum, sum(buyNum * newsPrice) as sumPrice from Users, News, Goods where Users.userID = Goods.userID and News.newsID = Goods.newsID group by News.newsID, newsName";
		try {
			return qr.query(sql, new BeanListHandler<>(Beans.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Beans> findPublishSum() {
		// ͨ��������ͱ�����ͱ�������Ӳ�ѯ����ţ����������۳����������ۼ�
		
				QueryRunner qr = new QueryRunner(ds);
				String sql = "select publish.publishID, publish.publishName, sum(buyNum) as sellNum, sum(buyNum * newsPrice) as sumPrice from Users, News, Goods, Publish where Users.userID = Goods.userID and News.newsID = Goods.newsID and  News.publishID = Publish.publishID group by Publish.publishID, Publish.publishName";
				try {
					return qr.query(sql, new BeanListHandler<>(Beans.class));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
	}

	
}
