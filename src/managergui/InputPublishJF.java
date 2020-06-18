package managergui;

import gui.ManagerJFA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import service.InputPublishService;

public class InputPublishJF extends SuperAJF {

	public InputPublishJF(){
		reset();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InputPublishJF();
	}
	
	
	public void reset(){
		//�޸ı�ǩ�� ����ǩ�� ID��ǩ�� name��ǩ�� last��ǩ
		getB().setText("¼�뱨��");
		getB_ID().setText("�����:");
		getB_name().setText("������:");
		getB_last().setText("�����ַ:");
		
		//���������jcom_publish
		getJcom_publis().setSize(0, 0);
	}
	
	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		super.addListener();
		getBtn_re().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new ManagerJFA();
			}
		});
		
		
		getBtn_input().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//�������Ϊ�գ��򷵻�  2
				//���Ѿ����ڸñ���ţ��򷵻�  3
				//�������б���������ͬ�򷵻�4
				//��¼��ɹ��򷵻�  1
				//����������δ֪����
				
				String publishID = getT_ID().getText();
				String publishName = getT_name().getText();
				String address = getT_address().getText();
				
				int i = new InputPublishService().inputPublish(publishID, publishName, address);
				switch(i) {
				case 2:JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "��ʾ��", JOptionPane.ERROR_MESSAGE);
					break;
				case 3:JOptionPane.showMessageDialog(null, "�Ѿ����ڸñ����", "��ʾ��", JOptionPane.ERROR_MESSAGE);
					break;
				case 4:JOptionPane.showMessageDialog(null, "�������Ѵ���", "��ʾ��", JOptionPane.ERROR_MESSAGE);
					break;
				case 1:JOptionPane.showMessageDialog(null, "¼��ɹ�", "��ʾ��", JOptionPane.PLAIN_MESSAGE);
					break;
				default :JOptionPane.showMessageDialog(null, "δ֪����", "��ʾ��", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
	}

}
