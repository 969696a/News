package gui;

import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

import component.JFAction;
import component.JFrameMe;

public class ManagerJF extends JFrameMe implements JFAction {

	//����һ���л����
	JTabbedPane tab_pan = new JTabbedPane();
	//����һ��
	
	public ManagerJF(){
		init();
		setBack(new ImageIcon("image//2.jpg"));
		setTitle("����Ա��������");
		setIconImage(new ImageIcon("image//103.png").getImage());
		setVisible(true);//�������
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ManagerJF();
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

	@Override
	public void createComponent() throws SQLException {
		// TODO Auto-generated method stub
		tab_pan.add("¼�뱨��",null);
		tab_pan.add("¼�뱨��",null);
		tab_pan.add("��ѯ����",null);
		tab_pan.add("ͳ�ƹ���",null);
	}

	@Override
	public void addComonent() {
		// TODO Auto-generated method stub
		con.add(tab_pan);
	}

	@Override
	public void setLocate() {
		// TODO Auto-generated method stub
		tab_pan.setBounds(0, 0, 500, 500);
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub

	}

	

}
