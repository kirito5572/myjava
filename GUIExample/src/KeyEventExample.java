import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventExample extends Frame implements KeyListener {

	TextField jumin1 = new TextField(10);
	Label label = new Label("-", Label.CENTER);
	TextField jumin2 = new TextField(10);
	Panel panel = new Panel();

	public KeyEventExample() {
		// TODO Auto-generated constructor stub
		super("KeyEvent");
		panel.add(jumin1);
		panel.add(label);
		panel.add(jumin2);
		add(panel);
		setSize(300, 100);
		setVisible(true);
		jumin1.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == e.VK_LEFT)
			jumin2.setText("Left is pressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (jumin1.getText().trim().length() == 6)
			jumin2.requestFocus();
	}

	public static void main(String[] args) {
		new KeyEventExample();
	}

}
