package ClientView;

import java.util.Vector;

public class TwoClientMannager {//���������пͻ��˷�����Ϣ�Ĳ���
private TwoClientMannager() {
}
public static Vector<TwoCharSocket> sockets=new Vector<>();
public static void sendAll(TwoCharSocket charSocket,String send) {
	for(TwoCharSocket s:sockets) {
		if(!charSocket.equals(s)) {//�ж��ǲ�������
			s.send(send);
		}
	}
}
}
