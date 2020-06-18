package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;

import text.JFramText;
import component.JButtonMe;
import component.JFAction;
import component.JFrameMe;
import component.JLabelMe;
import component.JLabel_B;

public class LoginSelectJF extends JFrameMe implements JFAction, ActionListener{

	private JLabel_B b = new JLabel_B("�������Ĺ���ϵͳ"); //������
	private JButtonMe btn_manager = new JButtonMe("����Ա��¼");
	private JButtonMe btn_user = new JButtonMe("�û���¼");
	
	public LoginSelectJF() throws SQLException{
		setTitle("�������Ĺ���ϵͳ");
		init();
		setIconImage(new ImageIcon("image//101.png").getImage());
		setBack(new ImageIcon("image\\����.jpg"));
		setSize(420, 400);
//		setSize(450, 420);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrameMe jf;
		try {
//			new JFramText();
			
//			jf = new LoginSelectJF();
//			jf.setBack(new ImageIcon("image\\2.jpg"));
//			jf.setVisible(true);
			try {
				org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			new LoginSelectJF();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void createComponent() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addComonent() {
		// TODO Auto-generated method stub
		con.add(b);
		con.add(btn_manager);
		con.add(btn_user);
		
	}

	@Override
	public void setLocate() {
		// TODO Auto-generated method stub
		b.setLocation(52, 70);
		btn_manager.setBounds(78, 140, 250, 60);
		btn_user.setBounds(78, 210, 250, 60);
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		btn_manager.addActionListener(this);
		btn_user.addActionListener(this);
	}

	/**
	 * ��ť���¼�
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btn_manager){
			dispose();
			new LoginJF("����Ա");
		}else{
			dispose();
			new LoginJF("�û�");
		}
		
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
			createComponent();
			addComonent();
			setLocate();
			addListener();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
