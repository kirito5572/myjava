import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;

public class DocuInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocuInfo frame = new DocuInfo();
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
	public DocuInfo() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("제목(T):");
		lblNewLabel.setDisplayedMnemonic('T');
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setPreferredSize(new Dimension(60, 15));
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(31);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("주제(S):");
		label.setDisplayedMnemonic('S');
		label.setHorizontalTextPosition(SwingConstants.LEFT);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setPreferredSize(new Dimension(60, 15));
		panel_2.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(31);
		panel_2.add(textField_1);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label_1 = new JLabel("지은이(A):");
		label_1.setDisplayedMnemonic('A');
		label_1.setHorizontalTextPosition(SwingConstants.LEFT);
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setPreferredSize(new Dimension(60, 15));
		panel_3.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(21);
		panel_3.add(textField_2);
		
		JButton btny = new JButton("지은이(P)");
		btny.setMnemonic('P');
		btny.setPreferredSize(new Dimension(105, 23));
		panel_3.add(btny);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label_2 = new JLabel("날짜(M):");
		label_2.setDisplayedMnemonic('M');
		label_2.setHorizontalTextPosition(SwingConstants.LEFT);
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setPreferredSize(new Dimension(60, 15));
		panel_4.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(21);
		panel_4.add(textField_3);
		
		JButton button = new JButton("오늘 날짜(Y)");
		button.setMnemonic('Y');
		button.setPreferredSize(new Dimension(105, 23));
		panel_4.add(button);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label_3 = new JLabel("키워드(K):");
		label_3.setDisplayedMnemonic('K');
		label_3.setVerticalAlignment(SwingConstants.TOP);
		label_3.setPreferredSize(new Dimension(60, 15));
		label_3.setHorizontalTextPosition(SwingConstants.LEFT);
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		panel_5.add(label_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setPreferredSize(new Dimension(4, 51));
		textArea.setColumns(30);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_5.add(scrollPane);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label_4 = new JLabel("기타(E):");
		label_4.setDisplayedMnemonic('E');
		label_4.setVerticalAlignment(SwingConstants.TOP);
		label_4.setPreferredSize(new Dimension(60, 15));
		label_4.setHorizontalTextPosition(SwingConstants.LEFT);
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		panel_6.add(label_4);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setPreferredSize(new Dimension(4, 102));
		textArea_1.setColumns(30);
		
		JScrollPane scrollPane_1 = new JScrollPane(textArea_1);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_6.add(scrollPane_1);
		
	}

}
