package Student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Menu extends JFrame{
	private JScrollPane scrollpane;
	 private JButton button1, button2, button3,button4,button5;
	 private JPanel panel;
public static void main(String[] args) {
	new Menu().initView();
}
private void initView() {
	 
	 this.setTitle("ѧ����Ϣ����ϵͳ");
	 
	 /*id=new JLabel("ѧ��");
	 name=new JLabel("����");
	 school=new JLabel("ѧԺ");
	 date=new JLabel("��ѧ����");*/
	 button1=new JButton("���");
	 button2=new JButton("�޸�");
	 button3=new JButton("��ѯ");
	 button4=new JButton("ɾ��");
	 button5=new JButton("���");
	 panel=new JPanel();
	 panel.add(button1);
	 panel.add(button2);
	 panel.add(button3);
	 panel.add(button4);
	 panel.add(button5);
	 this.add(panel);
	 button1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new Add().view();
			
		}
	});
	 button2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new Change().view();
		}
	});
	 button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Ask();
			}
		});
	 button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Delete();
			}
		});
	 button5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Look().view();
				
			}
		});
	 this.setSize(450, 450);
	 this.setLocation(150, 150);
	 this.setVisible(true);

	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 
}

}
