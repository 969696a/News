package service;

import java.sql.SQLException;
import java.util.List;

import mybean.Beans;
import dao.InputNewsDao;

public class InputNewsService {

	
	
	
	
	//����������δ֪����
	public int inputNews(String newsID, String newsName, String newsPrice, String publishName){
		//�������Ϊ�գ��򷵻�  2
		if(newsID.length() == 0 || newsName.length() == 0 || publishName.length() == 0 || newsPrice.length() == 0){
			return 2;
		}else if(hasNewsID(newsID)){
			//���Ѿ����ڸñ����ţ��򷵻�  3
			return 3;
		}else if(hasNewsName(newsName)){
			//�������б���������ͬ�򷵻�4
			return 4;
		}else {
			double newsPrices = 0;
			try{
				newsPrices = Double.parseDouble(newsPrice);
			}catch(Exception e){
				return 5;
			}
			//��¼��ɹ��򷵻�  1
			return new InputNewsDao().inputNews(newsID, newsName, newsPrices, publishName);
		}
	}

	private boolean hasNewsName(String newsName) {
		// TODO Auto-generated method stub
		return new InputNewsDao().hasNewsName(newsName);
	}

	private boolean hasNewsID(String newsID) {
		
		
		return new InputNewsDao().hasNewsID(newsID);
	}

	public List<Beans> getPublishInfo() {
		// TODO Auto-generated method stub
		List<Beans> beans = null;
		try {
			beans = new InputNewsDao().getPublishInfo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return beans;
	}
	
	
	
	
}
