
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFrame_Mne extends JFrame {
	public JFrame_Mne() {
		super("문서 정보");
		JPanel Jp_title = new JPanel();
		JPanel Jp_A = new JPanel();
		JPanel Jp_M = new JPanel();
		JButton Jb_P =new JButton("지은이(P)");
		Jb_P.setMnemonic(KeyEvent.VK_P);
		JButton Jb_Y = new JButton("오늘 날짜(Y)");
		Jb_Y.setMnemonic(KeyEvent.VK_Y);
		JLabel Jl_T = new JLabel("제목(T):");
		Jl_T.setDisplayedMnemonic(KeyEvent.VK_T);
		JLabel Jl_S = new JLabel("주제(S):");
		Jl_S.setDisplayedMnemonic(KeyEvent.VK_S);
		JLabel Jl_A = new JLabel("지은이(A):");
		Jl_A.setDisplayedMnemonic(KeyEvent.VK_A);
		JLabel Jl_M = new JLabel("날짜(M):");
		Jl_M.setDisplayedMnemonic(KeyEvent.VK_M);
		JLabel Jl_K = new JLabel("키워드(K):");
		Jl_K.setDisplayedMnemonic(KeyEvent.VK_K);
		JLabel Jl_E = new JLabel("기타(E):");
		Jl_E.setDisplayedMnemonic(KeyEvent.VK_E);
		JTextField Jt_T = new JTextField(28);
		JTextField Jt_S = new JTextField(28);
		JTextField Jt_A = new JTextField(18);
		JTextField Jt_M = new JTextField(18);
		JTextArea Ja_K = new JTextArea(3,27);
		JScrollPane Sp_K = new JScrollPane(Ja_K,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JTextArea Ja_E = new JTextArea(6,27);
		JScrollPane Sp_E = new JScrollPane(Ja_E,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		Jp_A.setLayout(new FlowLayout());
		Jp_A.add(Jt_A);
		Jp_A.add(Jb_P);
		Jp_M.setLayout(new FlowLayout());
		Jp_M.add(Jt_M);
		Jp_M.add(Jb_Y);
		Jp_title.setLayout(new FlowLayout());
		Jp_title.add(Jl_T);
		Jp_title.add(Jt_T);
		Jp_title.add(Jl_S);
		Jp_title.add(Jt_S);
		Jp_title.add(Jl_A);
		Jp_title.add(Jp_A);
		Jp_title.add(Jl_M);
		Jp_title.add(Jp_M);
		Jp_title.add(Jl_K);
		Jp_title.add(Sp_K);
		Jp_title.add(Jl_E);
		Jp_title.add(Sp_E);
		setLayout(new BorderLayout());
		add(Jp_title,BorderLayout.CENTER);
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JFrame_Mne();
	}
}