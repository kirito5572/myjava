package use_MNEMONIC;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class JFrame_Mnemonic extends JFrame {
	public JFrame_Mnemonic() {
		super("문서 정보");
		JPanel Jp_title = new JPanel();
		JPanel Jp_A = new JPanel();
		JPanel Jp_M = new JPanel();
		JPanel Jp_K = new JPanel();
		JPanel Jp_E = new JPanel();
		JPanel Jp_side = new JPanel();
		JPanel Jp_Side = new JPanel();
		JButton Jb_P =new JButton("  지은이(P)  ");
		Jb_P.setMnemonic(KeyEvent.VK_P);
		JButton Jb_Y = new JButton("오늘 날짜(Y)");
		Jb_Y.setMnemonic(KeyEvent.VK_Y);
		JLabel Jl_T = new JLabel(" 제목(T):     ");
		Jl_T.setDisplayedMnemonic(KeyEvent.VK_T);
		JLabel Jl_S = new JLabel("주제(S):     ");
		Jl_S.setDisplayedMnemonic(KeyEvent.VK_S);
		JLabel Jl_A = new JLabel("지은이(A):");
		Jl_A.setDisplayedMnemonic(KeyEvent.VK_A);
		JLabel Jl_M = new JLabel(" 날짜(M):   ");
		Jl_M.setDisplayedMnemonic(KeyEvent.VK_M);
		JLabel Jl_K = new JLabel("키워드(K):");
		Jl_K.setDisplayedMnemonic(KeyEvent.VK_K);
		JLabel Jl_E = new JLabel(" 기타(E):    ");
		Jl_E.setDisplayedMnemonic(KeyEvent.VK_E);
		JTextField Jt_T = new JTextField(28);
		JTextField Jt_S = new JTextField(28);
		JTextField Jt_A = new JTextField(18);
		JTextField Jt_M = new JTextField(18);
		JTextArea Ja_K = new JTextArea(3,27);
		JScrollPane Sp_K = new JScrollPane(Ja_K,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JTextArea Ja_E = new JTextArea(6,27);
		JScrollPane Sp_E = new JScrollPane(Ja_E,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		Jp_A.setLayout(new BorderLayout());
		Jp_A.add(Jt_A,BorderLayout.WEST);
		Jp_A.add(Jb_P,BorderLayout.EAST);
		Jp_M.setLayout(new BorderLayout());
		Jp_M.add(Jt_M,BorderLayout.WEST);
		Jp_M.add(Jb_Y,BorderLayout.EAST);
		Jp_side.setLayout(new GridLayout(4,1));
		Jp_side.add(Jl_T);
		Jp_side.add(Jl_S);
		Jp_side.add(Jl_A);
		Jp_side.add(Jl_M);
		Jp_K.setLayout(new BorderLayout());
		Jp_K.add(Jl_K, BorderLayout.WEST);
		Jp_K.add(Sp_K, BorderLayout.EAST);
		Jp_E.setLayout(new BorderLayout());
		Jp_E.add(Jl_E, BorderLayout.WEST);
		Jp_E.add(Sp_E, BorderLayout.EAST);
		Jp_Side.setLayout(new BorderLayout(0,5));
		Jp_Side.add(Jp_K,BorderLayout.NORTH);
		Jp_Side.add(Jp_E,BorderLayout.SOUTH);
		Jp_title.setLayout(new BorderLayout());
		Jp_title.add(Jp_side,BorderLayout.WEST);
		Jp_title.add(Jp_Side,BorderLayout.SOUTH);
		setLayout(new BorderLayout());
		add(Jp_title,BorderLayout.CENTER);
		setSize(420,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JFrame_Mnemonic();
	}
}
