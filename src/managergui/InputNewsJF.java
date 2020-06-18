package managergui;

import gui.ManagerJFA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import mybean.Beans;
import service.InputNewsService;
import component.JFAction;
import component.JLabelMe;
import component.JTextFiledMe;

public class InputNewsJF extends SuperAJF {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabelMe b_newsPrice;
	JTextFiledMe t_newsPrice;
	
	public InputNewsJF(){
		
		resetB();
//		load();
//		addListener();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InputNewsJF();
	}
	
	
	//�޸ı�ǩ,����t_adressΪ����
	public void resetB(){
		//�޸ı�ǩ�� ����ǩ�� ID��ǩ�� name��ǩ�� last��ǩ
		getB().setText("¼�뱨��");
		getB_ID().setText("������:");
		getB_name().setText("������:");
		getB_last().setText("����:");
		
		//����һ�������۸��ǩ,�����
		b_newsPrice = new JLabelMe("��������");
		t_newsPrice = new JTextFiledMe();
		con.add(b_newsPrice);
		con.add(t_newsPrice);
		/**
		 * �����¼ӵ������λ��
		 */
		setLocateA();
		
		//���������t_address
		getJcom_publis().setSize(getT_address().getSize());
		getT_address().setSize(0, 0);
	}
	
	@Override
	//���ر�������ѡ���
	public void load(){
		
		List<Beans> beans = new InputNewsService().getPublishInfo();
		if(beans != null){
			for (Beans bean : beans) {System.out.println(bean.getPublishName());
				getJcom_publis().addItem(bean.getPublishName());
			}
		}
	}
	
	
	public void setLocateA() {
		getBtn_input().setLocation(getXs()+130, getYs()+280);
		getBtn_re().setLocation(getXs()+250, getYs()+280);
		
		b_newsPrice.setLocation(getXs()+100, getYs()+230);
		t_newsPrice.setLocation(getXs()+200, getYs()+230);
		
	};
	
	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		super.addListener();
		
		//���ذ�ť�¼�
		getBtn_re().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new ManagerJFA();
			}
		});
		
		//¼�밴ť�¼�
		getBtn_input().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//��ȡ����������ֵ
				//�������Ϊ�գ��򷵻�  2
				//���Ѿ����ڸñ����ţ��򷵻�  3
				//�������б���������ͬ�򷵻�4
				//���������벻���򷵻�5
				//��¼��ɹ��򷵻�  1
				//����������δ֪����
				
				String newsID = getT_ID().getText();
				String newsName = getT_name().getText();
				String publishName = getJcom_publis().getSelectedItem().toString();
				String newsPrice = t_newsPrice.getText();
				int i = 8;
				i = new InputNewsService().inputNews(newsID, newsName, newsPrice, publishName);
				switch(i) {
				case 5:JOptionPane.showMessageDialog(null, "���������������", "��ʾ��", JOptionPane.ERROR_MESSAGE);
				break;
				case 2:JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "��ʾ��", JOptionPane.ERROR_MESSAGE);
					break;
				case 3:JOptionPane.showMessageDialog(null, "�Ѿ����ڸñ�����", "��ʾ��", JOptionPane.ERROR_MESSAGE);
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
