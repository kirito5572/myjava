import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClientExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Sending message: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String msg = br.readLine();
		
		DatagramPacket dp = new DatagramPacket(msg.getBytes(),msg.getBytes().length,InetAddress.getByName("127.0.0.1"),3000);
		
		DatagramSocket ds = new DatagramSocket();
		ds.send(dp);
		
	}

}
