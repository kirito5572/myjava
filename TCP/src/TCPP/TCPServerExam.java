package TCPP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TCPServerExam extends JFrame {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			ServerSocket ss = new ServerSocket(5000);
			System.out.println("TCP Server Ready");
			Socket so = ss.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(so.getInputStream()));
			String msg = br.readLine();
			System.out.println("Send address: " + so.getInetAddress());
			System.out.println("Send message" + msg);
			so.close();
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
