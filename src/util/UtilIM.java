package util;

import gui.LoginJF;
import gui.UserJF;
import gui.UserResetJF;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import service.BooksNewsService;
import service.UserResetService;
import mybean.Beans;
import component.JButtonMe;
import component.JComboBoxMe;
import component.JDialogMe;
import component.JFrameMe;
import component.JLabelMe;
import component.JTextFiledMe;


public class UtilIM implements GetConponet {

	@Override
	public JButtonMe getTuichuButton(UserJF userJF) {
		// TODO Auto-generated method stub
		JButtonMe btn = new JButtonMe();
		btn.setLocation(430, 2);
		btn.setSize(50, 30);
		btn.setText("��");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				userJF.dispose();
				new LoginJF("�û�");
				
			}
		});
		return btn;
	}

	/**
	 * �������ı����Ľ��棨�����ź�Ҫ���ĵ�������
	 * @return 
	 */
	@Override
	public JFrameMe out_jf(String userID) {
		
		int x = 0, y = 0;
		
		// TODO Auto-generated method stub
		JFrameMe jf = new JFrameMe();

		jf.setSize(300, 200);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
//		jf.setFocusable(true);
		jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		//������ǩ
		JLabelMe b_newsID = new JLabelMe("������");
		JLabelMe b_buyNum = new JLabelMe("��������");
		b_newsID.setLocation(x+30, y+10);
		b_buyNum.setLocation(x+30, y+50);
		jf.con.add(b_newsID);
		jf.con.add(b_buyNum);
		//���������
		JTextFiledMe t_newsID = new JTextFiledMe();
		JTextFiledMe t_buyNum = new JTextFiledMe();
		t_newsID.setLocation(x+110, y+10);
		t_buyNum.setLocation(x+110, y+50);
		jf.con.add(t_newsID);
		jf.con.add(t_buyNum);
		//������ť
		JButtonMe btn_return = new JButtonMe("����");
		JButtonMe btn_book = new JButtonMe("����");
		btn_book.setLocation(x+80, y+100);
		btn_return.setLocation(x+130, y+100);
		jf.con.add(btn_book);
//		jf.con.add(btn_return);
		
		
		//��Ӷ��İ�ť���¼�
		btn_book.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = 5;
				// ��ñ����ţ���ö�������¼�����ݿ�
				String newsID = t_newsID.getText();
				String buyNums =  t_buyNum.getText();
				int buyNum = 0;
				
				
				//��������û��д����������ʾ   
				if(newsID.length() == 0|| buyNums.length() == 0){
					JOptionPane.showMessageDialog(null, "������������Ϣ", "��ʾ��", JOptionPane.ERROR_MESSAGE);
					
				}else{
					//���������Ͷ��������ַ�����
					try{
						buyNum = Integer.parseInt(t_buyNum.getText());
						if(buyNum <= 0 ){
							JOptionPane.showMessageDialog(null, "���ĵ�����Ҫ����0", "��ʾ��", JOptionPane.ERROR_MESSAGE);
						return;
						}
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, "����������������", "��ʾ��", JOptionPane.ERROR_MESSAGE);
					return;
					}
					//ִ�����ݿ�Ĳ���Service
					
					i = new BooksNewsService().booksnews(userID, newsID, buyNum);
					//�������ڸñ����������  0
					if(i == 5){
						JOptionPane.showMessageDialog(null, "����ʧ�ܣ������ڸñ���", "��ʾ��", JOptionPane.ERROR_MESSAGE);
					}else if(i == 1){
						//���ĳɹ�  1
						//�����ڸñ��������ж��Ƿ��Ѿ����Ĺ��������Ĺ���������������������Ϣ
						JOptionPane.showMessageDialog(null, "���ĳɹ�", "��ʾ��", JOptionPane.PLAIN_MESSAGE);
						jf.dispose();
					}else if(i == 0){
						JOptionPane.showMessageDialog(null, "δ֪����", "��ʾ��", JOptionPane.ERROR_MESSAGE);
					}
					
					
					
				}
				
				
				
			}
		});
		
		
		return jf;
	}

	
	/**
	 * �����޸ĸ�����Ϣ�Ŀ�
	 * @return 
	 */
	@Override
	public JFrameMe out_resetJF(String userID) {
		
		
		// TODO Auto-generated method stub
		UserResetJF userResetJF = new UserResetJF(userID);
		
		//���������ɱ༭
//		userResetJF.getT_userID().setEditable(true);
		userResetJF.getT_userName().setEditable(true);
//		userResetJF.getT_sexy().setEditable(true);
		userResetJF.getT_phoneNum().setEditable(true);
		
		
		userResetJF.setX_(-80);
		userResetJF.setY_(-30);
		userResetJF.setLocate();
		userResetJF.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//����ǩ��һ�£���Ϊ�޸���Ϣ
		userResetJF.getB().setText("�޸���Ϣ");
		
		userResetJF.getB().setLocation((int)userResetJF.getB().getLocation().getX(),(int)userResetJF.getB().getLocation().getY()+50);
		//���˺ű�ǩ���˺��������Ա������Ϊ0��С
		userResetJF.getB_userID().setSize(0, 0);
		userResetJF.getT_userID().setSize(0, 0);
		userResetJF.getT_sexy().setSize(0, 0);
		//����������Ĵ�С
		userResetJF.setSize(330, 330);
		//��λ��
		userResetJF.setLocationRelativeTo(null);
		//���������������Ϊ�ɱ༭
		userResetJF.getT_userName().setEnabled(true);
		userResetJF.getT_sexy().setEnabled(true);
		userResetJF.getT_phoneNum().setEnabled(true);
		
		//���ñ���
		userResetJF.setBack(new ImageIcon("image//2.jpg"));
		
		//��������ѡ�����ӵ���壬�õ��Ա��λ�úʹ�С������λ�úʹ�С,������������
		JComboBoxMe jcom_sexy = new JComboBoxMe(new String[]{
				"��", "Ů"
		});
		userResetJF.con.add(jcom_sexy);
		jcom_sexy.setLocation(userResetJF.getT_sexy().getLocation());
		jcom_sexy.setFont(new Font("����", Font.BOLD, 14));
		
		//Ϊ�޸İ�ť��Ӽ���
		userResetJF.getBtn_reset().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//�ж��û����͵绰�Ƿ�Ϊ��
				String userName = userResetJF.getT_userName().getText();
				String sexy = jcom_sexy.getSelectedItem().toString();
				String phoneNum = userResetJF.getT_phoneNum().getText();
				if(userResetJF.getT_userName().getText().length() == 0 || userResetJF.getT_phoneNum().getText().length()==0){
					JOptionPane.showMessageDialog(null, "������������Ϣ", "��ʾ��", JOptionPane.ERROR_MESSAGE);
				}else {
					int i = new UserResetService().resetUserInfo(userID, userName, sexy, phoneNum);
					
					switch(i){
					case 1:JOptionPane.showMessageDialog(null, "�޸ĳɹ�", "��ʾ��", JOptionPane.PLAIN_MESSAGE);
					userResetJF.dispose();
					break;
					default :JOptionPane.showMessageDialog(null, "δ֪����", "��ʾ��", JOptionPane.ERROR_MESSAGE);
					
					}
				}
				
				
				
			}
		});
		
		
		/**
		 * ��������
		 */
		
		Beans bean = new UserResetService().getUserInfoByUserID(userID);
		userResetJF.getT_userName().setText(bean.getUserName());
		jcom_sexy.setSelectedItem((bean.getSexy()));
		userResetJF.getT_phoneNum().setText(bean.getPhoneNum());
		
		
		//Ϊ������ӹرմ���ļ���
		
		//���ÿɼ�,�������
		userResetJF.setVisible(true);
		
		
		
		
		
		return userResetJF;
		
	}
	
	

	

}
