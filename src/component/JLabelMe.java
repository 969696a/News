package component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class JLabelMe extends JLabel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JLabelMe(){
		setSize(100, 35);
//		setFont(new Font("������κ", Font.PLAIN, 20));
		setFont(new Font("����ϸ��", Font.BOLD, 20));
//		setForeground(Color.RED);
		
		//��ɾ����
//		setLocation(100, 100);
	}
	
	public  JLabelMe(String name){
		
		super(name);
		setSize(100, 35);
//		setFont(new Font("������κ", Font.PLAIN, 20));
		setFont(new Font("����ϸ��", Font.BOLD, 20));
//		setForeground(Color.RED);
		
		
		//��ɾ����
		setLocation(100, 100);
		
		
	}
	
}
