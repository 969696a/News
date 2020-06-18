package service;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import mybean.Beans;
import dao.SumDao;

public class SumService {

	//����ֵȥ���ݿ��Ҷ�Ӧ�ģ��û������������磩�����õ��ı��model���õ�����
	public DefaultTableModel getTableModel(String str){
		
		
		List<Beans> beans = null;
		DefaultTableModel model = new DefaultTableModel();
		if(str.equals("�û�")){
			beans = new SumDao().findUsersSum();
		}else if(str.equals("����")){
			beans = new SumDao().findNewsSum();
		}else if(str.equals("����")){
			beans = new SumDao().findPublishSum();
		}
		
		
		if(beans.size() == 0){
			String[] name = new String[]{
					"����1", "����2", "����3", "����4"
			};
			model = new DefaultTableModel(name, 11);
		}else{
			Vector<Vector<String>> data = new Vector<Vector<String>>();
			for (Beans bean : beans) {
				Vector<String> row = new Vector<String>();
				if(str.equals("�û�")){
					row.add(bean.getUserID());
					row.add(bean.getUserName());
					row.add(bean.getBuyNum());
					row.add(bean.getSumPrice());
					data.add(row);
				}else if(str.equals("����")){
					row.add(bean.getNewsID());
					row.add(bean.getNewsName());
					row.add(bean.getSellNum());
					row.add(bean.getSumPrice());
					data.add(row);
				}else if(str.equals("����")){
					row.add(bean.getPublishID());
					row.add(bean.getPublishName());
					row.add(bean.getSellNum());
					row.add(bean.getSumPrice());
					data.add(row);
				}
			}
			Vector<String> name = new Vector<String>();
			if(str.equals("�û�")){
				name.add("�˺�");
				name.add("�û���");
				name.add("���ķ���");
				name.add("�ܼ�");
			}else if(str.equals("����")){
				name.add("������");
				name.add("������");
				name.add("��������");
				name.add("���ۼ�");
			}else if(str.equals("����")){
				name.add("�����");
				name.add("������");
				name.add("���۷���");
				name.add("�����ܼ�");
			}
			model.setDataVector(data, name);
			if(beans.size() <= 11){
				model.setRowCount(11);
			}
		}
		
		
		return model;
		
	}

	public StringBuffer getTaStr(String jcom_str) {
		// TODO Auto-generated method stub
		List<Beans> beans = null;
		StringBuffer taStr = new StringBuffer();
		if(jcom_str.equals("�û�")){
			beans = new SumDao().findUsersSum();
		}else if(jcom_str.equals("����")){
			beans = new SumDao().findNewsSum();
		}else if(jcom_str.equals("����")){
			beans = new SumDao().findPublishSum();
		}
		
		if(beans == null){	
			taStr = new StringBuffer("û��ֵ������");
		}else{
			if(jcom_str.equals("�û�")){
				for (Beans bean : beans) {
					taStr.append("   �˺ţ�"+bean.getUserID()+"   �û�����"+bean.getUserName()+"   ���ķ�����"+bean.getBuyNum()+"   �ܼۣ�"+bean.getSumPrice()+"\n");
				}
			}else if(jcom_str.equals("����")){
				for (Beans bean : beans) {
					taStr.append("   �����ţ�"+bean.getNewsID()+"   ��������"+bean.getNewsName()+"   ���۷�����"+bean.getSellNum()+"   ���ۼۣ�"+bean.getSumPrice()+"\n");
				}
			}else if(jcom_str.equals("����")){
				for (Beans bean : beans) {
					taStr.append("   ����ţ�"+bean.getPublishID()+"   ��������"+bean.getPublishName()+"   ��������"+bean.getSellNum()+"   ���ۼۣ�"+bean.getSumPrice()+"\n");
				}
			}
		}
		
		
		return taStr;
	}
	
	
	//����ֵȥ���ݿ��Ҷ�Ӧ�ģ��û������������磩�����õ������ݷ�װΪ�ַ�����ӡ���ı�����
	
	
	
	
	
}
