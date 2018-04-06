import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerExample extends Frame implements ActionListener{

	Button b1 = new Button("Button");
	Panel p = new Panel();
	
	public ActionListenerExample() {

		super("ActionEvent");
		p.add(b1);
		add(p);
		setSize(300, 150);
		setVisible(true);
		b1.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == b1) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new ActionListenerExample();
	}

}
