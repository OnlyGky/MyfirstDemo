package ClientView;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;


public class TwoService implements Runnable{//���������������������
	private ServerSocket serversocket=null;
	public ServerSocket getserviceSocket() {
		return serversocket;
	}
public void run() {
	try {
		serversocket=new ServerSocket(9090);//������ͻ��˵�����
		while(true) {
			Socket socket=serversocket.accept();
			JOptionPane.showMessageDialog(TwoServiceView.getView(), "�ͻ������Ӷ˿�", "TIP", JOptionPane.INFORMATION_MESSAGE);
			TwoCharSocket chatsocket=new TwoCharSocket(socket);
			TwoClientMannager.sockets.add(chatsocket);//ÿ������һ�����Ӿͽ�����ӵ����Ӽ�����ȥ
			Thread thread=new Thread(chatsocket);//�����̲߳��Ͻ��տͻ�����Ϣ
			thread.start();//�������������ͨ��
		}
	}catch(IOException e) {
		e.printStackTrace();
		System.out.println("�������ر�");
	}
}
}
