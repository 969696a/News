package gui;

import java.awt.Dialog.ModalExclusionType;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import service.BooksNewsService;
import util.UtilIM;
import component.JButtonMe;
import component.JDialogMe;
import component.JFAction;
import component.JFrameMe;
import component.JLabel_B;

public class BooksNewsJF extends JFrameMe implements JFAction{

	
	
	private JLabel_B b = new JLabel_B("���ı���");
	
	private JTable table = new JTable();
	private JScrollPane jsc = new JScrollPane(table);
	
	private JButtonMe btn_book = new JButtonMe("����");
	
	private String userID;
	private JDialogMe jd = null;
	
	public BooksNewsJF(){
		
		init();
		setBack(new ImageIcon("image//2.jpg"));
		setIconImage(new ImageIcon("image//102.png").getImage());
		
//		setVisible(true); //��������ɾ��
	}
	
	public BooksNewsJF(String userID) {
		// TODO Auto-generated constructor stub
		this.userID = userID;
		init();
		setBack(new ImageIcon("image//2.jpg"));
		
//		setVisible(true); //��������ɾ��
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BooksNewsJF("1");
		
	}

	public void setTuichuButton(UserJF userJF){
		//����˳���ť
		con.add(new UtilIM().getTuichuButton(userJF));
	}
	
	public void load(){
		
		//����ʱ���ñ�����ʽ
		//���Ϊ�������ݿ���еı�����
		table.setModel(new BooksNewsService().getTableModel());
		
	}
	
	@Override
	public void init() {
		
		try {
//			setTitle("�û���������");
			createComponent();
			addComonent();
			setLocate();
			addListener();
			load();
//			setBack(new ImageIcon("image//2.jpg"));
			
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
		con.add(jsc);
		con.add(btn_book);
		
		
	}

	@Override
	public void setLocate() {
		b.setLocation(150, 10);
		
		// ���÷ű���jsc������
		jsc.setSize(400, 300);
		jsc.setLocation(40, 70);
		//���ð�ť�Ĵ�С
		btn_book.setLocation(190, 380);
		
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		btn_book.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					JFrameMe jd = new UtilIM().out_jf(userID);
					jd.addWindowListener(new WindowListener() {
						
						@Override
						public void windowOpened(WindowEvent e) {
							// TODO Auto-generated method stub
							btn_book.setEnabled(false);
							
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
							
							btn_book.setEnabled(true);
						}
						
						@Override
						public void windowClosed(WindowEvent e) {
							// TODO Auto-generated method stub
							
							btn_book.setEnabled(true);
						}
						
						@Override
						public void windowActivated(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
					});
				
				 
				 
			}
		});
		
		
		
		
	}

}
