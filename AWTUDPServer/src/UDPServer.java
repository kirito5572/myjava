import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPServer extends Frame implements WindowListener{

	TextArea ta;
	public UDPServer() {
		super("UDPServerChat");
		ta = new TextArea();
		add(ta);
		setSize(300,300);
		setVisible(true);
		
		addWindowListener(this);
	}
	
	public static void main(String[] args) throws Exception {
		UDPServer udp = new UDPServer();
		DatagramSocket ds = new DatagramSocket(3000);
		byte[] data = new byte[65508];
		DatagramPacket dp = new DatagramPacket(data, data.length);
		
		udp.ta.append("UDP server wainting"+"\n");
		while(true) {
			ds.receive(dp);
			String msg = new String(dp.getData()).trim();
			for(int i=0; i<msg.length();i++)
				data[i] = 0;
			udp.ta.append("Received from: " + dp.getAddress()+"\n");
			udp.ta.append("Received message: " + msg+"\n");
		}
		

	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
