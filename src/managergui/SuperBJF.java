package managergui;

import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import component.JButtonMe;
import component.JComboBoxMe;
import component.JFAction;
import component.JFrameMe;
import component.JLabel_B;

public class SuperBJF extends JFrameMe implements JFAction {
	//��������ǩ
	
	//��������ѡ��򣬲�ѯ��ť��Ԥ����ť���˳���ť
	
	//�������,�����������
	
	//�����ı���
	
	//��������ǩ
	private JLabel_B b = new JLabel_B("����ǩ");
	//��������ѡ��򣬲�ѯ��ť��Ԥ����ť���˳���ť
	private JButtonMe btn_find = new JButtonMe("Ԥ��");
	private JButtonMe btn_skip = new JButtonMe("��ӡ");
	private JButtonMe btn_re = new JButtonMe("����");
	private JComboBoxMe jcom = new JComboBoxMe();
	//�������,�����������
	private JTable table = new JTable();
	private JScrollPane jsc = new JScrollPane(table);
	//�����ı���
	private JTextArea ta = new JTextArea();
	private JScrollPane jsc_ta = new JScrollPane(ta);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SuperBJF(){
		init();
		setBack(new ImageIcon("image//����.jpg"));
		setModelForTable();
		setIconImage(new ImageIcon("image//103.png").getImage());
//		setVisible(true);//�������,��ɾ��
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SuperBJF();
	}
	/**
	 * ���ñ��
	 */
	public void setModelForTable(){
		String[] name = new String[]{
				"����1","����2","����3","����4"
		};
		
		DefaultTableModel model = new DefaultTableModel(name, 11);
		getTable().setModel(model);
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

	}

	@Override
	public void addComonent() {
		//��������ǩ
		con.add(getB());
		//��������ѡ��򣬲�ѯ��ť��Ԥ����ť���˳���ť
		con.add(getJcom());
		con.add(getBtn_find());
		con.add(getBtn_skip());
		con.add(getBtn_re());
		//��ӹ������
		con.add(jsc);
		//�����ı���
		con.add(jsc_ta);
	}

	@Override
	public void setLocate() {
		//��������ǩ
		getB().setLocation(xs+170, ys+20);
		//��������ѡ��򣬲�ѯ��ť��Ԥ����ť���˳���ť
		getJcom().setLocation(xs+30, ys+80);
		getBtn_find().setLocation(xs+140, ys+80);
		getBtn_skip().setLocation(xs+250, ys+80);
		getBtn_re().setLocation(xs+360, ys+80);
		//���ù������
		jsc.setSize(400, 200);
		jsc.setLocation(xs+42, ys+120);
		//�����ı���
//		getTa().setBounds(xs+42, ys+330, 400, 120);
		jsc_ta.setBounds(xs+42, ys+330, 400, 120);
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub

	}

	public JLabel_B getB() {
		return b;
	}

	public void setB(JLabel_B b) {
		this.b = b;
	}

	public JComboBoxMe getJcom() {
		return jcom;
	}

	public void setJcom(JComboBoxMe jcom) {
		this.jcom = jcom;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButtonMe getBtn_re() {
		return btn_re;
	}

	public void setBtn_re(JButtonMe btn_re) {
		this.btn_re = btn_re;
	}

	public JButtonMe getBtn_find() {
		return btn_find;
	}

	public void setBtn_find(JButtonMe btn_find) {
		this.btn_find = btn_find;
	}

	public JButtonMe getBtn_skip() {
		return btn_skip;
	}

	public void setBtn_skip(JButtonMe btn_skip) {
		this.btn_skip = btn_skip;
	}

	public JTextArea getTa() {
		return ta;
	}

	public void setTa(JTextArea ta) {
		this.ta = ta;
	}

}
