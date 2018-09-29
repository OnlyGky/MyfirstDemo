package ClientView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TwoCharSocket implements Runnable{//�������������
private Socket socket=null;
private DataInputStream inputStream = null;
private DataOutputStream outputStream = null;
public DataInputStream getInputStream() {
	return inputStream;
}
public DataOutputStream getOutputStream() {
    return outputStream;
}
public TwoCharSocket(Socket socket) {
	this.socket=socket;
	 try {
         inputStream = new DataInputStream(socket.getInputStream());
         outputStream = new DataOutputStream(socket.getOutputStream());
     } catch (IOException e) {
         e.printStackTrace();
     }
}
public void send(String str) {//���ڽ����е���Ϣ�������˵������
	try {
		outputStream.writeUTF(str);
		outputStream.flush();
	}catch(IOException e) {
		e.printStackTrace();
	}
	
}
public void run() {
	String accept=null;
	while(true) {
		try {
			accept=inputStream.readUTF();
			TwoClientMannager.sendAll(this, accept);
		}catch(IOException e) {
			TwoClientMannager.sockets.remove(this);
		}
	}
}
}
