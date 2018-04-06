import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class NewV13 extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewV13 frame = new NewV13();
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
	public NewV13() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setForeground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lbName = new JLabel("이  름");
		panel.add(lbName);
		
		tfName = new JTextField();
		panel.add(tfName);
		tfName.setColumns(10);
		
		JButton btSearch = new JButton("검색");
		panel.add(btSearch);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btSave = new JButton("저장");
		panel_1.add(btSave);
		
		JButton btDelete = new JButton("삭제");
		panel_1.add(btDelete);
		
		JButton btModify = new JButton("수정");
		panel_1.add(btModify);
		
		JPanel panel_2 = new JPanel();
		JTextArea ta1 = new JTextArea("",9,60);
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.add(ta1);
	}

}
