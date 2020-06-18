package gui;

import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import service.MyGoodsService;
import component.JButtonMe;
import component.JFAction;
import component.JFrameMe;

public class UserJF extends JFrameMe implements JFAction{

	private JTabbedPane tab_pan = new JTabbedPane();
	private String userID;
	private UserResetJF userResetJF;
	private BooksNewsJF booksNewsJF;
	private MyGoodsJF myGoodsJF;
	private JButtonMe btn_tuichu =new JButtonMe("�˳�");
	public UserJF(){
		//�޲ε�Ĭ��Ϊ�˺�Ϊ111���û�
		userID = "111";
		init();
		setVisible(true);  //�������
	}
	
	public UserJF(String userID){
		//�޲ε�Ĭ��Ϊ�˺�Ϊ111���û�
		this.userID = userID;
		init();
		setIconImage(new ImageIcon("image//102.png").getImage());
		setVisible(true);  //�������
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UserJF();
	}

	@Override
	public void init() {
	
		try {
			setTitle("�û���������");
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

//	public void load(){
//		myGoodsJF.getTable().setModel(new MyGoodsService().setTableModel(userID));
//	}
	
	@Override
	public void createComponent() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addComonent() {
		//	���л������ӽ���
		con.add(tab_pan);
//		con.add(btn_tuichu);
		
	}

	@Override
	public void setLocate() {
		//�����л����Ĵ�С
		tab_pan.setSize(500, 500);
		
		// ��������ó�����ѡ��
		userResetJF = new UserResetJF(userID);
		booksNewsJF = new BooksNewsJF(userID);
		myGoodsJF = new MyGoodsJF(userID);
//		userResetJF.setUserJF(this);
//		booksNewsJF.setUserJF(this);
//		booksNewsJF.setUserJF(this);
		/**
		 * ����˳���ť
		 */
		userResetJF.setTuichuButton(this); 
		booksNewsJF.setTuichuButton(this);
		myGoodsJF.setTuichuButton(this);
		tab_pan.addTab("������Ϣ", userResetJF.getContentPane());
		tab_pan.addTab("���ı���", booksNewsJF.getContentPane());
		tab_pan.addTab("�鿴����", myGoodsJF.getContentPane());
//		tab_pan.addTab("�˳���¼", null);
		
		//���ð�ť����
		btn_tuichu.setLocation(400, 0);
		
		//�����л����͸��
//		tab_pan.setOpaque(false);
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		
		tab_pan.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				//���л�����ʱ����ˢ��һ���ҵ� ������
				myGoodsJF.load();
				
			}
		});
	}

}
