package service;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import mybean.Beans;
import dao.MyGoodsDao;

public class MyGoodsService {

	public DefaultTableModel setTableModel(String userID) {
		
		//ȥ���ݿ����Goods�����news��,���ҳ������������������� �������ۣ������ܼ� 
		List<Beans> beans = new MyGoodsDao().getMyGoodsList(userID);
		DefaultTableModel model = new DefaultTableModel();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> name = new Vector<String>();
		name.add("������");
		name.add("���ķ���");
		name.add("��������");
		name.add("�ܼ�");
		
		if(beans.size()==0){
			model.setDataVector(data, name);
			model.setRowCount(17);
			
		}else{
			
			for (Beans bean : beans) {
				Vector<String> row = new Vector<String>();
				row.add(bean.getNewsName());
				row.add(bean.getBuyNum());
				row.add(bean.getNewsPrice());
				row.add(bean.getSumPrice());
				data.add(row);
				model.setDataVector(data, name);
				System.out.println("���ҵ��������ҽ�������ģ��"+bean.getNewsName());
			}
			
			if(beans.size() <= 17){
				model.setRowCount(17);
			}
		}
		
		return model;
		
	}

}
