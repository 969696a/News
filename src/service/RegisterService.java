package service;

import java.sql.SQLException;

import dao.RegisterDao;

public class RegisterService {

	//  1ע��ɹ�
	public int register(String userID, String userName, String userPassword1,
			String userPassword2, String sexy, String phoneNum) {
		
		if(hasUserID(userID)){
			//3�Ѿ����ڸ��˺�
			return 3;
		}else if(!userPassword1.equals(userPassword2)){
			System.out.println(userPassword1);
			System.out.println(userPassword2);
			//2�����������벻һ��
			return 2;
		}else {
			
			return new RegisterDao().register(userID, userName, userPassword1, userPassword2, sexy, phoneNum);
		}
		
		
		
	}

	private boolean hasUserID(String userID) {
		// TODO Auto-generated method stub
		try {
			return new RegisterDao().hasUserID(userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ж����ݿ���û�и��˺ŵ�ʱ������쳣");
		}
		return false;
	}

	
	
	
	
	
}
