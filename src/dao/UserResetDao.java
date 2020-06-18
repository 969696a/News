package dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import mybean.Beans;

public class UserResetDao  extends Dao{

		//ͨ���˺ŵõ��û�����Ϣ
		@SuppressWarnings("deprecation")
		public Beans getUserInfoByUserID(String userID) {
			// TODO Auto-generated method stub
			QueryRunner qr = new QueryRunner(ds);
			String sql = "select *from Users where userID = ?";
			try {
				return qr.query(sql, userID, new BeanHandler<>(Beans.class));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("�����û���ĵ����˵ĸ�����Ϣʱ�������");
			}
			return null;
		}
		
		//�޸��û����û��� ���Ա� �绰
		public int resetUserInfo(String userID, String userName, String sexy, String phoneNum) {
			// TODO Auto-generated method stub
			QueryRunner qr = new QueryRunner(ds);
			String sql = "update Users set userName = ?, sexy = ?, phoneNum = ? where userID = ?";
			try {
				return qr.update(sql, userName, sexy, phoneNum, userID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("���޸��û�����Ϣʱ�����쳣");
			}
			return 0;
		}
}
