package Student;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Add extends JFrame{
	 private JLabel id,name,school,date;
	 private JTextField fieldid,fieldname,fieldschool,fielddate;
	 private JButton button1, button2;
	 private JPanel panelid,panelbutton,panelname,panelschool,paneldate;
	 private String driver;
		private String url;
		private String user;
		private String pass;
	 public void view() {
		 id=new JLabel("ѧ��");
		 name=new JLabel("����");
		 school=new JLabel("ѧԺ");
		 date=new JLabel("��ѧ����");
		 button1=new JButton("ȷ��");
		 button2=new JButton("����");
		 fieldid=new JTextField("",20);
		 fielddate=new JTextField("",20);
		 fieldname=new JTextField("",20);
		 fieldschool=new JTextField("",20);
		 panelbutton=new JPanel(new GridLayout(1,1));
		 panelid=new JPanel();
		 panelname=new JPanel();
		 panelschool=new JPanel();
		 paneldate=new JPanel();
		 panelbutton.add(button1);
		 panelbutton.add(button2);
		
		 panelid.add(id);
		 panelid.add(fieldid);
		 panelname.add(name);
		 panelname.add(fieldname);
		 panelschool.add(school);
		 panelschool.add(fieldschool);
		 paneldate.add(date);
		 paneldate.add(fielddate);
		 
		 button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn=null;
				String sql="insert into sd(id,name,schol,date)"+"values(?,?,?,?)";
         
				try {
				Properties props = new Properties();// �����ļ�����
				props.load(new FileInputStream("src\\jdbc.properties"));// ����һ���ļ�������
				driver = props.getProperty("driver");// ��ȡ���ݿ�����
				url = props.getProperty("url");// ��ȡ��Ҫ���������ݿ⼰����Ϣ
				user = props.getProperty("user");// ��ȡ�û���
				pass = props.getProperty("password");// ��ȡ����
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				try {
					Class.forName(driver);
					System.out.println("���ݿ����ӳɹ�");
					conn = DriverManager.getConnection(url, user, pass); 
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1,fieldid.getText());
                    ps.setString(2,fieldname.getText());
                    ps.setString(3,fieldschool.getText());
                    ps.setString(4,fielddate.getText());
                  
 
                    ps.executeUpdate();
				}catch(Exception e2){
					e2.printStackTrace();
				}finally {
					try{
                        conn.close();
                        System.out.println("MySQL �رճɹ�");
                    }catch (SQLException c){
                        System.out.println("MySQL �ر�ʧ�� ");
                        c.printStackTrace();
                    }
				}
			}
		});
		 button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fieldid.setText("");
				fieldname.setText("");
				fieldschool.setText("");
				fielddate.setText("");
				
			}
		});
		 
		 
		 this.setLayout(new GridLayout(9,1));
		 this.add(panelid);
		 this.add(panelname);
		 
		 this.add(panelschool);
		 this.add(paneldate);
		 this.add(panelbutton);
		 this.setSize(350, 300);
		 this.setLocation(300, 150);
		 this.setVisible(true);

		 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 } 
}
