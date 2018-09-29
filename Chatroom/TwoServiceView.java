package ClientView;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class TwoServiceView extends JFrame implements ActionListener{
	private JButton btnOpen,btnStop;
	private JLabel label;
	private TwoService service=null;
	public static ArrayList<TwoClientView> clientviews=new ArrayList<>();
	private static TwoServiceView view;
	public static TwoServiceView getView() {
		return view;
	}
	public static void main(String[] args) {
		view=new TwoServiceView();
	}
	public TwoServiceView() {
		initView();
	}
	private void initView() {
		btnOpen=new JButton("�򿪷�����");
		btnStop=new JButton("�رշ�����");
		btnStop.setEnabled(false);
		btnOpen.addActionListener(this);
		btnStop.addActionListener(this);
		label=new JLabel("������ֹͣ����");
		add(label);
		add(btnOpen);
		add(btnStop);
		setTitle("������");
		setLayout(new GridLayout(3, 1,0,10));
		setSize(300, 300);
		setLocation(450, 450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnOpen) {
			open();
		}else {
			stop();
		}
	}
	public void open() {
		service=new TwoService();
		Thread thread=new Thread(service);
		thread.start();
		label.setText("��������������");
		btnOpen.setEnabled(false);
		btnStop.setEnabled(true);
	}
	public void stop() {
		label.setText("�������ѹر�");
		btnOpen.setEnabled(true);
		btnStop.setEnabled(false);
		try {
			synchronized (TwoClientMannager.sockets) {//ʹ��sockets��Ϊͬ�����������κ��߳̽���ͬ������������
				for(TwoCharSocket socket:TwoClientMannager.sockets) {//��ö�sockets������
					socket.getInputStream().close();
					socket.getOutputStream().close();
				}
				TwoClientMannager.sockets.removeAllElements();//ɾ�������е����пͻ�����Ϣ
			}
			for(TwoClientView view: clientviews) {
				view.getInputStream().close();
				view.getOutputStream().close();
			}
			service.getserviceSocket().close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
