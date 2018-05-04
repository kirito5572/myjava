import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServerExam extends DatagramSocket {

	public UDPServerExam() throws SocketException {
		super(3000);
		byte[] data = new byte[65508];
		
		DatagramPacket dp = new DatagramPacket(data, data.length);
		System.out.println("waiting UDP Server");
		
		try {
			receive(dp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String msg = new String(dp.getData()).trim();
		System.out.println("보낸 주소:"+dp.getAddress());
		System.out.println("보낸 메시지:"+ msg);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new UDPServerExam();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
