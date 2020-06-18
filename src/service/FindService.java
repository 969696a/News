package service;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import mybean.Beans;
import dao.FindDao;

public class FindService {

	//����ֵȥ���ݿ��Ҷ�Ӧ�ģ��û������������磩�����õ��ı��model���õ�����
	public DefaultTableModel getTableModel(String str){
		
		List<Beans> beans = null;
		DefaultTableModel model = new DefaultTableModel();
		if(str.equals("�û�")){
			beans = new FindDao().findAllUsers();
		}else if(str.equals("����")){
			beans = new FindDao().findAllNews();
		}else if(str.equals("����")){
			beans = new FindDao().findAllPublish();
		}
		
		
		if(beans.size() == 0){
			String[] name = new String[]{
					"����1", "����2", "����3", "����4"
			};
			model = new DefaultTableModel(name, 16);
		}else{
			Vector<Vector<String>> data = new Vector<Vector<String>>();
			for (Beans bean : beans) {
				Vector<String> row = new Vector<String>();
				if(str.equals("�û�")){
					row.add(bean.getUserID());
					row.add(bean.getUserName());
					row.add(bean.getSexy());
					row.add(bean.getPhoneNum());
					data.add(row);
				}else if(str.equals("����")){
					row.add(bean.getNewsID());
					row.add(bean.getNewsName());
					row.add(bean.getNewsPrice());
					row.add(bean.getPublishName());
					data.add(row);
				}else if(str.equals("����")){
					row.add(bean.getPublishID());
					row.add(bean.getPublishName());
					row.add(bean.getAddress());
					data.add(row);
				}
			}
			Vector<String> name = new Vector<String>();
			if(str.equals("�û�")){
				name.add("�˺�");
				name.add("�û���");
				name.add("�Ա�");
				name.add("�绰");
			}else if(str.equals("����")){
				name.add("������");
				name.add("������");
				name.add("��������");
				name.add("����");
			}else if(str.equals("����")){
				name.add("�����");
				name.add("������");
				name.add("�����ַ");
			}
			
			
			model.setDataVector(data, name);
			if(beans.size()<=11){
				model.setRowCount(11);
				System.out.println("������С����");
			}
		}
		return model;
	}
	
	//����ֵȥ���ݿ��Ҷ�Ӧ�ģ��û������������磩�����õ������ݷ�װΪ�ַ�����ӡ���ı�����(����һ���ַ�������)
	public StringBuffer getTa_str(String str){
		List<Beans> beans = null;
		StringBuffer taStr = new StringBuffer();
		if(str.equals("�û�")){
			beans = new FindDao().findAllUsers();
		}else if(str.equals("����")){
			beans = new FindDao().findAllNews();
		}else if(str.equals("����")){
			beans = new FindDao().findAllPublish();
		}
		
		if(beans == null){	
			taStr = new StringBuffer("û��ֵ������");
		}else{
			if(str.equals("�û�")){
				for (Beans bean : beans) {
					taStr.append("   �˺ţ�"+bean.getUserID()+"   �û�����"+bean.getUserName()+"   �Ա�"+bean.getSexy()+"   �绰��"+bean.getPhoneNum()+"\n");
				}
			}else if(str.equals("����")){
				for (Beans bean : beans) {
					taStr.append("   �����ţ�"+bean.getNewsID()+"   ��������"+bean.getNewsName()+"   �������ۣ�"+bean.getNewsPrice()+"   ���磺"+bean.getPublishName()+"\n");
				}
			}else if(str.equals("����")){
				for (Beans bean : beans) {
					taStr.append("   ����ţ�"+bean.getPublishID()+"   ��������"+bean.getPublishName()+"   ��ַ��"+bean.getAddress()+"\n");
				}
			}
		}
		
		
		return taStr;
	}
	
}
