package service;

import dao.InputPublishDao;

public class InputPublishService {

	
	
	
	
	//����������δ֪����
	public int inputPublish(String publishID, String publishName, String address){
		//�������Ϊ�գ��򷵻�  2
		if(publishID.length() == 0||publishName.length() == 0 || address.length() == 0){
			return 2;
		}else if(hasPublishID(publishID)){
			//���Ѿ����ڸñ���ţ��򷵻�  3
			return 3;
		}else if(hasPublisName(publishName)){
			//�������б���������ͬ�򷵻�4
			return 4;
		}else {
			//��¼��ɹ��򷵻�  1
			return new InputPublishDao().inputPublish(publishID, publishName, address);
		}
	}

	private boolean hasPublisName(String publishName) {
		// TODO Auto-generated method stub
		return new InputPublishDao().hasPublishName(publishName);
	}

	private boolean hasPublishID(String publishID) {
		
		return new InputPublishDao().hasPublishID(publishID);
	}
	
	
}
