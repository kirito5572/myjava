import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.JList;

public class JFrame_ extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame_ frame = new JFrame_();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrame_() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel LocationCMD = new JPanel();
		contentPane.add(LocationCMD, BorderLayout.NORTH);
		
		JPanel LocationGUI = new JPanel();
		contentPane.add(LocationGUI, BorderLayout.WEST);
		
		JList list = new JList();
		LocationGUI.add(list);
		
		JPanel MainP = new JPanel();
		contentPane.add(MainP, BorderLayout.CENTER);
		
		JPanel FileSystem = new JPanel();
		contentPane.add(FileSystem, BorderLayout.SOUTH);
		FileSystem.setLayout(new BorderLayout(0, 0));
		
		JLabel FileExplorer = new JLabel("File Explorer");
		FileSystem.add(FileExplorer);
	}

}
