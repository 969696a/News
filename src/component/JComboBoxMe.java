package component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;

public class JComboBoxMe extends JComboBox<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JComboBoxMe(){
		setSize(100, 35);
//		setFont(new Font("���ķ���", Font.BOLD, 17));
		setFont(new Font("����ϸ��", Font.BOLD, 17));
//		setForeground(Color.RED);
		
		//��ɾ����
//		setLocation(100, 100);
	}
	
	public JComboBoxMe(String[] name){
		super(name);
		setSize(100, 35);
//		setFont(new Font("���ķ���", Font.BOLD, 17));
		setFont(new Font("����ϸ��", Font.BOLD, 17));
//		setForeground(Color.RED);
		//��ɾ����
		setLocation(100, 100);
	}
}
