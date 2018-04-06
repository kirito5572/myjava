package Data0406;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventExam extends Frame implements ActionListener {
	Button b;
	Button bt;
	public ActionEventExam() {
		super("ActionEventExample");
		Panel p = new Panel();
		b = new Button("Button");
		bt = new Button("Button2");
		p.add(b);
		p.add(bt);
		add(p);
		setSize(300, 150);
		setVisible(true);
		b.addActionListener(this);
		bt.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b) {
			System.exit(0);
		}
		if(e.getSource() == bt) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new ActionEventExam();
	}


}
