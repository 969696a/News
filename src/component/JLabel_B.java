package component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class JLabel_B extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JLabel_B(){
		setSize(350, 50);
		setFont(new Font("������κ", Font.BOLD, 35));
		setForeground(Color.WHITE);
		
		//��ɾ����
		setLocation(100, 100);
	}
	
	public  JLabel_B(String name){
		
		super(name);
		setSize(350, 50);
//		setFont(new Font("������κ", Font.BOLD, 35));
		setFont(new Font("����ϸ��", Font.BOLD, 35));
		setForeground(Color.WHITE);
		
		
		//��ɾ����
		setLocation(100, 100);
		
		
	}
}
