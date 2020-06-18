package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import service.RegisterService;
import component.JButtonMe;
import component.JComboBoxMe;
import component.JFAction;
import component.JFrameMe;
import component.JLabelMe;
import component.JLabel_B;
import component.JTextFiledMe;

public class RegisterJF extends JFrameMe implements JFAction{

	
	private static final long serialVersionUID = 1L;
	
	//������ǩ�����ǩb,userID, userName, userPassword, sexy, phoneNum
	private JLabel_B b = new JLabel_B("ע�����");
	private JLabelMe b_userID = new JLabelMe("�˺�:");
	private JLabelMe b_userName = new JLabelMe("�û���:");
	private JLabelMe b_userPassword1 = new JLabelMe("����:");
	private JLabelMe b_userPassword2 = new JLabelMe("ȷ������:");
	private JLabelMe b_sexy = new JLabelMe("�Ա�:");
	private JLabelMe b_phoneNum = new JLabelMe("�绰����:");
	
	//���������������Ա��ѡ���
	private JTextFiledMe t_userID = new JTextFiledMe();
	private JTextFiledMe t_userName = new JTextFiledMe();
	private JPasswordFieldMe t_userPassword1 = new JPasswordFieldMe();
	private JPasswordFieldMe t_userPassword2 = new JPasswordFieldMe();
	private JComboBoxMe jcom_sexy = new JComboBoxMe(new String[]{
			"��", "Ů"
	});
	private JTextFiledMe t_phoneNum = new JTextFiledMe();
	//������ť��ע�ᣬ ���أ�
	private JButtonMe btn_register = new JButtonMe("ע��");
	private JButtonMe btn_return = new JButtonMe("����");
	
	
	
	//�����м�����������壬��������λ�úʹ�С
//	private JPaneBlue pan_center_top = new JPaneBlue();
//	private JPaneBlue pan_center_center = new JPaneBlue();
//	private JPaneBlue pan_center_buttom = new JPaneBlue();
	
	public RegisterJF(){
		
		init();
		setIconImage(new ImageIcon("image//102.png").getImage());
		setVisible(true);//�������
	}
	
	public static void main(String[] args) {
		
//		 new JFramText();  //���괰��
		 new RegisterJF();
	}

	@Override
	public void init() {
		
		try {
			setTitle("ע�����");
			createComponent();
			addComonent();
			setLocate();
			addListener();
			setBack(new ImageIcon("image//�û�����.jpg"));
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
			//����������뵽���������
//			con.add(pan_center, BorderLayout.CENTER);
//			con.add(pan_west, BorderLayout.WEST);
//			con.add(pan_east, BorderLayout.EAST);
//			con.add(pan_north, BorderLayout.NORTH);
//			con.add(pan_south, BorderLayout.SOUTH);
			
			//��������ɫ���ӵ��м����
//			pan_center.add(pan_center_top);
//			pan_center.add(pan_center_center);
//			pan_center.add(pan_center_buttom);
		
		//����ǩ�ӽ����
		con.add(b);
		con.add(b_userID);
		con.add(b_userName);
		con.add(b_userPassword1);
		con.add(b_userPassword2);
		con.add(b_sexy);
		con.add(b_phoneNum);
		
		//������������ѡ���������
		con.add(t_userID);
		con.add(t_userName);
		con.add(t_userPassword1);
		con.add(t_userPassword2);
		con.add(jcom_sexy);
		con.add(t_phoneNum);
		
		//����ť���뵽�����
		con.add(btn_register);
		con.add(btn_return);
		
		
	}

	@Override
	public void setLocate() {
		int x = 0, y = 0; //λ�õĿ���
		
		//���ñ�ǩ��λ��
		b.setLocation(x+150, y+10);
		b_userID.setLocation(x+110, y+70);
		b_userName.setLocation(x+110, y+110);
		b_userPassword1.setLocation(x+110, y+150);
		b_userPassword2.setLocation(x+110, y+190);
		b_sexy.setLocation(x+110, y+230);
		b_phoneNum.setLocation(x+110, y+270);
		
		//��������������ѡ����λ��
		t_userID.setLocation(210, y+70);
		t_userID.setLocation(x+210, y+70);
		t_userName.setLocation(x+210, y+110);
		t_userPassword1.setLocation(x+210, y+150);
		t_userPassword2.setLocation(x+210, y+190);
		jcom_sexy.setLocation(x+210, y+230);
		t_phoneNum.setLocation(x+210, y+270);
		
		
		//���ð�ť��λ��
		btn_register.setLocation(x+130, y+330);
		btn_return.setLocation(x+250, y+330);
	}

	@Override
	public void addListener() {
		//���ذ�ť�¼�
		btn_return.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginJF("�û�");
				
			}
		});
		
		//ע�ᰴť�¼�
		btn_register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(t_userID.getText().length() == 0 || t_userName.getText().length() == 0 || t_userPassword1.getPassword().length == 0||t_userPassword2.getPassword().length==0||t_phoneNum.getText().length() == 0 ){
					JOptionPane.showMessageDialog(null, "������������Ϣ","��ʾ��", JOptionPane.ERROR_MESSAGE);
//					
				}else{
					//�õ�������ֵ
					String userID = t_userID.getText();
					String userName = t_userName.getText();
					String userPassword1 = new String(t_userPassword1.getPassword());
					String userPassword2 = new String(t_userPassword2.getPassword());
					String sexy = jcom_sexy.getSelectedItem().toString();
					String phoneNum = t_phoneNum.getText();
					
					
					int i = new RegisterService().register(userID, userName, userPassword1,userPassword2,sexy,phoneNum);
					switch(i){
					case 3:JOptionPane.showMessageDialog(null, "�Ѿ����ڸ��˺�", "��ʾ��", JOptionPane.ERROR_MESSAGE);
					break;
					case 2:JOptionPane.showMessageDialog(null, "�����������벻һ��","��ʾ��", JOptionPane.ERROR_MESSAGE);
					break;
					case 1:new LoginJF("�û�");
					dispose();
					JOptionPane.showMessageDialog(null, "ע��ɹ�", "��ʾ��", JOptionPane.PLAIN_MESSAGE);
					break;
					default :JOptionPane.showMessageDialog(null, "δ֪����", "��ʾ��", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				
				
			}
		});
		
		
	}

}
