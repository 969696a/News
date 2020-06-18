package dao;

import java.sql.SQLException;
import java.util.List;

import mybean.Beans;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class BooksNewsDao extends Dao{

	//���ĳɹ�  1
		//�����ڸñ��������ж��Ƿ��Ѿ����Ĺ��������Ĺ���������������������Ϣ
	
	

	@SuppressWarnings("deprecation")
	public boolean has_goods_in_GoodsTable(String userID, String newsID) {
		QueryRunner qr = new QueryRunner(ds);
		String sql = "select *from Goods where userID = ? and newsID = ?";
		String[] params = new String[]{
			userID, newsID
		};
		try {
			if(qr.query(sql, params, new BeanHandler<>(Beans.class)) != null){
				System.out.println("���ڸö�����ֱ�Ӹ�������");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public int updateGoods(String userID, String newsID, int buyNum) {
		QueryRunner qr = new QueryRunner(ds);
		String sql = "update Goods set buyNum = buyNum + ? where userID = ? and newsID = ?";
		try {
			return qr.update(sql, buyNum, userID, newsID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int insertGoods(String userID, String newsID, int buyNum) {
		QueryRunner qr = new QueryRunner(ds);
		String sql = "insert into Goods values(?, ?, ?)";
		try {
			return qr.update(sql, userID, newsID, buyNum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public List<Beans> getNewsInfo() {
		// �õ���������Ϣ
		QueryRunner qr = new QueryRunner(ds);
		String sql = "select *from News, Publish where News.PublishID = Publish.publishID";
		
		try {
			return qr.query(sql, new BeanListHandler<>(Beans.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean hasNewsID(String newsID) {
		//�Ƿ���ڸñ�����
		QueryRunner qr = new QueryRunner(ds);
		String sql = "select *from News where newsID = ?";
		try {
			if(qr.query(sql, newsID, new BeanHandler<>(Beans.class)) != null){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
