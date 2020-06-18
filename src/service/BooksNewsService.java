package service;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import mybean.Beans;
import dao.BooksNewsDao;

public class BooksNewsService {

	//���ĳɹ�  1
	//�����ڸñ��������ж��Ƿ��Ѿ����Ĺ��������Ĺ���������������������Ϣ
	public int booksnews(String userID, String newsID, int buyNum){
		
		int i = 5;
		
		if(!hasNewsID(newsID)){
			return 5;
		}
		
		if(new BooksNewsDao().has_goods_in_GoodsTable(userID, newsID)){
			//����
			i = new BooksNewsDao().updateGoods(userID, newsID, buyNum);
		}else{
			//����
			i = new BooksNewsDao().insertGoods(userID, newsID, buyNum);
		}
		
		return i;
	}

	private boolean hasNewsID(String newsID) {
		// �Ƿ���ڸñ�����
		
		return new BooksNewsDao().hasNewsID(newsID);
	}

	public TableModel getTableModel() {
		// �õ���������Ϣ
		List<Beans> beans = null;
		beans = new BooksNewsDao().getNewsInfo();
		DefaultTableModel model = new DefaultTableModel();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> name = new Vector<String>();
		name.add("������");
		name.add("������");
		name.add("��������");
		name.add("������");
		if(beans.size()>0){
			for (Beans bean : beans) {
				Vector<String> row = new Vector<String>();
				row.add(bean.getNewsID());
				row.add(bean.getNewsName());
				row.add(bean.getNewsPrice());
				row.add(bean.getPublishName());
				data.add(row);
			}
			model.setDataVector(data, name);
			if(beans.size() <= 17){
				model.setRowCount(17);
			}
		}else{
			model.setDataVector(data, name);
			model.setRowCount(17);
		}
		return model;
	}
	
	
}
