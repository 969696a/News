package component;

import java.sql.SQLException;

public interface JFAction {

		//��ʼ��
		public void init();
		//�������
		public void createComponent() throws SQLException;
		//��������jf��
		public void addComonent();
		//���������λ�úʹ�С
		public void setLocate();
		//Ϊ�������¼�
		public void addListener();
}
