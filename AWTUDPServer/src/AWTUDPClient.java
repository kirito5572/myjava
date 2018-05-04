import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class AWTUDPClient extends Frame implements ActionListener, WindowListener {
	TextField tfInput;
	Button btSend;
	public AWTUDPClient() {
		// TODO Auto-generated constructor stub
		super("UDP Client");
		Label lb = new Label("Send Msg:");
		tfInput = new TextField(15);
		btSend = new Button("Send");
		setLayout(new FlowLayout());
		add(lb);
		add(tfInput);
		add(btSend);
		
		setSize(300,100);
		setVisible(true);
		addWindowListener(this);
		btSend.addActionListener(this);
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String msg = tfInput.getText();
		tfInput.setText("");
		try {
			DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length,
					InetAddress.getByName("127.0.0.1"), 3000);
			DatagramSocket ds = new DatagramSocket();
			ds.send(dp);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AWTUDPClient auc = new AWTUDPClient();
	}

}
