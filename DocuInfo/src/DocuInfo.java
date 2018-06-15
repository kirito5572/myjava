import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class DocuInfo extends JFrame {

	private JPanel contentPane;
	private JTextField tf_T;
	private JTextField tf_S;
	private JTextField tf_A;
	private JTextField tf_M;

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
		
		JPanel MainPanel = new JPanel();
		contentPane.add(MainPanel, BorderLayout.CENTER);
		MainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel p_T = new JPanel();
		p_T.setToolTipText("");
		MainPanel.add(p_T);
		p_T.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel l_T = new JLabel("제목(T):");
		l_T.setDisplayedMnemonic('T');
		l_T.setHorizontalTextPosition(SwingConstants.LEFT);
		l_T.setHorizontalAlignment(SwingConstants.LEFT);
		l_T.setPreferredSize(new Dimension(60, 15));
		p_T.add(l_T);
		
		tf_T = new JTextField();
		p_T.add(tf_T);
		tf_T.setColumns(31);
		
		JPanel p_S = new JPanel();
		MainPanel.add(p_S);
		p_S.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel l_S = new JLabel("주제(S):");
		l_S.setDisplayedMnemonic('S');
		l_S.setHorizontalTextPosition(SwingConstants.LEFT);
		l_S.setHorizontalAlignment(SwingConstants.LEFT);
		l_S.setPreferredSize(new Dimension(60, 15));
		p_S.add(l_S);
		
		tf_S = new JTextField();
		tf_S.setColumns(31);
		p_S.add(tf_S);
		
		JPanel p_A = new JPanel();
		MainPanel.add(p_A);
		p_A.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel l_A = new JLabel("지은이(A):");
		l_A.setDisplayedMnemonic('A');
		l_A.setHorizontalTextPosition(SwingConstants.LEFT);
		l_A.setHorizontalAlignment(SwingConstants.LEFT);
		l_A.setPreferredSize(new Dimension(60, 15));
		p_A.add(l_A);
		
		tf_A = new JTextField();
		tf_A.setColumns(21);
		p_A.add(tf_A);
		
		JButton bt_P = new JButton("지은이(P)");
		bt_P.setMnemonic('P');
		bt_P.setPreferredSize(new Dimension(105, 23));
		p_A.add(bt_P);
		
		JPanel p_M = new JPanel();
		MainPanel.add(p_M);
		p_M.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel l_M = new JLabel("날짜(M):");
		l_M.setDisplayedMnemonic('M');
		l_M.setHorizontalTextPosition(SwingConstants.LEFT);
		l_M.setHorizontalAlignment(SwingConstants.LEFT);
		l_M.setPreferredSize(new Dimension(60, 15));
		p_M.add(l_M);
		
		tf_M = new JTextField();
		tf_M.setColumns(21);
		p_M.add(tf_M);
		
		JButton bt_Y = new JButton("오늘 날짜(Y)");
		bt_Y.setMnemonic('Y');
		bt_Y.setPreferredSize(new Dimension(105, 23));
		p_M.add(bt_Y);
		
		JPanel p_K = new JPanel();
		MainPanel.add(p_K);
		p_K.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel l_K = new JLabel("키워드(K):");
		l_K.setVerticalTextPosition(SwingConstants.TOP);
		l_K.setVerticalAlignment(SwingConstants.TOP);
		l_K.setDisplayedMnemonic('K');
		l_K.setPreferredSize(new Dimension(60, 15));
		l_K.setHorizontalTextPosition(SwingConstants.LEFT);
		l_K.setHorizontalAlignment(SwingConstants.LEFT);
		p_K.add(l_K);
		
		JTextArea ta_K = new JTextArea();
		ta_K.setPreferredSize(new Dimension(4, 51));
		ta_K.setColumns(30);
		
		JScrollPane sc_K = new JScrollPane(ta_K);
		sc_K.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sc_K.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		p_K.add(sc_K);
		
		JPanel p_E = new JPanel();
		MainPanel.add(p_E);
		p_E.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel l_E = new JLabel("기타(E):");
		l_E.setVerticalTextPosition(SwingConstants.TOP);
		l_E.setVerticalAlignment(SwingConstants.TOP);
		l_E.setDisplayedMnemonic('E');
		l_E.setPreferredSize(new Dimension(60, 15));
		l_E.setHorizontalTextPosition(SwingConstants.LEFT);
		l_E.setHorizontalAlignment(SwingConstants.LEFT);
		p_E.add(l_E);
		
		JTextArea ta_E = new JTextArea();
		ta_E.setPreferredSize(new Dimension(4, 102));
		ta_E.setColumns(30);
		
		JScrollPane sp_E = new JScrollPane(ta_E);
		sp_E.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp_E.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		p_E.add(sp_E);
		
	}

}
