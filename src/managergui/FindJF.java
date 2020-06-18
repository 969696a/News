package managergui;

import gui.ManagerJFA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import service.FindService;

public class FindJF extends SuperBJF {

	public FindJF(){
		reset();
//		setModelForTable();
		setTitle("��ѯ����");
		setVisible(true);
	}
	
	private void reset() {
		// TODO Auto-generated method stub
		getB().setText("��ѯ����");
		
		getJcom().addItem("�û�");
		getJcom().addItem("����");
		getJcom().addItem("����");
	}
	
	//��ʼ�����
//	public void setModelForTable(){
//		String[] name = new String[]{
//				"����1","����2","����3","����4"
//		};
//		
//		DefaultTableModel model = new DefaultTableModel(name, 11);
//		getTable().setModel(model);
//	}
	
	@Override
	public void addListener() {
		// Ϊ���ذ�ť����¼�
		super.addListener();
		getBtn_re().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new ManagerJFA();
			}
		});
		
		//ΪԤ��(find)��ť����¼�
		getBtn_find().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//�������ѡ����ֵ
				String jcom_str = getJcom().getSelectedItem().toString();
				//����ֵȥ���ݿ��Ҷ�Ӧ�ģ��û������������磩�����õ��ı��model���õ�����
				getTable().setModel(new FindService().getTableModel(jcom_str));
				
			}
		});
		//Ϊ��ӡ(skip)��ť����¼�
		getBtn_skip().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//�������ѡ����ֵ
				String jcom_str = getJcom().getSelectedItem().toString();
				//����ֵȥ���ݿ��Ҷ�Ӧ�ģ��û������������磩�����õ������ݷ�װΪ�ַ�����ӡ���ı�����(����һ���ַ�������)
				StringBuffer taStr = new FindService().getTa_str(jcom_str);
				
				getTa().setText(taStr.toString());
			}
		});
		
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FindJF();
	}

}
