package Student;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

public class Delete extends JFrame{
	JFrame f=new JFrame();
	private String driver;
	private String url;
	private String user;
	private String pass;
	JLabel jlnumber = new JLabel("ѧ�ţ�");
    
    JTextField jtnumber = new JTextField("",20);
     
    JButton buttondelete = new JButton("ɾ��");
    JButton buttonreturn = new JButton("����");
    public Delete() {
    	 JPanel jpnumber = new JPanel();
         JPanel jpforbutton = new JPanel(new GridLayout(1,1));
          
         jpnumber.add(jlnumber);
         jpnumber.add(jtnumber);
          
         jpforbutton.add(buttondelete);
         jpforbutton.add(buttonreturn);
         buttondelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String number= jtnumber.getText();
				Connection conn=null;
				Resultset res=null;
				Statement stat=null;
				String sql="delete from sd where id='"+number+"'";
				
					Properties props=new Properties();
					try {
						props.load(new FileInputStream("src\\jdbc.properties"));
					 
					driver = props.getProperty("driver");// ��ȡ���ݿ�����
					url = props.getProperty("url");// ��ȡ��Ҫ���������ݿ⼰����Ϣ
					user = props.getProperty("user");// ��ȡ�û���
					pass = props.getProperty("password");
					conn=DriverManager.getConnection(url, user, pass);
					stat=conn.createStatement();
					stat.executeUpdate(sql);
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
				catch(EOFException e2) {
					e2.printStackTrace();
				}
				catch(FileNotFoundException e3) {
					e3.printStackTrace();
				} catch (IOException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			}
		});
         
         buttonreturn.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
            	 f.dispose();//���ٵ�ǰ����
         }});
         f.setTitle("ɾ��ѧ����Ϣ");
         f.setLayout(new GridLayout(9,1));
         f.add(jpnumber);
         f.add(jpforbutton);
        f.setLocation(400,300);
         f.setSize(350,300);
         f.setVisible(true);
    }
    
}
