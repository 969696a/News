package service;

import dao.UserResetDao;
import mybean.Beans;

public class UserResetService {

		//ͨ���˺ŵõ��û�����Ϣ
		public Beans getUserInfoByUserID(String userID) {
			// TODO Auto-generated method stub
			
			return new UserResetDao().getUserInfoByUserID(userID);
		}
		
		//�޸��û����û��� ���Ա� �绰
		public int resetUserInfo(String userID, String userName, String sexy, String phoneNum) {
			// TODO Auto-generated method stub
			return new UserResetDao().resetUserInfo(userID, userName, sexy, phoneNum);
		}
			
			
			
}
