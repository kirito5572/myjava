package TCPP;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TCPClientExam extends JFrame{
	public TCPClientExam() {
		super("TCP Client Program");
		
		JTextField inputTextField = new JTextField(15);
		JButton sendButton = new JButton("Send");
		setLayout(new FlowLayout());
		add(inputTextField);
		add(sendButton);
		sendButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// TODO Auto-generated method stub
					String msg = inputTextField.getText();
					inputTextField.setText("");
					InetAddress ia = InetAddress.getByName("127.0.0.1");
					Socket so = new Socket(ia, 5000);
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
					bw.write(msg);
					bw.flush();
					bw.close();
					so.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		
		setSize(350,75);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TCPClientExam te = new TCPClientExam();
	}

}
