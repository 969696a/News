package managergui;

import gui.ManagerJFA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import service.SumService;

public class SumJF extends SuperBJF {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public SumJF(){
		setTitle("ͳ�ƽ���");
		reset();
		setVisible(true);//�������
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SumJF();
	}

	private void reset() {
		// TODO Auto-generated method stub
		getB().setText("ͳ�ƹ���");
		
		getJcom().addItem("�û�");
		getJcom().addItem("����");
		getJcom().addItem("����");
	}
	
	
	@Override
	public void addListener() {
		//Ϊ���ذ�ť����¼�
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
					getTable().setModel(new SumService().getTableModel(jcom_str));
				}
			});
			
			//Ϊ��ӡ(skip)��ť����¼�
			getBtn_skip().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//�������ѡ����ֵ
					String jcom_str = getJcom().getSelectedItem().toString();
					//����ֵȥ���ݿ��Ҷ�Ӧ�ģ��û������������磩�����õ������ݷ�װΪ�ַ�����ӡ���ı�����(����һ���ַ�������)
					StringBuffer taStr = new SumService().getTaStr(jcom_str);
					getTa().setText(taStr.toString());
				}
			});
				
	}
}
