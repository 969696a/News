package gui;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import service.MyGoodsService;
import util.UtilIM;
import component.JButtonMe;
import component.JFAction;
import component.JFrameMe;
import component.JLabel_B;

public class MyGoodsJF extends JFrameMe implements JFAction{

	/**
	 * 
	 */
	
	private JLabel_B b = new JLabel_B("�ҵĶ���");
	
	private String userID;
	
	private JTable table = new JTable();
	
	private JScrollPane jsc = new JScrollPane(table);
	
	private JButtonMe btn_find = new JButtonMe("��ѯ");
	
	
	private static final long serialVersionUID = 1L;

	public MyGoodsJF(){
		init();
		setBack(new ImageIcon("image//3.jpg"));
		setVisible(true);  //����������ɾ��
	}
	
	public MyGoodsJF(String userID){
		this.userID = userID;
		init();
		setBack(new ImageIcon("image//3.jpg"));
		setIconImage(new ImageIcon("image//102.png").getImage());
//		con.setOpaque(true);
//		setVisible(true);  //����������ɾ��
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyGoodsJF();
	}

	public void load(){
		//ȥ���ݿ����Goods�����news��,users�����ҳ������������������� �������ۣ������ܼ� 
		
		//������л�����л�ʱ������ʹ�øö������load����
		table.setModel(new MyGoodsService().setTableModel(userID));
	}
	
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		try {
			createComponent();
			addComonent();
			setLocate();
			addListener();
			load();
//			con.setOpaque(false);
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
		con.add(getJsc());
		con.add(btn_find);
		
	}

	@Override
	public void setLocate() {
		// TODO Auto-generated method stub
		b.setLocation(150, 10);
//		b.setForeground(Color.black);
//		b.setFont(new Font("������κ", Font.BOLD, 35));
		// ���÷ű���jsc������
		getJsc().setSize(400, 300);
		getJsc().setLocation(40, 70);
		//���ð�ť�Ĵ�С
		btn_find.setLocation(190, 380);
		
	}

	public void setTuichuButton(UserJF userJF){
		//����˳���ť
		con.add(new UtilIM().getTuichuButton(userJF));
	}
	
	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JScrollPane getJsc() {
		return jsc;
	}

	public void setJsc(JScrollPane jsc) {
		this.jsc = jsc;
	}

}
