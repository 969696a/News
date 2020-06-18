package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import service.UserResetService;
import util.UtilIM;
import component.JButtonMe;
import component.JComboBoxMe;
import component.JFAction;
import component.JFrameMe;
import component.JLabelMe;
import component.JLabel_B;
import component.JTextFiledMe;

public class UserResetJF extends JFrameMe implements JFAction{

	//������ǩ�����ǩb,userID, userName, userPassword, sexy, phoneNum
		private JLabel_B b = new JLabel_B("������Ϣ");
		private JLabelMe b_userID = new JLabelMe("�˺�:");
		private JLabelMe b_userName = new JLabelMe("�û���:");
//		private JLabelMe b_userPassword1 = new JLabelMe("����:");
//		private JLabelMe b_userPassword2 = new JLabelMe("ȷ������:");
		private JLabelMe b_sexy = new JLabelMe("�Ա�:");
		private JLabelMe b_phoneNum = new JLabelMe("�绰����:");
		
		//���������������Ա��ѡ���
		private JTextFiledMe t_userID = new JTextFiledMe();
		private JTextFiledMe t_userName = new JTextFiledMe();
//		private JPasswordFieldMe t_userPassword1 = new JPasswordFieldMe();
//		private JPasswordFieldMe t_userPassword2 = new JPasswordFieldMe();
//		private JComboBoxMe jcom_sexy = new JComboBoxMe(new String[]{
//				"��", "Ů"
//		});
		private JTextFiledMe t_sexy = new JTextFiledMe();
		private JTextFiledMe t_phoneNum = new JTextFiledMe();
		//������ť��ע�ᣬ ���أ�
		private JButtonMe btn_reset = new JButtonMe("�޸�");
//		private JButtonMe btn_return = new JButtonMe("����");
		//�û��˺�
		private String userID;
		
		private int x_,y_;
	
	public UserResetJF(){
//		//�޲ε�Ĭ�ϵ�¼
//		userID = "111";
//		init();
//		setVisible(true);  //�������
	}
	
	public UserResetJF(String userID){
		this.userID = userID;
		
		init();
//		t_userID.setEditable(false);
		getT_userID().setEditable(false);
		getT_userName().setEditable(false);
		getT_sexy().setEditable(false);
		getT_phoneNum().setEditable(false);
		load();
//		setVisible(true);  //�������,���ɾ��
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UserResetJF("111");
	}

	public void setTuichuButton(UserJF userJF){
		//����˳���ť
		con.add(new UtilIM().getTuichuButton(userJF));
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
			createComponent();
			addComonent();
			setLocate();
			addListener();
			con.setOpaque(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void load(){
		//�����˺ţ��û����� �Ա� �绰
		t_userID.setText(new UserResetService().getUserInfoByUserID(userID).getUserID());
		t_userName.setText(new UserResetService().getUserInfoByUserID(userID).getUserName());
		t_sexy.setText(new UserResetService().getUserInfoByUserID(userID).getSexy());
		t_phoneNum.setText(new UserResetService().getUserInfoByUserID(userID).getPhoneNum());
	}
	
	
	
	@Override
	public void createComponent() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addComonent() {
		// TODO Auto-generated method stub
		
		//����ǩ�ӽ����
				con.add(getB());
				con.add(getB_userID());
				con.add(b_userName);
//				con.add(b_userPassword1);
//				con.add(b_userPassword2);
				con.add(b_sexy);
				con.add(b_phoneNum);
				
				//������������ѡ���������
				con.add(getT_userID());
				con.add(getT_userName());
//				con.add(t_userPassword1);
//				con.add(t_userPassword2);
				con.add(getT_sexy());
				con.add(getT_phoneNum());
				
				//����ť���뵽�����
				con.add(getBtn_reset());
//				con.add(btn_return);
	}

	@Override
	public void setLocate() {
		// TODO Auto-generated method stub
//		x_ = 0; y_ = 50; //λ�õĿ���
		
		//���ñ�ǩ��λ��
		getB().setLocation(x_+150, y_+10);
		getB_userID().setLocation(x_+110, y_+70);
		b_userName.setLocation(x_+110, y_+110);
//		b_userPassword1.setLocation(x+110, y+150);
//		b_userPassword2.setLocation(x+110, y+190);
		b_sexy.setLocation(x_+110, y_+150);
		b_phoneNum.setLocation(x_+110, y_+190);
		
		//��������������ѡ����λ��
		getT_userID().setLocation(x_+210, y_+70);
		getT_userName().setLocation(x_+210, y_+110);
//		t_userPassword1.setLocation(x+210, y+150);
//		t_userPassword2.setLocation(x+210, y+190);
		getT_sexy().setLocation(x_+210, y_+150);
		getT_phoneNum().setLocation(x_+210, y_+190);
		
		
		//���ð�ť��λ��
		getBtn_reset().setLocation(x_+170, y_+250);
//		btn_return.setLocation(x+250, y+330);
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		
		getBtn_reset().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(b.getText().equals("������Ϣ")){
					JFrameMe jfout = new UtilIM().out_resetJF(userID);
					jfout.addWindowListener(new WindowListener() {
						
						@Override
						public void windowOpened(WindowEvent e) {
							// TODO Auto-generated method stub
							btn_reset.setEnabled(false);
						}
						
						@Override
						public void windowIconified(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void windowDeiconified(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void windowDeactivated(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void windowClosing(WindowEvent e) {
							// TODO Auto-generated method stub
							load();
							btn_reset.setEnabled(true);
						}
						
						@Override
						public void windowClosed(WindowEvent e) {
							// TODO Auto-generated method stub
							load();
							btn_reset.setEnabled(true);
							
						}
						
						@Override
						public void windowActivated(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
					});
				}
			}
		});
		
		
	}

	public int getX_() {
		return x_;
	}

	public void setX_(int x_) {
		this.x_ = x_;
	}

	public int getY_() {
		return y_;
	}

	public void setY_(int y_) {
		this.y_ = y_;
	}

	public JLabel_B getB() {
		return b;
	}

	public void setB(JLabel_B b) {
		this.b = b;
	}

	public JTextFiledMe getT_userID() {
		return t_userID;
	}

	public void setT_userID(JTextFiledMe t_userID) {
		this.t_userID = t_userID;
	}

	public JLabelMe getB_userID() {
		return b_userID;
	}

	public void setB_userID(JLabelMe b_userID) {
		this.b_userID = b_userID;
	}

	public JTextFiledMe getT_userName() {
		return t_userName;
	}

	public void setT_userName(JTextFiledMe t_userName) {
		this.t_userName = t_userName;
	}

	public JTextFiledMe getT_sexy() {
		return t_sexy;
	}

	public void setT_sexy(JTextFiledMe t_sexy) {
		this.t_sexy = t_sexy;
	}

	public JTextFiledMe getT_phoneNum() {
		return t_phoneNum;
	}

	public void setT_phoneNum(JTextFiledMe t_phoneNum) {
		this.t_phoneNum = t_phoneNum;
	}

	public JButtonMe getBtn_reset() {
		return btn_reset;
	}

	public void setBtn_reset(JButtonMe btn_reset) {
		this.btn_reset = btn_reset;
	}

}
