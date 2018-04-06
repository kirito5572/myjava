import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

public class ButtonExample extends Frame{
	public ButtonExample() {
		// TODO Auto-generated constructor stub
		super("Button");
		Panel p = new Panel();
		Button b1 = new Button();
		Button b2 = new Button("Button2");
		b1.setLabel("Button1");
		
		p.add(b1);
		p.add(b2);
		add(p);
		setLocation(200, 200);
		setSize(250, 100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ButtonExample();
	}
}
